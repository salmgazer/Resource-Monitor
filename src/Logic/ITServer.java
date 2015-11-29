/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.net.ServerSocket;

/**
 *
 * @author Salifu
 */
public class ITServer {
    
    public ITServer()throws Exception{
        System.out.println("The IT Manager Server is running");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        //Socket  client = new Socket("10.10.43.174", 7585);
        try{
            while(true){
                new ITSolver(listener.accept(), clientNumber++).start();
            }
        } finally{
            listener.close();
        }
    }
    public static void main(String[] args) throws Exception{
        System.out.println("The IT Manager Server is running");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        try{
            while(true){
                new ITSolver(listener.accept(), clientNumber++).start();
            }
        } finally{
            listener.close();
        }
    }
}