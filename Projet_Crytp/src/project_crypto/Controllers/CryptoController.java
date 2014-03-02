/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_crypto.Controllers;

import Library.TextFileManager;
import project_crypto.Views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kimsavinfo
 */
public class CryptoController 
{
    public static void main(String[] args)
    {
        // Fic import
        
        // View exemple
        /*m_mainView = new MainView();
        m_mainView.setVisible(true);
        m_mainView.GetTestView().AddSendTestListener(new TextTestListener());
        
        m_mainView.ShowTestView();*/

        // Load file
        TextFileManager textFileManager = new TextFileManager();
        textFileManager.LoadFile("/home/kimsavinfo/git/Projet-crypto/Projet_Crytp/src/Test_TextFiles/ceasar.txt");
        textFileManager.LetterFrequency();
        // textFileManager.WriteFile(logFile.getCanonicalPath()); = ok works
        textFileManager.WriteFile("/home/kimsavinfo/git/Projet-crypto/Projet_Crytp/src/Test_TextFiles/");


        /*Ceasar test = new Ceasar();
        System.out.println(test.Crypting("ZZ", 2));
        
        WordToNormalize testWord = new WordToNormalize();
        System.out.print(testWord.sansAccent("l'oracle est Néo !"));*/
 
    }

    static class TextTestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(m_mainView.GetTestView().GetTextTest());
        }
    }

    
    private static MainView m_mainView;
}
