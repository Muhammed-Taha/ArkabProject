
package Arkap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;
import DataBase.*;
/**
 *
 * @author omer
 */
public class Ride {
    String sourceArea ;
    String  destinationArea;
    String driverID;
    private int  numberOfpassangers;
    double price;
    boolean state =false;
    String id;
    Ride(String sourceArea,String destinationArea,boolean s,String i,double price,int numberOfpassangers){
      this.sourceArea=sourceArea ;
      this.destinationArea=destinationArea;  
      this.id=i;
      this.state=s;
      this.price=price;
      rideControler.insert(sourceArea,destinationArea,i,price,numberOfpassangers);
    }

    public int getNumberOfpassangers() {
        return numberOfpassangers;
    }

    public void setNumberOfpassangers(int numberOfpassangers) {
        this.numberOfpassangers = numberOfpassangers;
    }

    public  Ride() {
        
    }
    public String getSourceArea() {
        return sourceArea;
    }

    public String getDestinationArea() {
        return destinationArea;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverID() {
        return driverID;
    }

    public boolean isState() {
        return state;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setSourceArea(String sourceArea) {
        this.sourceArea = sourceArea;
    }

    public void setDestinationArea(String destinationArea) {
        this.destinationArea = destinationArea;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    public void setId(String id) {
        this.id = id;
    }
    
    
}
