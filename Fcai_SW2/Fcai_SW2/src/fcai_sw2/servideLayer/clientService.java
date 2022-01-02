/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servideLayer;

import Arkap.Client;
import Arkap.Driver;
import java.util.ArrayList;
import java.util.Scanner;
import DataBase.*;
/**
 *
 * @author omer
 */
public class clientService {
    public static void list (){
               System.out.println("Enter 1 to Regesteration");
               System.out.println("Enter 2 to Login");
               System.out.println("Enter 0 to Logout");
    }
    public static void Regesteration(Scanner input,Client u){
            
                 String name,phone,pass,email; 
                 System.out.println("Enter your userName : ");
                 name=input.nextLine();
                 name=input.nextLine();
                 System.out.println("Enter your mobileName : ");
                 phone=input.next();
                 System.out.println("Enter your email : ");
                 email=input.next();
                 System.out.println("Enter your password : ");
                 pass=input.next();
                 System.out.println("Enter your birthDay : ");
                 String birth=input.next();
                 Client u1=new Client(name,phone,email,pass,0,birth);
                 u=u1;     
                 while(true){
                        System.out.println("Eneter 1 to make a Ride");
                        System.out.println("Enter 2 to display all driver and  make a rate for one of them");
                        System.out.println("Enter 3 to show notification");
                        System.out.println("Enter 0 to logout");
                        int x=input.nextInt();
                        if(x==1){
                         String sou;String des;
                         System.out.println("Enter sourceArea : ");
                         sou=input.next();
                         System.out.println("Enter destinationArea : ");
                         des=input.next();
                         System.out.println("Enter number of passanger : ");
                         int conterr=input.nextInt();
                         u.getCR().requestRide(u,sou, des,conterr);
                        }
                        else if(x==2){
                         ArrayList<Driver>list=new ArrayList <Driver>();
                         list=driverControler.All(true);
                        for(int i=0;i<list.size();i++){
                             System.out.print((i+1)+"- ");
                              System.out.print("Name of driver : "+list.get(i).getUserName()+"   ");
                              System.out.print("Number : "+list.get(i).getMobileNum()+"  ");
                              System.out.print("Email : "+list.get(i).getEmail()+"  ");
                              System.out.print("National Id : "+list.get(i).getNational_id()+"  ");
                              System.out.println("Rate : "+list.get(i).getRD().getAvgRate()+"  ");
                        }
                        int ch;
                        double r;
                        System.out.println("Enter the number of driver :");
                        ch=input.nextInt();
                        System.out.println("Enter the rate of driver :");
                        r=input.nextDouble();
                        u.getCR().makeRate(list.get(ch-1).getMobileNum(), r);
                       }
                        else if(x==3){
                            if(u.getCN().getNoti()!=null){
                                String arr[] = null;
                                for(int i=0;i<u.getCN().getNoti().size();i++){
                                    arr=u.getCN().getNoti().get(i).split("/");
                                      System.out.println(driverControler.search("Driver that his name is  "+arr[0]).getUserName()+" give you this offer "+arr[1]);
                                }
                                System.out.println("Enter number of offer that you accept");
                                int enter = input.nextInt();
                                arr=u.getCN().getNoti().get(enter-1).split("/");
                                rideControler.updatebyOffer(u.getMobileNum(), arr[0],Double.parseDouble(arr[1]));
                                rideControler.update(u.getMobileNum());
                                clientControler.clearAllNotification(u.getMobileNum());
                                driverControler.updateBalance(arr[0],Double.parseDouble(arr[1])+(Double.parseDouble(arr[1])*0.1));
                            }   
                          
                        } 
                        else if(x==0){
                            break;
                        }
                }
    }
    public static void LoginApp(Scanner input,Client u){
                 String name,pass; 
                 System.out.println("Enter your userName");
                 name=input.nextLine();
                 name=input.nextLine();
                 System.out.println("Enter your password");
                 pass=input.next();
                 u=(Client) u.login(name, pass);
                 if(u!=null){
                     System.out.println("You are logged in successfully");
                     while(true){
                            System.out.println("Eneter 1 to make a Ride");
                           System.out.println("Enter 2 to display all driver and his avgRating and  make a rate for one of them");
                           System.out.println("Enter 3 to show notification");
                           System.out.println("Enter 0 to Exist");
                           int x=input.nextInt();
                           if(x==1){
                            String sou;String des;
                            System.out.println("Enter sourceArea : ");
                            sou=input.next();
                            System.out.println("Enter destinationArea : ");
                            des=input.next();
                            System.out.println("Enter number of passanger : ");
                            int conterr=input.nextInt();
                            u.getCR().requestRide(u,sou, des,conterr);
                           }
                           else if(x==2){
                            ArrayList<Driver>list=new ArrayList <Driver>();
                            list=driverControler.All(true);
                           for(int i=0;i<list.size();i++){
                                System.out.print((i+1)+"- ");
                                System.out.print("Name of driver : "+list.get(i).getUserName()+"   ");
                                System.out.print("Number : "+list.get(i).getMobileNum()+"  ");
                                System.out.print("Email : "+list.get(i).getEmail()+"  ");
                                System.out.print("National Id : "+list.get(i).getNational_id()+"  ");
                                System.out.println("Rate : "+list.get(i).getRD().getAvgRate()+"  ");
                           }
                           int ch;
                           double r;
                           System.out.println("Enter the number of driver :");
                           ch=input.nextInt();
                           System.out.println("Enter the rate of driver :");
                           r=input.nextDouble();
                           u.getCR().makeRate(list.get(ch-1).getMobileNum(), r);
                          }
                           else if(x==3){
                              if(u.getCN().getNoti()!=null){
                                System.out.println("Not null");
                                for(int i=0;i<u.getCN().getNoti().size();i++){
                                    System.out.println(u.getCN().getNoti().get(i));
                                }
                            }   
                           }
                           else if (x==0){
                            break;
                           }
                     }
                 }
                 else if(u==null){
                    System.out.println("This account does not exist , you Should regester first");
                 }  
    }
    
}
