/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servideLayer;

import DataBase.clientControler;
import DataBase.driverControler;
import Arkap.Admin;
import Arkap.Client;
import Arkap.DiscountArea;
import Arkap.Driver;
import Arkap.Ride;
import Arkap.User;
import DataBase.discountControler;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omer
 */
public class adminService {
    public static void show(){
           System.out.println("Enter 1 to use progeam as Client");
           System.out.println("Enter 2 to use progeam as driver");
           System.out.println("Enter 3 to use progeam as Admin");
           System.out.println("Enter 0 to exit app");

    }
    public static void Enter(Scanner input,Admin a){
        System.out.println("Enter your userName : ");
                   String user_name=input.next();
                   System.out.println("Enter your password : ");
                   String password=input.next();
                   if((user_name.toLowerCase().equals("admin"))&&(password.toLowerCase().equals("admin"))){
                       System.out.println("Enter 1 to verify ");
                       System.out.println("Enter 2 to Suspend Driver");
                       System.out.println("Enter 3 to Suspend User");
                       System.out.println("Enter 4 to  add Discount area");
                       System.out.println("Enter 5 to  remove Discount area");
                       int r=input.nextInt();
                       if(r==1){
                           a.driverVerfiy();
                       }
                       else if(r==2){
                           //ArrayList<Ride>rides=new ArrayList<Ride>();
                           ArrayList<Driver> Drivers=new ArrayList <Driver>(); 
                           Drivers=driverControler.All(true);
                           for(int i=0;i<Drivers.size();i++){
                              System.out.print((i+1)+"- ");
                              System.out.print("Name of driver : "+Drivers.get(i).getUserName()+"   ");
                              System.out.print("Number : "+Drivers.get(i).getMobileNum()+"  ");
                              System.out.print("Email : "+Drivers.get(i).getEmail()+"  ");
                              System.out.print("National Id : "+Drivers.get(i).getNational_id()+"  ");
                              System.out.println("Rate : "+Drivers.get(i).getRD().getAvgRate()+"  ");
                           }
                           System.out.println("Enter number of driver : ");
                           int cc=input.nextInt();
                           a.Suspend_driver(Drivers.get(cc-1));
                      }
                       else if(r==3){
                           ArrayList<Client> Clients=new ArrayList <Client>(); 
                            Clients=clientControler.All();
                            for(int i=0;i<Clients.size();i++){
                              System.out.print((i+1)+"- ");
                                System.out.println(Clients.get(i).getUserName());
                                System.out.println(Clients.get(i).getMobileNum());
                                System.out.println(Clients.get(i).getEmail());
                           }
                           System.out.println("Enter number of User : ");
                           int cc=input.nextInt();
                           a.Suspend_Client(Clients.get(cc-1));
                       }
                       else if(r==4){
                           System.out.println("Enter name of area to perform discount ");
                           String ch=input.nextLine();
                           String Areaname=input.nextLine();
                           a.getDiscount().addDiscounttoarea(Areaname);
                       }
                       else if(r==5){
                           System.out.println("Enter name of area to remove discount ");
                           String ch=input.nextLine();
                           String Areaname=input.nextLine();
                           a.getDiscount().removeDiscounttoarea(Areaname);
                       }             
                   }
                   
    } 
}
