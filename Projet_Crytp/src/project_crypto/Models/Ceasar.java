package project_crypto.Models;

import java.util.List;

/**
 * Created by nicolas on 24/02/14.
 */
public class Ceasar
{

    private String m_encryptedString = "";
    private String m_uncryptedString = "";
    private int m_cryptingKey = 0;


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
        System.out.println("Crypted string : " + this.m_encryptedString);
        return this.m_encryptedString;
    }


    public String Uncrypting(String p_stringToDecrypt, int p_decryptingKey)
    {
        this.m_uncryptedString = "";
        for(int i = 0; i <p_stringToDecrypt.length(); i++)
        {
            for(int j = 0; j < WordToNormalize.m_alphabet.length; j++)
            {
                if(WordToNormalize.m_alphabet[j].equals(Character.toString(p_stringToDecrypt.charAt(i))))
                {
                    this.m_uncryptedString += WordToNormalize.m_alphabet[moduloPositiv(j-p_decryptingKey, WordToNormalize.m_alphabet.length)];
                }
            }
        }
        System.out.print("Uncrypted string with key: "+this.m_uncryptedString);
        return this.m_uncryptedString;
    }

    public int findCryptingKey(String p_stringToDecrypt)
    {
        String uncryptTest = "";
        String reEncrypt = "";
        int key = 0;
        boolean res = false;
        System.out.println("p_stringToDecrypt = "+p_stringToDecrypt);
        for(int i = 0; i < WordToNormalize.m_alphabet.length; i++)
        {
            uncryptTest = this.Uncrypting(p_stringToDecrypt, i);
            System.out.println("decryptText = "+uncryptTest);
            System.out.println("reEncrypt = "+reEncrypt);
            System.out.println("i = "+ i);
            System.out.println();
            reEncrypt = this.Crypting(p_stringToDecrypt, i);
            if(uncryptTest.equals(reEncrypt))
            {
                System.out.println("dans le if");
                res = true;
                key = i;
            }
        }
        System.out.println("Key found : "+key);
        return key;
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
