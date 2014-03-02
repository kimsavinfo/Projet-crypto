/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_crypto.Views;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 *
 * @author kimsavinfo
 */
public class TestView extends JPanel
{
    public TestView()
    {
        m_textFieldTest = new JFormattedTextField();
        m_textFieldTest.setPreferredSize(new Dimension(Global.m_widthWindow - 40, Global.m_heightJFormattedTextField));
        m_btnSendTest = new JButton("TEST");
        
        this.add(m_textFieldTest);
        this.add(m_btnSendTest);
    }
    
    public String GetTextTest()
    {
        return m_textFieldTest.getText();
    }
    
     /** ===================================================================
     * Listeners
     */
    public void AddSendTestListener(ActionListener p_listenForBtnSendTest)
    {
        m_btnSendTest.addActionListener(p_listenForBtnSendTest);
    }
    
    
    /** ===================================================================
     * Properties
     */
    private JFormattedTextField m_textFieldTest;
    private JButton m_btnSendTest;
    private String m_testResult;
}
