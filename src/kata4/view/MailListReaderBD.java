/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;

/**
 *
 * @author José Roberto Jiménez
 */
public class MailListReaderBD {
    
    public static List<Mail> read(){
        List<Mail> mailList = new ArrayList<>();
        Connection conn=conectar("jdbc:sqlite:Kata5.db");
        String sql = "SELECT * FROM direcc_email";
        try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                mailList.add(new Mail(rs.getString("direccion")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        close(conn);
        return mailList;
    }
    
    
    
    
    private static  Connection conectar(String url){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage() +"\tNo se ha podido establecer coneccion.");
        } 
        
        return conn;
    }
    

    private static void close(Connection conn) {
            try {
                if (conn != null) {
                conn.close();
                
                System.out.println("Connexión a SQLite cerrada");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
}
