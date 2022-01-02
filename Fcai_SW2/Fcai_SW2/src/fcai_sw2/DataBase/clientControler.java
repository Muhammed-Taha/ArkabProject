/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Arkap.Driver;
import Arkap.Client;
import Arkap.User;
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
public class clientControler {
     ArrayList<Client>User_list=new ArrayList<Client>(); 
     ArrayList<Driver>driverList=new ArrayList<Driver>();
      static public  void insert(String username,String mobile_number,String email,String password,int counter,String birthDay)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("user");
            r.moveToInsertRow();
            r.updateString("username",username);
            r.updateString("mobile_number",mobile_number);
            r.updateString("email", email);
            r.updateString("password", password);
            r.updateInt("counter", counter);
            r.updateString("birthDay","birthDay");
            r.updateBoolean("state", true);
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    } 
    static  public void update(String pass)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("user");
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
    static  public void updateCounter (String pass)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("user");
            r.next();
            if(r.getString("mobile_number").equals(pass)){
            r.updateInt("counter",200);
            r.updateRow();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
     static public ArrayList All()
    {
        try {
            ArrayList<User> al=new ArrayList<User>();
            ResultSet r=dataBase.getInstance().connection("user");
            while(r.next()&&r.getBoolean("state")==true)
            {
                Client client=new Client();
                client.setUserName(r.getString("username"));
                client.setMobileNum(r.getString("mobile_number"));
                client.setEmail(r.getString("email"));
                client.setPassWord(r.getString("password"));
                client.setState(r.getBoolean("state"));
                client.setCounter(r.getInt("counter"));
                client.setBirthDay(r.getString("birthDay"));
                ArrayList<String>all=new ArrayList<String>(); 
                String arr[];
                if(r.getString("notification")!=null){
                    String str = r.getString("notification");
                    arr=str.split("#");
                    for(int i=0;i<arr.length;i++){
                        all.add(arr[i]);
                    }
                     client.getCN().setNoti(all);
                }
                else{
                   client.getCN().setNoti(null);
                }
                al.add(client);
            }
             
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
        

    }
    static public Client Search(String id)
    {
        try {
                ArrayList<User> al=new ArrayList<User>();
                ResultSet r=dataBase.getInstance().connection("user");
                Client client=new Client();
                while(r.next())
                {  
                    if(r.getString("mobile_number").equals(id)){
                    client.setUserName(r.getString("username"));
                    client.setMobileNum(r.getString("mobile_number"));
                    client.setEmail(r.getString("email"));
                    client.setPassWord(r.getString("password"));
                    client.setState(r.getBoolean("state"));
                    client.setBirthDay(r.getString("birthDay"));
                    client.setCounter(r.getInt("counter"));
                     ArrayList<String>all=new ArrayList<String>(); 
                     String arr[];
                   if(r.getString("notification")!=null){
                        String str = r.getString("notification");
                        arr=str.split("#");
                    for(int i=0;i<arr.length;i++){
                            all.add(arr[i]);
                    } 
                     client.getCN().setNoti(all);
                }
                else{
                   client.getCN().setNoti(null);
                }
                    return client;
                } 
                }
            }
            catch(SQLException e)
            {
              e.printStackTrace();
            }
         return null;          
        }
     public  ArrayList<Client> getUser_list() {
        return User_list;
    }

     public   ArrayList<Driver> getDriverList() {
        return driverList;
    }

     public void setUser_list(ArrayList<Client> User_list) {
        this.User_list = User_list;
    }

     public void setDriverList(ArrayList<Driver> driverList) {
        this.driverList = driverList;
    }
    
     static public void addNewNoyification(String ard,String pass){
          try {
            ResultSet r=dataBase.getInstance().connection("user");
            r.next();
            if(r.getString("mobile_number").equals(pass)){
               r.updateString("notification",ard);
               r.updateRow();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
     }
     static  public void clearAllNotification (String pass)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("user");
            r.next();
            if(r.getString("mobile_number").equals(pass)){
            r.updateString("notification",null);
            r.updateRow();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
     
}
