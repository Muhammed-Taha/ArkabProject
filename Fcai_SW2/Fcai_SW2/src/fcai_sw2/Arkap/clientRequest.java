/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.driverControler;

/**
 *
 * @author omer
 */
public class clientRequest {
    public void  requestRide (Client c,String sourceArea , String  destinationArea,int numberOfpassangers){
        Ride r1=new Ride(sourceArea,destinationArea,false,c.getMobileNum(),0,numberOfpassangers);
    }
     public void makeRate(String id,double rate){
         driverControler.rate(id, rate);
     }
}
