package Library;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by kimsavinfo on 01/03/14.
 */
public class TextFileManager
{
    public TextFileManager()
    {
        m_text = "";
        m_nbLine = 0;
    }

    /**
     * Assign a text directly, not by loading a file
     * Usefull for the output text
     * @param p_text
     */
    public void SetText(String p_text)
    {
        m_text = p_text;
        StringTokenizer stringTokenizer = new StringTokenizer(m_text, System.getProperty("line.separator"));
        m_nbLine = stringTokenizer.countTokens();
    }


    /**
     * Load text from a file if it exists
     * @param p_filePath
     */
    public void LoadFile(String p_filePath)
    {
        StringBuffer fileContents = new StringBuffer();

        try
        {
            FileReader fileReader = new FileReader(p_filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ( (line = bufferedReader.readLine()) != null )
            {
                fileContents.append(line).append(System.getProperty("line.separator"));
                m_nbLine++;
            }
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "File not found");
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "IOException : "+e.getMessage());
        }

        m_text = fileContents.toString();
    }

    public int TextLength()
    {
        return m_text.length();
    }

    public int GetNbLine()
    {
        return m_nbLine;
    }

    public int CountWords()
    {
        StringTokenizer stringTokenizer = new StringTokenizer(m_text);
        return stringTokenizer.countTokens();
    }

    /**
     * Number of characters [A..Z] int the text
     * Punctuation and empty space are not counted
     * @return
     */
    public int CountCharacters(HashMap<String, Float> letterPresence)
    {
        int total = 0;

        for(Map.Entry<String, Float> entry : letterPresence.entrySet()) {
            total += entry.getValue();
        }

        return total;
    }


    /**
     * Calculate the frequency (%) of each alphabet's character in the text
     * Map <letter, frequency>
     * @return
     */
    public HashMap<String, Float>  LetterFrequency()
    {
        HashMap<String, Float> frequency = LetterPresence();
        int totalLetters = CountCharacters(frequency);

        // Test = MUST BE DELETED/ERASE
        System.out.println(" LetterFrequency Total : "+totalLetters);

        for (String key : frequency.keySet()) {

            System.out.println("key: " + key + " value: " + frequency.get(key) +" times so : "+frequency.get(key)/totalLetters+" % ");
        }

        return frequency;
    }

    /**
     * How many times each letter is present in the text ?
     * @return
     */
    public HashMap<String, Float>  LetterPresence()
    {
        HashMap<String, Float> presence = new HashMap<String, Float>();
        String[] alphabet = new Alphabet().GetLatin();

        // Initialize the dico frequency
        int alphabetLenght = alphabet.length;
        for(int iLetter = 0; iLetter < alphabetLenght; iLetter++)
        {
            presence.put(alphabet[iLetter], (float)0);
        }

        String textUpperCase = m_text.toUpperCase();
        String key = null;
        Float value = (float)0;

        int textLenght = m_text.length();
        for(int iText = 0; iText < textLenght; iText++)
        {
            key = Character.toString( textUpperCase.charAt(iText) );

            if( presence.containsKey(key) )
            {
                value = presence.get(key);
                value++;

                presence.put(key, (float)value );
            }
        }

        return presence;
    }

    /**
     * will override any existing files
     */
    public void WriteFile(String p_path)
    {
        BufferedWriter writer = null;
        try {
            // Create temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(p_path+timeLog+".txt");

            // Show where we can find the file
            System.out.println("File path : "+logFile);

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("Lorem Ipsum");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                // Always close the writer
                writer.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }





    /** ===================================================================
     * Properties
     */
    private String m_text;
    private int m_nbLine;

}
