/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Salifu
 */
public class ITSolver extends Thread{
    private Socket socket;
    private int clientNumber;
    
    public ITSolver(Socket socket, int clientNumber){
        this.socket = socket;
        this.clientNumber = clientNumber;
        log("New connection with client# "+clientNumber+" at "+socket);
    }
    
    public void run(){
        try{
            BufferedReader in = new BufferedReader( new InputStreamReader(this.socket.getInputStream()));
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            
            //write to client
            out.println("Hello, you are client number #"+clientNumber+".");
            out.println("Enter a line with a period to quit");
            
            while(true){
                String input;
                input = in.readLine();
                if(input.equals(".")){
                    break;
                }
                out.println("I must capitalize");
                System.out.println(input);
                out.println(input.toUpperCase());
            }
        } catch(IOException e){
            log("Error handling client# "+clientNumber+".");
        } finally{
            try{
                socket.close();
            } catch(IOException e){
                log("could not close socket, what is going on");
            }
            log("connection with client#"+clientNumber+" closed");
        }
    }
    
    private void log(String message){
        System.out.println(message);
    }
}
