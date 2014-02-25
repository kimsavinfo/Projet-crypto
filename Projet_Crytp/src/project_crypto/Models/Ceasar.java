package project_crypto.Models;

import java.util.List;

/**
 * Created by nicolas on 24/02/14.
 */
public class Ceasar {


    private String m_encryptedString = "";
    private String m_decryptedString = "";

    public String Crypting(String p_stringToCrypt, int p_crytingKey)
    {
        this.m_encryptedString = "";
        for(int i = 0; i < p_stringToCrypt.length(); i++)
        {
            for(int j = 0; j < WordToNormalize.m_alphabet.length; j++)
            {
                if(WordToNormalize.m_alphabet[j].equals(Character.toString(p_stringToCrypt.charAt(i))))
                {
                    this.m_encryptedString += WordToNormalize.m_alphabet[(j+p_crytingKey)%WordToNormalize.m_alphabet.length];
                }
            }
        }
        return this.m_encryptedString;
    }


    public String Decrypting(String p_stringToDecrypt, int p_decryptingKey)
    {
        this.m_decryptedString = "";
        for(int i = 0; i <p_stringToDecrypt.length(); i++)
        {
            for(int j = 0; j < WordToNormalize.m_alphabet.length; j++)
            {
                if(WordToNormalize.m_alphabet[j].equals(Character.toString(p_stringToDecrypt.charAt(i))))
                {
                    this.m_decryptedString += WordToNormalize.m_alphabet[moduloPositiv(p_decryptingKey, WordToNormalize.m_alphabet.length)];
                }
            }
        }
        return this.m_decryptedString;
    }


    public static int moduloPositiv(int p_number, int p_modulo)
    {
        //This function prevents the return of a negativ modulo from the classic modulo function
        int result = p_number%p_modulo;
        if(result < 0)
        {
            result += p_modulo;
        }
        return result;
    }



}
