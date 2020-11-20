/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

/**
 *
 * @author Vu Tien Hoa
 */
public class ServerRun {
    public static void main(String[] args) {
        System.out.println("Server is running...");
        ServerConnection connect = new ServerConnection();
    }
}
