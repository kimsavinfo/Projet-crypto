/**
 *
 * @author kimsavinfo
 *
 * According to javadoc, Files.readAllLines :
 * Object Files is more appropriated for small files
 * However, its implementation uses buffering anyway
 * So it could be used for large files too...
 * => Code with Buffer in case
 * 
 * All "throws IOException" are in case the user erased
 * the file during one operation
 * 
 * e.printStackTrace(); put in order to be sure 
 * if the bug is only an unfind file
 */

package Library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;


public class TextFileManager
{
    
    public TextFileManager(String p_inputFilePath, String p_outputFilePath)
    { 
        if(isInputFileConform(p_inputFilePath))
        {
            m_inputFile = new File(p_inputFilePath);
            m_outputPath = p_outputFilePath;
        }
    }
    
    public boolean isInputFileConform(String p_inputFilePath)
    {
        boolean fileConform = false;
        
        if(p_inputFilePath.endsWith(".txt"))
        {  
            try
            {
                File fileName = new File("C:\\TEMP\\"+p_inputFilePath);
                fileConform = true;
            }
            catch(Exception e)
            {
                // File not found
                JOptionPane.showMessageDialog(null,"File not found");
                e.printStackTrace();
            }
        }
        else
        {
            // File is not a .txt
            JOptionPane.showMessageDialog(null,"The file is not a text");
        }
        
        return fileConform;
    }
    
    public boolean isInputFileSaved() throws IOException
    {
        System.out.println("DEBUG : "+m_inputFile.getPath());
        
        return m_inputFile.exists();
    }
    
    public String getInputFileString() throws IOException
    {
        String inputString = "";
                
        if(isInputFileSaved())
        {
            // Parse siez in double in case
            double inputSize = m_inputFile.length();

            if(inputSize > 0)
            {
                if(inputSize < m_maxSizeByte)
                {
                    // Small file will be read line by line
                    inputString = smallFileToString(m_inputFile);
                }
                else
                {
                    // Large file will need a buffer
                    inputString = largeFileToString(m_inputFile);
                }
            }
        }
        
        return inputString;
    }
    
    private String smallFileToString(File p_File)
    {
        try
        {
            Path path = Paths.get(p_File.getPath());
            return new StringManager().listStringToString(Files.readAllLines(path, m_encoding));
        }
        catch(IOException e)
        {
    	    JOptionPane.showMessageDialog(null,"Small file not found");
            e.printStackTrace();
            return "";
    	}
    }
    
    private String largeFileToString(File p_File)
    {
        Path path = Paths.get(p_File.getPath());
        
        try
        {
            BufferedReader reader = Files.newBufferedReader(path, m_encoding);
            return new StringManager().bufferedReaderToString(reader);
        }
        catch(IOException e)
        {
             JOptionPane.showMessageDialog(null,"Large file not found");
             e.printStackTrace();
             return "";
        }
    }
    
    public void writeFile(String p_text)
    {  
        List<String> text = new StringManager().chunkString(p_text);
                
        if(text.size() < m_maxSizeList)
        {
            writeSmallFile(text);
        }
        else
        {
            writeLargeFile(text);
        }
    }
    
    private void writeSmallFile(List<String> p_text)
    {
        try
        {
            Path path = Paths.get(m_outputPath);
            Files.write(path, p_text, m_encoding);
            
            JOptionPane.showMessageDialog(null,"Small file saved in : "+m_outputPath);
        }
        catch(IOException e)
        {
    	    e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR : small file not saved");
    	}
    }
    
    private void writeLargeFile(List<String> p_text)
    {
        try
        {
            Path path = Paths.get(m_outputPath);
            BufferedWriter writer = Files.newBufferedWriter(path, m_encoding);
            
            for(String line : p_text){
                writer.write(line);
                writer.newLine();
            }
            
            JOptionPane.showMessageDialog(null,"Large file saved in : "+m_outputPath);
        }
        catch(IOException e)
        {
    	    e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR : Large file not saved");
    	}
    }
    
    public boolean isOutpuFileReady()
    {
        boolean ready = false;
        
         try
        {
            PrintWriter writer = new PrintWriter(m_outputPath, "UTF-8");
            writer.println("");
            writer.close();
            
            ready = true;
        }
        catch(IOException e)
        {
    	    e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR : ");
    	}
         
         return ready;
    }
       
    
    /** ===================================================================
     * Properties
     */
    private File m_inputFile;
    private String m_outputPath;
    private Charset m_encoding = StandardCharsets.UTF_8;
    private double  m_maxSizeByte = 5000.0; // in byte, small file's maximum size
    private int  m_maxSizeList = 5; // int, small file's maximum List<String>
}
