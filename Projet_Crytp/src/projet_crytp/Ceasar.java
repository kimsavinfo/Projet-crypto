package projet_crytp;

/**
 * Created by nicolas on 24/02/14.
 */
public class Ceasar {
    private String m_alphabet[] = new String[]{"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T" ,"U", "V", "W", "X", "Y", "Z"};

    public String Crypting(String m_stringToCrypt, int p_crytingKey)
    {
        String cryptedString = null;
        for(int i = 0; i < m_stringToCrypt.length(); i++)
        {
            cryptedString = this.m_alphabet[i+p_crytingKey];
        }
        System.out.println(cryptedString);
        return cryptedString;
    }

    public String Uncrypting(String m_cryptedString)
    {
        String uncryptedString = null;
        return uncryptedString;
    }

}
