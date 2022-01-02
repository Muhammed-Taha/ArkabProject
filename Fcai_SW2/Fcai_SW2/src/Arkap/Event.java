/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

/**
 *
 * @author omer
 */
public class Event {
    AddDetails  details ;
    ShowDetailsOfEvent ShowDetails;

    public void setEventDetails(ShowDetailsOfEvent eventDetails) {
        this.ShowDetails = eventDetails;
    }

    public ShowDetailsOfEvent getEventDetails() {
        return ShowDetails;
    }

    public void setDetails(AddDetails details) {
        this.details = details;
    }
   

    public AddDetails getDetails() {
        return details;
    }
   

}
