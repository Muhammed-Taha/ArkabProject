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
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class Driver extends Registertion_users {
    ArrayList<Driver>Driver_list=new ArrayList<Driver>(); 
    ArrayList<String> rateing=new ArrayList<String>();
    String driving_license ;
    String national_id;
    String rates;    
    ArrayList<String> favoriteAreas=new ArrayList<String>(); 
    ArrayList<Ride> notification = new ArrayList<Ride>();
    ArrayList<Ride> rideList = new ArrayList<Ride>();

    public Driver() {
        
    }
    public Driver(String username,String mobile_number,String email,String password,String driving_license, String national_id) {
        super(username, mobile_number, email, password,false);       
        this.driving_license = driving_license;
        this.national_id = national_id;
        this.insert(username, mobile_number, email, password, driving_license, national_id);
    }
    public void insert(String username,String mobile_number,String email,String password,String driving_license,String national_id)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver` ");
            r.moveToInsertRow();
            r.updateString("username",username);
            r.updateString("mobile_number",mobile_number);
            r.updateString("email", email);
            r.updateString("password", password);
            r.updateString("driving_license",driving_license);
            r.updateString("national_id",national_id);
            r.updateString("favoriteAreas",null);
            r.updateBoolean("state", false);
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    static public ArrayList All()
    {
        try {
            ArrayList<Driver> al=new ArrayList<Driver>();
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver`");
            while(r.next()&&r.getBoolean("state")==true)
            {
                Driver driver=new Driver();
                driver.username=r.getString("username");
                driver.mobile_number=r.getString("mobile_number");
                driver.email=r.getString("email");
                driver.password=r.getString("password");
                driver.driving_license=r.getString("driving_license");
                driver.state=r.getBoolean("state");
                driver.national_id=r.getString("national_id");
                String f =new String();
                f=r.getString("favoriteAreas");
                if(f!=null){
                String [] arr;
                arr=f.split("/");
                for(int i=0;i<arr.length;i++){
                   driver.favoriteAreas.add(arr[i]);
                }
                }
                else{
                    driver.favoriteAreas=null;
                }
                if(r.getString("rates")!=null){
                    driver.rates=r.getString("rates");
                }
                else{
                     driver.rates=null;
                }
                al.add(driver);
            }
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList allFavorite(String mobile_number)
    {
        try {
            ArrayList<String> al=new ArrayList<String>();
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver`");
            String[] arr ;
            while(r.next()&&r.getString("mobile_number").equals(mobile_number))
            {
                String f =new String();
                f=r.getString("favoriteAreas");
                arr=f.split("/");
                for(int i=0;i<arr.length;i++){
                   al.add(arr[i]);
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
    public void update(String pass)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver` ");
            r.next();
            if(r.getString("mobile_number").equals(pass)){
            Boolean b=r.getBoolean("state");
            r.updateBoolean("state",!b);
            r.updateRow();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public void addFavoritetoDataBase(String mobile_number,String area)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver` WHERE mobile_number = '"+mobile_number+"'");
            r.next();
            String cur=r.getString("favoriteAreas")+area;
            r.updateString("favoriteAreas",(cur+"/"));
            r.updateRow();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public String getUsername() {
        return username;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public String getNational_id() {
        return national_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public void printDetails(){
        System.out.print("Name of driver : "+this.username+"   ");
        System.out.print("Number : "+this.mobile_number+"  ");
        System.out.print("Email : "+this.email+"  ");
        System.out.print("National Id : "+this.national_id+"  ");
        System.out.println("Rate : "+this.getAvgRate()+"  ");
    }
    
    public void  addFavoriteAreas(String favoriteArea){
        this.favoriteAreas.add(favoriteArea);
        this.addFavoritetoDataBase(this.mobile_number,favoriteArea);
    } 
    @Override
    public void printNotification(){
        ArrayList<Ride> cur = new ArrayList<Ride>();
        if(this.favoriteAreas.size()==0){
            for(int i=0;i<this.rideList.size();i++){
                    this.rideList.get(i).printDetails();
            }
        }
        else{
            for(int i=0;i<this.favoriteAreas.size();i++){
                for(int j=0;j<this.rideList.size();j++){
                   if(this.rideList.get(i).sourceArea.equals(this.favoriteAreas.get(i))){
                       cur.add(this.rideList.get(i));
                   } 
                }
            }
        }
        for(int i=0;i<cur.size();i++){
                    cur.get(i).printDetails();
        }
        
    }
    public static void rate(String i,double rate)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver` WHERE mobile_number = '"+i+"'");
            r.next();
            String cur = null;
            if(r.getString("rates")!=null){
            cur=r.getString("rates");
            cur+=Double.toString(rate);
            cur+="/";
            }
            else{
            cur=Double.toString(rate);
            cur+="/";
            }
            r.updateString("rates",cur);
            r.updateRow();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public double getAvgRate()
    {
       double avgRate=0;
       if(this.rates!=null){
        String [] arr;
        arr=this.rates.split("/");
        for(int i=0;i<arr.length;i++){
            avgRate+=Double.parseDouble(arr[i]);
        }
       }
       return avgRate;
    }
    public void getRates()
    { 
       double avgRate=0;
       String [] arr;
       arr=this.rates.split("/");
       for(int i=0;i<arr.length;i++){  
          this.rateing.add(arr[i]);
          System.out.println(arr[i]);
       }    
    }
    public void suggestPrice(String id,double price){
       String cur="Hello i give you offer with ";
       cur+=Double.toString(price);
       cur+=" bounds";
       User.updateNotification(id, cur);     
    }
    public Driver login(String user_name, String password) 
     {
        Driver_list=All();
        for (int i=0;i<Driver_list.size();i++){
            if((Driver_list.get(i).getUsername().equals(user_name))&&(Driver_list.get(i).getPassword().equals(password))&&(Driver_list.get(i).state==true)){
                Driver_list.get(i).rideList=Ride.All();
                Driver_list.get(i).favoriteAreas=Driver_list.get(i).allFavorite(Driver_list.get(i).mobile_number);
                return Driver_list.get(i);
            }
        }
        return null;
    }
}
