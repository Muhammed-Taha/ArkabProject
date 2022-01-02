/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

//import static fcai_sw2.Admin.driverList;
import java.util.ArrayList;
import java.util.Scanner;
import servideLayer.*;
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
        Client u=new Client();
        Driver d=new Driver();
        while(true){
           adminService.show();
           choose=input.nextInt();
           if(choose==1){
               clientService.list();
               int c=input.nextInt();
               if(c==1){
                  clientService.Regesteration(input,u);
               }
               else if(c==2){
                   clientService.LoginApp(input, u);
               }
           }
           else if(choose==2){
               driverService.list();
               int c=input.nextInt();
               if(c==1){
                  driverService.Regesteration(input, d);
               }
               else if(c==2){
                   driverService.LoginApp(input, d);
               }
               else if(c==0){
                   break;
               }
           }
           else if(choose==3){
                   adminService.Enter(input, a);
           }
           else if(choose==0){
               System.out.println("Thanks for use my app");
               break;
           }
        }
        
    }
    
}
