/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.AddDetailsController;

/**
 *
 * @author omer
 */
public class AddDetails {
    private String Cphone ;
    private String Dphone ;
    private String Rid;
    String eventName;
    String eventTime;
   
    AddDetails(String client ,String driver,String ride,String eventName,String eventTime){
        this.Cphone=client;
        this.Dphone=driver;
        this.Rid=ride;
        AddDetailsController.insert(Cphone, Dphone, Rid,eventName,eventTime);
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
    
    public AddDetails() {
    }

    public String getCphone() {
        return Cphone;
    }

    public String getDphone() {
        return Dphone;
    }

    public String getRid() {
        return Rid;
    }

    public void setCphone(String Cphone) {
        this.Cphone = Cphone;
    }

    public void setDphone(String Dphone) {
        this.Dphone = Dphone;
    }

    public void setRid(String Rid) {
        this.Rid = Rid;
    }
    
}
