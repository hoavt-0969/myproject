/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;

/**
 *
 * @author Vu Tien Hoa
 */
public class ServerControl {
    private ServerSocket myServer;
    private int serverPort = 8888;

    public ServerControl() {
    }
    
    private void openServer(){
        try{
            myServer = new ServerSocket(serverPort);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
