/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Control;

import java.net.Socket;

/**
 *
 * @author Vu Tien Hoa
 */
public class ClientConnection {
    private Socket mySocket;
    private String serverHost = "localhost";
    private int serverPort = 8888;
//    private Socket mySocket;
//    private String serverHost;
//    private int serverPort;
    
    public ClientConnection() {
        
    }

//    public ClientConnection(Socket mySocket, String serverHost, int serverPort) {
//        this.mySocket = mySocket;
//        this.serverHost = serverHost;
//        this.serverPort = serverPort;
//    }
//    
    public Socket openConnection() {
        try {
            mySocket = new Socket(serverHost, serverPort);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return mySocket;
    }
}
