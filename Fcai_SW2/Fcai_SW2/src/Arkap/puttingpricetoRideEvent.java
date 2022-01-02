/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.driverControler;
import DataBase.rideControler;

/**
 *
 * @author omer
 */
public class puttingpricetoRideEvent  implements ShowDetailsOfEvent{
    String price;

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
    
    @Override
    public void showEvent(Event e) {
        System.out.println("Event Name = "+e.getDetails().getEventName());
        System.out.println("Event Time = "+e.getDetails().getEventTime());
        System.out.println("Captin name = "+driverControler.search(e.getDetails().getDphone()).getUserName());
        System.out.println("price = "+price);
    }
    
}
