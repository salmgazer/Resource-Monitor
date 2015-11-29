/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.BorderLayout;
import java.awt.Component;

/**
 *
 * @author Salifu
 */
public class Hello {
    
    public static void main(String[] args){
        //System.out.println("Sal");

        views.Home home = new views.Home();
        home.setLayout(new BorderLayout());
        Demo mydem = new Demo();
        Demo mydem1 = new Demo();
        Demo mydem2 = new Demo();
        
        home.add(mydem.getSupport().getChart(), BorderLayout.NORTH);
        home.add(mydem1.getSupport().getChart(), BorderLayout.CENTER);
        home.add(mydem2.getSupport().getChart(), BorderLayout.SOUTH);
        //home.setGraph((Component)mydem.getSupport().getChart());
        home.setVisible(true);
        
        
    }
}
