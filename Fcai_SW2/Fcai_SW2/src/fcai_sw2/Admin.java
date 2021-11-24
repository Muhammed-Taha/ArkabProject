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
public class Admin extends General_user {
   static ArrayList<Driver> Pending_list = new ArrayList<Driver>();
   static ArrayList<Driver> driverList = new ArrayList<Driver>();
   static ArrayList<User> U_list = new ArrayList<User>();
   public Admin(){
   }
   
   static public ArrayList All()
  {
        try {
            ArrayList<Driver> al=new ArrayList<Driver>();
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `driver`");
            while(r.next()&&r.getBoolean("state")==false)
            {
                Driver driver=new Driver();
                driver.username=r.getString("username");
                driver.mobile_number=r.getString("mobile_number");
                driver.email=r.getString("email");
                driver.password=r.getString("password");
                driver.driving_license=r.getString("driving_license");
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
   public  void driverVerfiy(){
      Pending_list=this.All();
       for(int i=0;i<Pending_list.size();i++){
           if((Pending_list.get(i).getNational_id()!=null)&&(Pending_list.get(i).getDriving_license()!=null)){
              Pending_list.get(i).update(Pending_list.get(i).getMobile_number());
           }
       }
   }
   public void  Suspend(Registertion_users reg){
      reg.update(reg.mobile_number);
   }
   
}

