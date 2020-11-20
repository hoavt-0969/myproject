/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vu Tien Hoa
 */
public class DBConnection {
    private String username = "testuser";
    private String password = "password";
//    private String dbname = "appgame";
    private String url = "jdbc:mysql://localhost:3306/appgame";
    private Connection con;
    public DBConnection() {
        
    }
    
    public Connection getDBConnection() {
//        String dbUrl = "jdbc:mysql://localhost:3306/" + dbname;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = (Connection) DriverManager.getConnection(url,username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
