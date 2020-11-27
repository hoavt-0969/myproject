/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import Server.Model.NameRequest;
import Server.Model.User;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vu Tien Hoa
 */
public class ServerHandle {
    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 8888;
    
    public ServerHandle() {
//        getDBConnection("appgame", "testuser", "password");
        openServer(serverPort);
        while (true) {
            listenning();
        }
    }
    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listenning() {
        try {
            Socket clientSocket = myServer.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            
            if(o instanceof NameRequest){
                NameRequest req = (NameRequest) o;
                System.out.println(req.getName());
//                if(req.name.equals("signup")){
//                    User signup = (User) req.getData();
//                        if(signup(signup)){
//                            oos.writeObject("ok");
//                        }else{
//                            oos.writeObject("failed");
//                        }
//                }
//                else if(req.name.equals("signin")){
//                    User signin = (User) req.getData();
//                        if(signin(signin)){
//                            oos.writeObject("ok");
//                        }else{
//                            oos.writeObject("failed");
//                        }
//                }
                
                switch(req.getName()){
                    case "signup":
                        User signup = (User) req.getData();
                        if(signup(signup)){
                            oos.writeObject("ok");
                        }else{
                            oos.writeObject("failed");
                        }
                        break;
                    case "signin":
                        User signin = (User) req.getData();
                        if(signin(signin)){
                            oos.writeObject("ok");
                        }else{
                            oos.writeObject("failed");
                        }
                        break;
                    case "search":
                        String value = (String) req.getData();
                        oos.writeObject(search(value));
                        break;
                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkUser(User user) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean signup(User user) throws Exception {
        Connection con = new DBConnection().getDBConnection();
        String query = "INSERT INTO users(name,username,password) VALUES('"+user.getName()+"','"+user.getUsername()+"','"+user.getPassword()+ "')";
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

    private boolean signin(User user) throws Exception {
        Connection con = new DBConnection().getDBConnection();
//        String query = "INSERT INTO users(name,username,password) VALUES('"+user.getName()+"','"+user.getUsername()+"','"+user.getPassword()+ "')";
        String query = "SELECT * FROM users WHERE username ='"+ user.getUsername()+ "' AND password ='" + user.getPassword() + "'";
        System.out.println(query);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private ArrayList<User> search(String value) throws Exception{
        ArrayList<User> res = new ArrayList<>();
        Connection con = new DBConnection().getDBConnection();
        String query = "SELECT * FROM users WHERE name LIKE '%"+ value + "%' OR username LIKE '%" + value + "%'";
        System.out.println(query);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                res.add(user);
            }
        } catch (Exception e) {
//            throw e;
            e.printStackTrace();
            return null;
        }
        return res;
    }
    
//    private 
}
