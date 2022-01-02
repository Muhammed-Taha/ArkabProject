/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.clientControler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import DataBase.*;
/**
 *
 * @author omer
 */
public class Client extends User implements Observer,LogIn {
    clientControler CC=new clientControler(); 
    static clientNotification CN=new clientNotification();
    static clientRequest CR=new clientRequest();
    private int counter;
    private String birthDay;
    public Client(){}
    public Client(String username,String mobile_number,String email,String password,int counter,String birthDay){
       super(username, mobile_number, email, password,true);
        this.counter=counter;
        this.birthDay=birthDay;
       clientControler.insert(username, mobile_number, email, password,counter,birthDay);
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
    public void setCounter(int counter) {
        this.counter = counter;
    }


    public int getCounter() {
        return counter;
    }
    public static clientNotification getCN() {
        return CN;
    }
     public static clientRequest getCR() {
        return CR;
    }
    @Override
    public User login(String user_name, String password) {
         CC.setUser_list(clientControler.All());
        for (int i=0;i<CC.getUser_list().size();i++){
            if((CC.getUser_list().get(i).getUserName().equals(user_name))&&CC.getUser_list().get(i).getPassWord().equals(password)&&CC.getUser_list().get(i).getState()==true){
                return CC.getUser_list().get(i);
            }
        }
        return null;  
    }
    
    @Override
    public void update(String ard) {
        clientControler.addNewNoyification(ard,this.getMobileNum());
    }
}
