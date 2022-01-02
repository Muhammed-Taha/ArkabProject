/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class clientNotification {
    static ArrayList<String>Noti=new ArrayList<String>();
   
    static  public void setNoti(ArrayList<String> Noti) {
        clientNotification.Noti = Noti;
    }

    static public ArrayList<String> getNoti() {
        return Noti;
    }
    
}
