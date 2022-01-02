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
/**
 *
 * @author omer
 */
public class Admin extends User {
   static ArrayList<Driver> Pending_list = new ArrayList<Driver>();
   static ArrayList<Driver> driverList = new ArrayList<Driver>();
   static ArrayList<User> U_list = new ArrayList<User>();
   
   static DiscountArea discount =new DiscountArea();
   public Admin(){
     discount.setDiscountAreas(discountControler.All());
   }
   public  void driverVerfiy(){
      Pending_list=driverControler.All(false);
       for(int i=0;i<Pending_list.size();i++){
           if((Pending_list.get(i).getNational_id()!=null)&&(Pending_list.get(i).getDriving_license()!=null)){
              driverControler.update(Pending_list.get(i).getMobileNum());
           }
       }
   }
   public void Suspend_Client(Client reg){
       clientControler.update(reg.getMobileNum());
   }
   public void  Suspend_driver(Driver reg){
      driverControler.update(reg.getMobileNum());
   }
   public void getEventDetails(){
   
   }
    public static DiscountArea getDiscount() {
        return discount;
    }
    public static void setDiscount(DiscountArea discount) {
        Admin.discount = discount;
    }
}

