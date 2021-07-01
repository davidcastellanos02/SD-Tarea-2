package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Santiago Castellanos
 */
public class Server {
    
    private ServerSocket server;
    
    public Server() {
        try {
            this.server = new ServerSocket(50001);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();
    }
    
    private void init(){
        new Thread(new Runnable(){
            public void run(){
                while(!server.isClosed()){
                    try {
                        listen(server.accept());
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
        
    }
    
    private void listen(Socket conn){
        String list[] = {"Lola", "Pepe", "Lolo", "Juan"};
        try {
            int pos = new DataInputStream(conn.getInputStream()).readInt();
            new DataOutputStream(conn.getOutputStream()).writeUTF(list[pos]);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        new Server();
    }
    
}