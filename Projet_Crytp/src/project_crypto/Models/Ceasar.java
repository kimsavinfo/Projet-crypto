package project_crypto.Models;

import java.util.List;

/**
 * Created by nicolas on 24/02/14.
 */
public class Ceasar {

    private static String m_alphabet[] = new String[]{"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T" ,"U", "V", "W", "X", "Y", "Z"};
    private String m_encryptedString = "";
    private String m_decryptedString = "";

    public String Crypting(String p_stringToCrypt, int p_crytingKey)
    {
        for(int i = 0; i < p_stringToCrypt.length(); i++)
        {
            for(int j = 0; j < m_alphabet.length; j++)
            {
                if(m_alphabet[j].equals(Character.toString(p_stringToCrypt.charAt(i))))
                {
                    this.m_encryptedString += m_alphabet[(j+p_crytingKey)%m_alphabet.length];
                }
            }
        }
        return this.m_encryptedString;
    }


    public String Decrypting(String p_stringToDecrypt, int p_decryptingKey)
    {
        for(int i = 0; i <p_stringToDecrypt.length(); i++)
        {
            for(int j = 0; j < m_alphabet.length; j++)
            {
                System.out.println(modulo(j-p_decryptingKey, m_alphabet.length));
            }
        }
        return this.m_decryptedString;
    }

    public static int modulo(int p_number, int p_modulo)
    {
        int result = p_number%p_modulo;
        if(result < 0)
        {
            result += p_modulo;
        }
        return result;
    }



}
