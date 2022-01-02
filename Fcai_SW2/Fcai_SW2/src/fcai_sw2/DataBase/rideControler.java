/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Arkap.Ride;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class rideControler {
    static ArrayList<Ride>rideList=new ArrayList<Ride>();
    public static  void insert(String sourceArea,String destinationArea,String id,double price,int numberOfpassangers)
    {  
        try {
             Year y = Year.now();
            ResultSet r=dataBase.getInstance().connection("ride");
            r.moveToInsertRow();
            r.updateString("sourceArea",sourceArea);
            r.updateString("destinationArea",destinationArea);
            r.updateString("id",id);
            r.updateDouble("price",price);
            r.updateInt("numberOfpassangers", numberOfpassangers);
            r.updateBoolean("state", false);
            
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void update(String id)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("ride");
            while(r.next()){
               if(r.getString("id").equals(id)){
                 r.updateBoolean("state",true);
                 r.updateRow();
                 break;
               }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static void updatebyOffer(String id,String driverID,double price)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("ride");
            while(r.next()){
               if(r.getString("id").equals(id)){
                 r.updateDouble("price",price);
                 r.updateString("driverID", driverID);
                 r.updateRow();
                 break;
               }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static ArrayList All()
    {
        
        try {
            ArrayList<Ride> al=new ArrayList<Ride>();
            ResultSet r=dataBase.getInstance().connection("ride");
            while(r.next())
            { 
                if(r.getBoolean("state")==false){
                    System.out.println("Iam in Database of ride to All"+"\t "+r.getString("sourceArea"));
                    Ride ride=new Ride();
                    ride.setSourceArea(r.getString("sourceArea"));
                    ride.setDestinationArea(r.getString("destinationArea"));
                    ride.setPrice(r.getDouble("price"));
                    ride.setId(r.getString("id"));
                    ride.setNumberOfpassangers(r.getInt("numberOfpassangers"));
                    ride.setDriverID(r.getString("driverID"));
                    ride.setState(r.getBoolean("state"));
                    al.add(ride);
                }
            }
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
        

    }
    public static Ride Search(String i)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("ride");
            while(r.next()){
                if(r.getString("id").equals(i)){
                    Ride ride=new Ride();
                    ride.setSourceArea(r.getString("sourceArea"));
                    ride.setDestinationArea(r.getString("destinationArea"));
                    ride.setState(r.getBoolean("state"));
                    ride.setPrice(r.getDouble("price"));
                    ride.setNumberOfpassangers(r.getInt("numberOfpassangers"));
                    ride.setId(r.getString("id"));
                    return ride;
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
         return null;
    }

    public static ArrayList<Ride> getRideList() {
        return rideList;
    }

    public static void setRideList(ArrayList<Ride> rideList) {
          rideList = rideList;
    }
    
    
}
