/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servideLayer;

import Arkap.AddDetails;
import DataBase.clientControler;
import DataBase.driverControler;
import Arkap.Admin;
import Arkap.Client;
import Arkap.DiscountArea;
import Arkap.Driver;
import Arkap.Event;
import Arkap.Ride;
import Arkap.User;
import DataBase.AddDetailsController;
import DataBase.discountControler;
import DataBase.rideControler;
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
                       System.out.println("Enter 6 to  if you want show events about Ride");
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
                       else if(r==6){
                           ArrayList<Ride>arr=new ArrayList<Ride>();
                           arr=rideControler.AllRideinDataBase();
                           for(int i=0;i<arr.size();i++){
                               System.out.println(i+1+" -from "+arr.get(i).getSourceArea()+" to "+arr.get(i).getDestinationArea());
                           }
                           System.out.println("Enter number of this ride");
                           int ent=input.nextInt();
                           Event e=new Event();
                           System.out.println("Enter 1 to show put a price Event");
                           System.out.println("Enter 2 to show put a accepts the price");
                           System.out.println("Enter 3 to show put a Captain arrived to user location");
                           System.out.println("Enter 4 to show put a Captain arrived to user Destnation");
                           int inter= input.nextInt();
                           if(inter == 1){
                               AddDetails AD=new AddDetails();
                               AD=AddDetailsController.Search(arr.get(ent-1).getId(),"price Event", rideControler.Search(arr.get(ent-1).getId()).getDriverID());
                               if(AD!=null){
                                e.getEventDetails().showEvent(e);
                                e.setDetails(AD);
                               }
                               else{
                                   System.out.println("This Event not avaliabal for this Ride");
                               }
                           }
                           else if(inter == 2){
                               AddDetails AD=new AddDetails();
                               AD=AddDetailsController.Search(arr.get(ent-1).getId(),"accepts the price", rideControler.Search(arr.get(ent-1).getId()).getDriverID());
                               if(AD!=null){
                                e.getEventDetails().showEvent(e);
                                e.setDetails(AD);
                               }
                               else{
                                   System.out.println("This Event not avaliabal for this Ride");
                               }
                           }
                           else if(inter == 3){
                               AddDetails AD=new AddDetails();
                               AD=AddDetailsController.Search(arr.get(ent-1).getId(),"Captain arrived to user location", rideControler.Search(arr.get(ent-1).getId()).getDriverID());
                               if(AD!=null){
                                e.getEventDetails().showEvent(e);
                                e.setDetails(AD);
                               }
                               else{
                                   System.out.println("This Event not avaliabal for this Ride");
                               }
                           }
                           else if(inter == 4){
                               AddDetails AD=new AddDetails();
                               AD=AddDetailsController.Search(arr.get(ent-1).getId(),"Captain arrived to user Destnation", rideControler.Search(arr.get(ent-1).getId()).getDriverID());
                               if(AD!=null){
                                e.getEventDetails().showEvent(e);
                                e.setDetails(AD);
                               }
                               else{
                                   System.out.println("This Event not avaliabal for this Ride");
                               }
                           }
                           
                       }
                   }
                   
    } 
}
