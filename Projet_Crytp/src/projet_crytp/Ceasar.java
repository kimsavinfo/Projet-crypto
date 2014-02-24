package projet_crytp;

import java.util.List;

/**
 * Created by nicolas on 24/02/14.
 */
public class Ceasar {

    private String m_alphabet[] = new String[]{"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T" ,"U", "V", "W", "X", "Y", "Z"};
    private String m_encryptedString = "";

    public void Crypting(String p_stringToCrypt, int p_crytingKey)
    {
        for(int i = 0; i < p_stringToCrypt.length(); i++)
        {
            for(int j = 0; j < this.m_alphabet.length; j++)
            {
                if(this.m_alphabet[j].equals(Character.toString(p_stringToCrypt.charAt(i))))
                {
                    this.m_encryptedString += this.m_alphabet[j+p_crytingKey];
                    
                }
            }
        }
    }


}
