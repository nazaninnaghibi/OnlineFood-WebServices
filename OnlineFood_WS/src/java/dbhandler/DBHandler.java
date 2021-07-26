/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandler;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 14168
 */
public class DBHandler {
     static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("driver problem " + e.getMessage());
        }
    }
     
     public Statement getConnection(){
         
    String url="jdbc:mysql://localhost:3306/restaurant?zeroDateTimeBehavior=convertToNull&useSSL=false";
    String username="root";
    String password="12345";
    try{
     Connection myConc = DriverManager.getConnection(url,username, password);
            Statement mystat =    (Statement) myConc.createStatement();
            return mystat;
    }
    catch(Exception e){System.out.println("[----me---]getconnection problem : " + e.getMessage());}
    return null;
}
     
}
