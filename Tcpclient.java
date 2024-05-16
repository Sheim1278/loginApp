/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import project31.Tcpserver;
import project31.Tcpserver;



/**
 *
 * @author Me
 */
public class Tcpclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            
        }
    
    public String login (String username,String password) {
        
        String msg = "" ; 
          Tcpserver s = new Tcpserver() ;
         Thread serverThread = new Thread(() -> {
            s.main(null);
        });
        serverThread.start();
    
     try {
       
      
        Socket client = new Socket("LOCALHOST",1500) ;
        
        System.out.println("connecting to localhost on port "+client.getPort());
        
        System.out.println("just connectd to "+client.getRemoteSocketAddress()) ; 
        
        OutputStream outtoserver = client.getOutputStream() ;
        
        DataOutputStream out = new DataOutputStream(outtoserver);
        
        out.writeUTF("HELLO FROM "+client.getLocalSocketAddress());
        out.writeUTF(username) ; 
        System.out.println(username) ;

        out.writeUTF(password) ; 
        System.out.println(password) ;

        DataInputStream in = new DataInputStream(client.getInputStream()) ;
        
        msg = in.readUTF() ; 
        System.out.println("server say: " + msg) ;
        
            
        out.writeUTF("Done"); 
        
        in.close() ; 
        out.close() ;
        client.close();
        }
     
        catch(IOException e) {
        System.out.println(e.toString()) ;
        }
     
     
     
     
     return msg ; 
    
    } 
}

    
    

