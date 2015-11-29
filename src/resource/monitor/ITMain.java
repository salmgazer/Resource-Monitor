/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.monitor;

import logic.ITServer;
import logic.ITClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salifu
 */
public class ITMain implements Runnable{
    //ITServer serve;
    //ITClient client;
    
    public ITMain() throws Exception{
        //serve = new ITServer();
        //client = new ITClient();
    }
    
    public static void main(String[] args) throws Exception{
        //ITMain monitorResource = new ITMain();
        Thread serverThread = new Thread(new Runnable() {
            public void run() {
                try {
                    /*
                    * Start server
                    */   
                    ITServer serve = new ITServer();
                } catch (Exception ex) {
                    Logger.getLogger(ITMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread clientThread = new Thread(new Runnable() {
            public void run() {
                try {
                    /*
                    * Start client
                    */   
                    ITClient client = new ITClient();
                } catch (IOException ex) {
                    Logger.getLogger(ITMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        serverThread.start();
        clientThread.start();
        
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
