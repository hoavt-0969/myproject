/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Control;

import Client.View.SignupView;
import Server.Control.SignupControl;

/**
 *
 * @author Vu Tien Hoa
 */
public class ClientRun {
    public static void main(String[] args) {
        SignupView vew = new SignupView();
        vew.setVisible(true);
    }
}
