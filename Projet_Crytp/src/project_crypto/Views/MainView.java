/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_crypto.Views;

import javax.swing.JPanel;
import java.awt.Color;
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
        this.setSize(Global.m_widthWindow, Global.m_heightWindow);
        this.setBackground(Color.GRAY);
        
        m_testView = new TestView();
        
        RefreshView(m_testView);
    }
    
    public void RefreshView(JPanel p_panel)
    {
        this.add(p_panel);
    }
    
    
    public void ShowTestView()
    {
        RefreshView(m_testView);
    }


    public TestView GetTestView()
    {
        return m_testView;
    }
    
    /** ===================================================================
     * Properties
     */
    private TestView m_testView;
}
