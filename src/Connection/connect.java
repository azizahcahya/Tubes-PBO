/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import model.*;
import tubesframebarubet.*;
 
/**
 *
 * @author Asus
 */
public class connect{
    private static Connection con;
    public static Connection configDB(){
        try{
            final String DB_URL = "jdbc:mysql://localhost/tubespbo";
            final String DB_USER = "root";
            final String DB_PASS = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        }catch(SQLException e){
            System.out.println("Koneksi ke Database Gagal..."+e.getMessage());
        }
        return con;
    }
}
