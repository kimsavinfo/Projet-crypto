/*
 * According to javadoc, Files.readAllLines :
 * Object Files is more appropriated for small files
 * However, its implementation uses buffering anyway
 * So it could be used for large files too...
 * => Code with Buffer in case
 */

package Library;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author kimsavinfo
 */
public class ReadWriteTextFile 
{
    
    public static void main(String[] args) throws IOException
    {
        // Create itself for test
        ReadWriteTextFile text = new ReadWriteTextFile();
        
    }
    
    
    
    /** ===================================================================
     * Properties
     */
    final static String m_inputFileName = "C:\\Temp\\testCrypto.txt";
    final static String m_outPutFileName = "C:\\Temp\\resultCrypto.txt";
    final static Charset m_encoding = StandardCharsets.UTF_8;
    final static int m_maxSizeSmallFile = 5000; // en octet, small file's maximum size
}
