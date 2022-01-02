/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DataBase.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author omer
 */
public class Driver  extends User implements Notification,LogIn {
    driverControler DC=new driverControler();
    static FavoriteArea FA=new FavoriteArea();
    static rateDriver RD=new rateDriver();
    double balance;
    String driving_license ;
    String busy;
    String national_id ; 
    String ard;
    String crrentArea; 
    ArrayList<Ride> notification = new ArrayList<Ride>();
    ArrayList<Ride> rideList = new ArrayList<Ride>();
    ArrayList<Observer> observerList =new  ArrayList<Observer>();
    public Driver() {
        
    }

    public String getCrrentArea() {
        return crrentArea;
    }

    public void setCrrentArea(String crrentArea) {
        this.crrentArea = crrentArea;
    }
    
    public Driver(String username,String mobile_number,String email,String password,String driving_license, String national_id,double balance) {
        super(username, mobile_number, email, password,false);       
        this.driving_license = driving_license;
        this.balance=balance;
        this.national_id = national_id;
        driverControler.insert(username, mobile_number, email, password, driving_license, national_id,balance);
    }   

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }
    
    static public rateDriver getRD() {
        return RD;
    }
    static public FavoriteArea getFA() {
        return FA;
    }
 
    public ArrayList<Ride> getRideList() {
        return rideList;
    }
    @Override
    public Driver login(String user_name, String password) 
     {
        DC.setDriver_list(driverControler.All(true));
        for (int i=0;i<DC.getDriver_list().size();i++){
            if((DC.getDriver_list().get(i).getUserName().equals(user_name))&&(DC.getDriver_list().get(i).getPassWord().equals(password))&&(DC.getDriver_list().get(i).getState()==true)){
                DC.getDriver_list().get(i).rideList=rideControler.All();
                DC.getDriver_list().get(i).FA.favoriteAreas=driverControler.allFavorite(DC.getDriver_list().get(i).getMobileNum());
                return DC.getDriver_list().get(i);
            }
        }
        return null;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public String getNational_id() {
        return national_id;
    }

    public ArrayList<String> getRateing() {
        return this.RD.rateing;
    }

    public void setRates(String rates) {
        this.RD.rates = rates;
    }
    
    public void suggestPrice(String id,double price){          
        int dis=0;
         Discount discount= new DiscountinAreaDecorator(new TwoPassangerDecorator(new firstRideDecorator(new happyBirthdayDecorator(new publicHolidayDecorator(new NoDiscount()),id),id),id),id);
         price=discount.cost(price);
         dis=discount.calcolateDiscount(0);
         String cur="";
         cur+=Double.toString(price-(price*(dis/100)));   
         ard=this.getMobileNum()+"/"+cur+"/"+dis+"#";
         add(clientControler.Search(id));
         SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
         LocalDateTime now = LocalDateTime.now();    
         String time=formatter.format(now);  
         AddDetailsController.insert(id,this.getMobileNum(), id,"price Event",time);
    }
    @Override
    public void add(Observer observer) {
          try{  
           observerList.add(observer);
          }
          catch(NullPointerException e){
              System.out.println("Null");
          }
          notifyforlast();
    } 
    @Override
    public void notifyforlast() {
            observerList.get(observerList.size() - 1).update(ard);
    }
}
