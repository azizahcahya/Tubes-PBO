///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import view.TambahKomplain;
//
///**
// *
// * @author Asus
// */
//public class Driver {
//
//    /**
//     * @param args the command line arguments
//     */
//    static final String DB_URL = "jdbc:mysql://localhost/tiangbts";
//    static final String DB_USER = "root";
//    static final String DB_PASS = "";
//    static Connection conn;
//    static Statement stmt;
//    static ResultSet rs;
//    
//    public static void main(String[] args) {
//        new TambahKomplain().setVisible(true);
////        try{
////        conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASS);
////        stmt = conn.createStatement();
////        
////        String st = "select Laporan from Customer";
////        rs = stmt.executeQuery(st);
////        while (rs.next()) {
////            System.out.println(rs.getString("Laporan"));
////                    
////        }
////        }catch(Exception e){
////            e.printStackTrace();
////        }
//    }
//    
//}
