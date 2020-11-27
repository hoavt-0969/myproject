/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Model;

import java.io.Serializable;

/**
 *
 * @author Vu Tien Hoa
 */
public class NameRequest implements Serializable{
    private String name;
    Object data;

    public NameRequest(String name, Object data) {
        this.name = name;
        this.data = data;
    }
    public String getName() {
        return name;
    }

    public Object getData() {
        return data;
    }
}
