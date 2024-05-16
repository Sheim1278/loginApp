/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project31;

import java.net.* ; 
import java.io.* ; 



/**
 *
 * @author Me
 */
public class Tcpserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
        try {
            String username = " " ;
            String password =  "" ;
            String msg = " " ;
            ServerSocket s = new ServerSocket(1500) ; 
            System.out.println("Waiting for client on port"+s.getLocalPort());
            Socket s1 = s.accept() ;

            while(true) {
//            Socket s1 = s.accept() ;
//            System.out.println("just connected to "+s1.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(s1.getInputStream()) ;
            String st = in.readUTF() ; 
            System.out.println(st) ;
            username = in.readUTF() ;
            System.out.println(username) ;
            password = in.readUTF() ; 
            System.out.println(password) ;
            
            if(username.equals("shimaa saad sayed elmalah") && password.equals("sec2_43243047")) {
                msg = "You have successfully logged in" ; 
                System.out.println(msg) ;}
            
            else {msg = "Invalid username or password";
            System.out.println(msg);}
            
            DataOutputStream out  = new DataOutputStream(s1.getOutputStream()) ; 
            out.writeUTF(msg);
            if(in.readUTF()=="Done")
            {s1.close() ;}
        }}
    
        catch(Exception e) {
            
            System.out.println(e.toString()) ; 
       
        }
    }}
    
           
    
    

