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
     ArrayList<String>Noti=new ArrayList<String>();
   
      public void setNoti(ArrayList<String> Noti) {
        this.Noti = Noti;
    }

     public ArrayList<String> getNoti() {
        return Noti;
    }
    
}
