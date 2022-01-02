/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servideLayer;

import DataBase.driverControler;
import DataBase.rideControler;
import Arkap.Driver;
import Arkap.Ride;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omer
 */
public class driverService {
    public static void list (){
               System.out.println("Enter 1 to Regesteration");
               System.out.println("Enter 2 to Login");
               System.out.println("Enter 0 to Logout");
    }
    public static void Regesteration(Scanner input,Driver d){
                  System.out.println("Enter your userName : ");
                   String username=input.nextLine();
                   username=input.nextLine();
                   System.out.println("Enter your mobileName : ");
                   String mobile_number=input.next();
                   System.out.println("Enter your email : ");
                   String email=input.next();
                   System.out.println("Enter your password : ");
                   String password=input.next();
                   System.out.println("Enter your driving_license : ");
                   String driving_license=input.next();
                   System.out.println("Enter your national_id : ");
                   String national_id=input.next();
                   Driver d1=new Driver(username,mobile_number,email, password, driving_license, national_id,0) ;  
                   d=d1;
                   System.out.println("Wait for verify from Admin"); 
    }
    public static void LoginApp(Scanner input,Driver d){
                  System.out.println("Enter your userName : ");
                   String user_name=input.nextLine();
                   user_name=input.nextLine();
                   System.out.println("Enter your password : ");
                    String password=input.next();
                   d=d.login(user_name,password);
                   
                   if(d!=null){
                       while(true){
                        System.out.println("Enter 1 to display all Ride and make offer");
                        System.out.println("Enter 2 to display all rates for me");
                        System.out.println("Enter 3 to add favourite source area");
                        System.out.println("Enter 4 to show favourite source area");
                        System.out.println("Enter 0 to Logout");
                        int ch=input.nextInt();
                        if(ch==1){
                            //rideControler.setRideList(rideControler.All());
                            for(int i=0;i<d.getRideList().size();i++){
                                System.out.print((i+1)+"- ");
                                System.out.print("From   "+ d.getRideList().get(i).getSourceArea()+"     to\t");
                                System.out.print(d.getRideList().get(i).getDestinationArea());
                                System.out.println();
                            }
                            System.out.println("Enter number of ride : ");
                            int s=input.nextInt();
                            System.out.println("Enter your Suggestion price");
                            double price=input.nextDouble();
                            d.suggestPrice(d.getRideList().get(s-1).getId(),price);
                        }
                        else if(ch==2){
                            d.getRD().getRates();
                        }
                        else if(ch==3){
                            System.out.println("Enter your favourite source area ");
                            String area=input.next();
                            d.getFA().addFavoriteAreas(area,d);
                        }
                        else if(ch==4){
                            ArrayList<String> al=driverControler.allFavorite(d.getMobileNum());
                            for(int i=0;i<al.size();i++){
                                System.out.println((i+1)+"- "+al.get(i));
                            }
                        }
                        else if(ch==0){
                            break;
                        }  
                       }
                   }
                   else if(d==null){
                       System.out.println("This account not exists or in wationg admin to verify it");
                   }
    }
}
