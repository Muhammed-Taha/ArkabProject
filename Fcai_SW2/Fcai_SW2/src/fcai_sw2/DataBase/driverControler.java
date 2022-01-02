/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Arkap.Driver;
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
public class driverControler {
     ArrayList<Driver>Driver_list=new ArrayList<Driver>(); 
     static public void insert(String username,String mobile_number,String email,String password,String driving_license,String national_id,double balance)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("driver");
            r.moveToInsertRow();
            r.updateString("username",username);
            r.updateString("mobile_number",mobile_number);
            r.updateString("email", email);
            r.updateString("password", password);
            r.updateString("driving_license",driving_license);
            r.updateString("national_id",national_id);
            r.updateString("favoriteAreas",null);
            r.updateBoolean("state", false);
            r.updateDouble("balance", balance);
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    static public ArrayList All(boolean SS)
    {
        try {
            ArrayList<Driver> al=new ArrayList<Driver>();
            ResultSet r=dataBase.getInstance().connection("driver");
            while(r.next()&&r.getBoolean("state")==SS)
            {
                Driver driver=new Driver();
                driver.setUserName(r.getString("username"));
                driver.setMobileNum(r.getString("mobile_number"));
                driver.setEmail(r.getString("email"));
                driver.setPassWord(r.getString("password"));
                driver.setDriving_license(r.getString("driving_license"));
                driver.setBalance(r.getDouble("balance"));
                driver.setState(r.getBoolean("state"));
                driver.setNational_id(r.getString("national_id"));
                String f =new String();
                f=r.getString("favoriteAreas");
                if(f!=null){
                String [] arr;
                arr=f.split("/");
                for(int i=0;i<arr.length;i++){
                   driver.getFA().getFavoriteAreas().add(arr[i]);
                }
                }
                else{
                    driver.getFA().setFavoriteAreas(null);
                }
                if(r.getString("rates")!=null){
                    driver.setRates(r.getString("rates"));
                }
                else{
                     driver.setRates(null);
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

    static public Driver search(String  phone)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("driver");
            while(r.next())
            {
                Driver driver=new Driver();
                if(r.getString("mobile_number")==phone){
                    driver.setUserName(r.getString("username"));
                    driver.setMobileNum(r.getString("mobile_number"));
                    driver.setEmail(r.getString("email"));
                    driver.setPassWord(r.getString("password"));
                    driver.setDriving_license(r.getString("driving_license"));
                    driver.setState(r.getBoolean("state"));
                    driver.setBalance(r.getDouble("balance"));
                    driver.setNational_id(r.getString("national_id"));
                    String f =new String();
                    f=r.getString("favoriteAreas");
                    if(f!=null){
                    String [] arr;
                    arr=f.split("/");
                    for(int i=0;i<arr.length;i++){
                       driver.getFA().getFavoriteAreas().add(arr[i]);
                    }
                    }
                    else{
                        driver.getFA().setFavoriteAreas(null);
                    }
                    if(r.getString("rates")!=null){
                        driver.setRates(r.getString("rates"));
                    }
                    else{
                         driver.setRates(null);
                    }
                    return driver;
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    static public ArrayList allFavorite(String mobile_number)
    {
        try {
            ArrayList<String> al=new ArrayList<String>();
           ResultSet r=dataBase.getInstance().connection("driver");
            String[] arr ;
            while(r.next()&&r.getString("mobile_number").equals(mobile_number))
            {
                String f =new String();
                //System.out.println(r.getString("favoriteAreas"));
                if(r.getString("favoriteAreas")!=null){
                    f=r.getString("favoriteAreas");
                    arr=f.split("/");
                    for(int i=0;i<arr.length;i++){
                       al.add(arr[i]);
                    }
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
    static public void update(String pass)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("driver");
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
     static public void updateBalance(String pass,double price)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("driver");
            r.next();
            if(r.getString("mobile_number").equals(pass)){
            double b=r.getDouble("palance")+price;
            r.updateDouble("palance",b);
            r.updateRow();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    static public void addFavoritetoDataBase(String mobile_number,String area)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("driver");
            while(r.next()){
            if(r.getString("mobile_number").equals(mobile_number)){
                String cur=r.getString("favoriteAreas")+area;
                r.updateString("favoriteAreas",(cur+"/"));
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
    public static void rate(String i,double rate)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("driver");
            while(r.next()){
                if(r.getString("mobile_number").equals(i))
                {
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
                    break;
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Driver> getDriver_list() {
        return Driver_list;
    }

    public void setDriver_list(ArrayList<Driver> Driver_list) {
        this.Driver_list = Driver_list;
    }
    
}
