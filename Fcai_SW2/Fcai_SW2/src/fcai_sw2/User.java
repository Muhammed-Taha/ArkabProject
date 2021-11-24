/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcai_sw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class User  extends Registertion_users   {
    ArrayList<User>User_list=new ArrayList<User>(); 
    ArrayList<Driver>driverList=new ArrayList<Driver>();
    String notification=null; 
    public User(String username,String mobile_number,String email,String password){
       super(username, mobile_number, email, password,true);
       this.insert(username, mobile_number, email, password);
    }
    public void  requestRide (String sourceArea , String  destinationArea){
        Ride r1=new Ride(sourceArea,destinationArea,false,this.mobile_number);
    }
    public User(){}
    
    public void insert(String username,String mobile_number,String email,String password)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `user` ");
            r.moveToInsertRow();
            r.updateString("username",username);
            r.updateString("mobile_number",mobile_number);
            r.updateString("email", email);
            r.updateString("password", password);
            r.updateBoolean("state", true);
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    } 
     public static void  updateNotification (String i,String noti)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `user`");
                 if(r.next()&&r.getString("mobile_number").equals(i)){
                 r.updateString("notification",noti);
                 r.updateRow();
                 }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
     public void makeRate(String id,double rate){
         Driver.rate(id, rate);
     }
     @Override
    public void update(String pass)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `user` WHERE mobile_number = '"+pass+"'");
            r.next();
            if(r.getString("mobile_number").equals(pass)){
            r.updateBoolean("state",false);
            r.updateRow();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
     @Override
    public void printNotification(){
        System.out.println(this.notification);
    }   
    @Override
    public void printDetails(){
        System.out.println(this.username);
        System.out.println(this.mobile_number);
        System.out.println(this.email);
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    static public ArrayList All()
    {
        try {
            ArrayList<User> al=new ArrayList<User>();
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `user` ");
            while(r.next()&&r.getBoolean("state")==true)
            {
                User user=new User();
                user.username=r.getString("username");
                user.mobile_number=r.getString("mobile_number");
                user.email=r.getString("email");
                user.password=r.getString("password");
                user.state=r.getBoolean("state");
                if(r.getString("notification")!=null){
                user.notification=r.getString("notification");
                }
                else{
                 user.notification=null;   
                }
                al.add(user);
            }
             
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
        

    }
    public User login(String user_name, String password) {
        User_list=All();
        for (int i=0;i<User_list.size();i++){
            if((User_list.get(i).getUsername().equals(user_name))&&User_list.get(i).getPassword().equals(password)&&User_list.get(i).state==true){
                return User_list.get(i);
            }
        }
        return null;
       
    }
}
