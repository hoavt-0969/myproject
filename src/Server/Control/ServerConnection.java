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
import java.sql.DriverManager;

/**
 *
 * @author Vu Tien Hoa
 */
public class ServerConnection {
    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 8888;

    public ServerConnection() {
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
                NameRequest nrq = (NameRequest) o;
                if(nrq.name.equals("signup")){
//                    signup(nr);
                    User u = (User) nrq.getData();
                    System.out.println(u.getName());
                    oos.writeObject("ok");
                }
                else{
//                    signin();
                    oos.writeObject("false");
                }
            }
//            if (o instanceof User) {
//                User user = (User) o;
//                SignupControl s = new SignupControl();
//                if(s.AddUser(user)){
//                    oos.writeObject("ok");
//                }
//                else{
//                    oos.writeObject("false");
//                }  
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkUser(User user) {
        return false;
    }

    private boolean signup(User user) throws Exception {
        SignupControl s = new SignupControl();
        if (s.AddUser(user)) {
            return true;
        } else {
            return false;
        }
    }

    private void signin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
