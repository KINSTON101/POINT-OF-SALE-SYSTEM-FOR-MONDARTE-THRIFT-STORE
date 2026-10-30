/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thriftstore_pointofsale_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection2 {
       
    
    public static Connection connect() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            String url = "jdbc:mysql://localhost:3306/pointofsale_thriftstore";
            String user = "root";
            String pass = "";
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    } 
}
