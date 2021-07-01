package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Santiago Castellanos
 */
public class Client {
    
    private Socket socket;

    public Client() {
        try {
            this.socket = new Socket("localhost", 50001);
            init();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init(){
        try {
            new DataOutputStream(this.socket.getOutputStream()).writeInt(0);
            String message;
            message = new DataInputStream(this.socket.getInputStream()).readUTF();
            System.out.println(message);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args){
        new Client();
    }
}
