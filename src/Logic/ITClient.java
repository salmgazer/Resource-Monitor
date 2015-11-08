/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Salifu
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ITClient {
    
    private BufferedReader in;
    private PrintWriter out;
    private final JFrame frame = new JFrame("Capitalize Client");
    private final JTextField dataField = new JTextField(40);
    private final JTextArea messageArea = new JTextArea(8, 60);
    
    public ITClient() throws IOException{
        //layout
        messageArea.setEditable(false);
        frame.getContentPane().add(dataField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        
        //Add listener
        dataField.addActionListener(new ActionListenerImpl());
        
        //ITClient client = new ITClient();
        getStarted();
    }
    
    private void getStarted()throws IOException{
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
        this.iTConnect(); 
    }
    
    public void iTConnect() throws IOException{
    // Get the server address from a dialog box.
        String serverAddress = JOptionPane.showInputDialog(
            frame,
            "Enter IP Address of the Server:",
            "Welcome to the Capitalization Program",
            JOptionPane.QUESTION_MESSAGE);

        // Make connection and initialize streams
        Socket socket = new Socket(serverAddress, 9898);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Consume the initial welcoming messages from the server
        for (int i = 0; i < 3; i++) {
            messageArea.append(in.readLine() + "\n");
        }
    }

    /**
     * Runs the client application.
     * @param args
     * @throws java.lang.Exception
     */
    /*public static void main(String[] args) throws Exception {
        ITClient client = new ITClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.pack();
        client.frame.setVisible(true);
        client.iTConnect();
    }*/

    private class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent e){
            out.println(dataField.getText());
            String response;
            try{
                response = in.readLine();
                if(response == null || response.equals("")){
                    System.exit(0);
                }
            } catch (IOException ex){
                response = "Error: "+ex;
            }
            messageArea.append(response+"\n");
            dataField.selectAll();
        }
    }
}
