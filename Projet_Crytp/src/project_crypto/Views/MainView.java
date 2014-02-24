/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_crypto.Views;

import javax.swing.JFrame;

/**
 *
 * @author kimsavinfo
 */
public class MainView extends JFrame
{
    public MainView()
    {
        this.setTitle("CRYPTOGRAPHY");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(m_width, m_height);
    }
    
    /** ===================================================================
     * Properties
     */
    private int m_width = 700;
    private int m_height = 500;
}
