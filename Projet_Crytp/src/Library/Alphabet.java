package Library;

/**
 * Created by kimsavinfo on 01/03/14.
 */
public class Alphabet
{
    public Alphabet()
    {
        m_latin = new String[]{"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T" ,"U", "V", "W", "X", "Y", "Z"};
    }

    public String[] GetLatin()
    {
        return m_latin;
    }

    /** ===================================================================
     * Properties
     */
    private static String[] m_latin;
}
