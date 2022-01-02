/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.clientControler;
import DataBase.driverControler;

/**
 *
 * @author omer
 */
public class locationEventDetails implements ShowDetailsOfEvent{

    @Override
    public void showEvent(Event e) {
       System.out.println("Event Name = "+e.getDetails().getEventName());
        System.out.println("Event Time = "+e.getDetails().getEventTime());
        System.out.println("Captin name = "+clientControler.Search(e.getDetails().getCphone()).getUserName()); 
        System.out.println("Captin name = "+driverControler.search(e.getDetails().getDphone()).getUserName());
       
    }
    
}
