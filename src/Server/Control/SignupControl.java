/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import Server.Model.User;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Vu Tien Hoa
 */
public class SignupControl {
    
        
//    ServerConnection con = new ServerConnection();
    public SignupControl() {
    }
    public boolean AddUser(User user) throws Exception{
        Connection con = new DBConnection().getDBConnection();
        String query = "INSET INTO users(name,username,password) VALUES('"+user.getName()+"','"+user.getUsername()+"','"+user.getPassword()+ "')";
        System.out.println(query);
        try {
            Statement stmt = con.createStatement();
            int rowCount = stmt.executeUpdate(query);
            if(rowCount > 0){
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }
}
