/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcai_sw2;

//import static fcai_sw2.Admin.driverList;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omer
 */
public class Fcai_SW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Admin a=new Admin();
        int choose=0;
        Scanner input=new Scanner(System.in);  
        User u=new User();
        Driver d=new Driver();
        while(true){
           System.out.println("Enter 1 to use progeam as User");
           System.out.println("Enter 2 to use progeam as driver");
           System.out.println("Enter 3 to use progeam as Admin");
           System.out.println("Enter 0 to exit app");
           choose=input.nextInt();
           if(choose==1){
               System.out.println("Enter 1 to Regesteration");
               System.out.println("Enter 2 to Login");
               System.out.println("Enter 0 to Logout");
               int c=input.nextInt();
               if(c==1){
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
                 User u1=new User(name,phone,email,pass);
                 u=u1;     
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
                  u.requestRide(sou, des);
                 }
                 else if(x==2){
                  ArrayList<Driver>list=new ArrayList <Driver>();
                  list=Driver.All();
                 for(int i=0;i<list.size();i++){
                      System.out.print((i+1)+"- ");
                      list.get(i).printDetails();
                 }
                 int ch;
                 double r;
                 System.out.println("Enter the number of driver :");
                 ch=input.nextInt();
                 System.out.println("Enter the rate of driver :");
                 r=input.nextDouble();
                 u.makeRate(list.get(ch-1).mobile_number, r);
                }
                 else if(x==3){
                    u.printNotification();
                 } 
                 else if(x==0){
                     break;
                 }
               }
               else if(c==2){
                 String name,pass; 
                 System.out.println("Enter your userName");
                 name=input.nextLine();
                 name=input.nextLine();
                 System.out.println("Enter your password");
                 pass=input.next();
                 u=u.login(name, pass);
                 if(u!=null){
                     System.out.println("You are logged in successfully");
                     System.out.println("Eneter 1 to make a Ride");
                    System.out.println("Enter 2 to display all driver and his avgRating and  make a rate for one of them");
                    System.out.println("Enter 3 to show notification");
                    int x=input.nextInt();
                    if(x==1){
                     String sou;String des;
                     System.out.println("Enter sourceArea : ");
                     sou=input.next();
                     System.out.println("Enter destinationArea : ");
                     des=input.next();
                     u.requestRide(sou, des);
                    }
                    else if(x==2){
                     ArrayList<Driver>list=new ArrayList <Driver>();
                     list=Driver.All();
                    for(int i=0;i<list.size();i++){
                         System.out.print((i+1)+"- ");
                         list.get(i).printDetails();
                    }
                    int ch;
                    double r;
                    System.out.println("Enter the number of driver :");
                    ch=input.nextInt();
                    System.out.println("Enter the rate of driver :");
                    r=input.nextDouble();
                    u.makeRate(list.get(ch-1).mobile_number, r);
                   }
                    else if(x==3){
                       u.printNotification();
                    } 
                 }
                 else if(u==null){
                    System.out.println("This account does not exist , you Should regester first");
                 }     
               }
           }
           else if(choose==2){
               System.out.println("Enter 1 to Regesteration");
               System.out.println("Enter 2 to Login");
               System.out.println("Enter 0 to Logout");
               int c=input.nextInt();
               if(c==1){
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
                   Driver d1=new Driver(username,mobile_number,email, password, driving_license, national_id) ;  
                   d=d1;
                   System.out.println("Wait for verify from Admin");                  
               }
               else if(c==2){
                   System.out.println("Enter your userName : ");
                   String user_name=input.nextLine();
                   user_name=input.nextLine();
                   System.out.println("Enter your password : ");
                    String password=input.next();
                   d=d.login(user_name,password);
                   if(d!=null){
                        System.out.println("Enter 1 to display all Ride and make offer");
                        System.out.println("Enter 2 to display all rates for me");
                        System.out.println("Enter 3 to add favourite source area");
                        System.out.println("Enter 4 to show favourite source area");
                        System.out.println("Enter 0 to Logout");
                        int ch=input.nextInt();
                        if(ch==1){
                            d.rideList=Ride.All();
                            for(int i=0;i<d.rideList.size();i++){
                                System.out.print((i+1)+"- ");
                                d.rideList.get(i).printDetails();
                            }
                            System.out.println("Enter number of ride : ");
                            int s=input.nextInt();
                            System.out.println("Enter your Suggestion price");
                            double price=input.nextDouble();
                            d.suggestPrice(d.rideList.get(s-1).id,price);
                        }
                        else if(ch==2){
                            d.getRates();
                        }
                        else if(ch==3){
                            System.out.println("Enter your favourite source area ");
                            String area=input.next();
                            d.addFavoriteAreas(area);
                        }
                        else if(ch==4){
                            ArrayList<String> al=d.allFavorite(d.mobile_number);
                            for(int i=0;i<al.size();i++){
                                System.out.println((i+1)+"- "+al.get(i));
                            }
                        }
                        else if(ch==0){
                            break;
                        }   
                   }
                   else if(d==null){
                       System.out.println("This account not exists or in wationg admin to verify it");
                   }
               }
               else if(c==0){
                   break;
               }
           }
           else if(choose==3){
                   System.out.println("Enter your userName : ");
                   String user_name=input.next();
                   System.out.println("Enter your password : ");
                   String password=input.next();
                   if((user_name.toLowerCase().equals("admin"))&&(password.toLowerCase().equals("admin"))){
                       System.out.println("Enter 1 to verify ");
                       System.out.println("Enter 2 to Suspend Driver");
                       System.out.println("Enter 3 to Suspend User");
                       int r=input.nextInt();
                       if(r==1){
                           a.driverVerfiy();
                       }
                       else if(r==2){
                           a.driverList=Driver.All();
                           for(int i=0;i<a.driverList.size();i++){
                               System.out.print((i+1)+"- ");
                               a.driverList.get(i).printDetails();
                           }
                           System.out.println("Enter number of driver : ");
                           int cc=input.nextInt();
                           a.Suspend(a.driverList.get(cc-1));
                      }
                       else if(r==3){
                            a.U_list=User.All();
                            for(int i=0;i<a.U_list.size();i++){
                              System.out.print((i+1)+"- ");
                               a.U_list.get(i).printDetails();
                           }
                           System.out.println("Enter number of User : ");
                           int cc=input.nextInt();
                           a.Suspend(a.U_list.get(cc-1));
                       }
                       
                   }
                   
           }
           else if(choose==0){
               System.out.println("Thanks for use my app");
               break;
           }
        }
        
    }
    
}
