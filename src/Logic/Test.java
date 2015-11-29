/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JPanel;

/**
 *
 * @author Salifu
 */
public class Test{
    
    public Test(){
        views.Home home = new views.Home();
        //home.setLayout(new BorderLayout());
        
        home.setVisible(true);

    }
    
    public static void main(String args[]){
        new Test();
    }
}
