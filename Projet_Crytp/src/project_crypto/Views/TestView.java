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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kimsavinfo
 */
public class TestView extends JPanel
{
    public TestView()
    {
        textFieldTest = new JFormattedTextField();
        textFieldTest.setPreferredSize(new Dimension(Global.m_widthWindow - 40, Global.m_heightJFormattedTextField));
        btnSendTest = new JButton("TEST");
        
        this.add(textFieldTest);
        this.add(btnSendTest);
    }
    
    public String GetTextTest()
    {
        return textFieldTest.getText();
    }
    
     /** ===================================================================
     * Listeners
     */
    public void AddSendTestListener(ActionListener p_listenForBtnSendTest)
    {
        btnSendTest.addActionListener(p_listenForBtnSendTest);
    }
    
    
    /** ===================================================================
     * Properties
     */
    private JFormattedTextField textFieldTest;
    private JButton btnSendTest;
    private String m_testResult;
}
