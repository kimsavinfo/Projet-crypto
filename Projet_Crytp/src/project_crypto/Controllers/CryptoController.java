/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_crypto.Controllers;

import project_crypto.Models.Ceasar;
import project_crypto.Models.WordToNormalize;
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
       /* mainView = new MainView();
        mainView.setVisible(true);
        
        mainView.ShowTestView();*/

        Ceasar test = new Ceasar();
        System.out.println(test.Crypting("ZZ", 2));
        
        WordToNormalize testWord = new WordToNormalize();
        System.out.print(testWord.sansAccent("l'oracle est Néo !"));
 
    }

    
    private static MainView mainView;
}
