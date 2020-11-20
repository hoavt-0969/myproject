/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.User;

/**
 *
 * @author Vu Tien Hoa
 */
public class SignupControl {
    private ClientConnection conn;
    private Socket mySocket;
    public SignupControl() {
        Socket mySocket = conn.openConnection();
    }
    public boolean sendData(User user) {
        
        try {
            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public String receiveData() {
        String result = null;
        try {
            ObjectInputStream ois
                    = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            if (o instanceof String) {
                result = (String) o;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }
    
    public boolean closeConnection() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            mySocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
