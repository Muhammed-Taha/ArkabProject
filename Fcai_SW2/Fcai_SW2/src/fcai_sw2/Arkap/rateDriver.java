/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class rateDriver {
    static ArrayList<String> rateing=new ArrayList<String>();
    static  String rates;  
    static   public double getAvgRate()
    {
       double avgRate=0;
       if(rates!=null){
        String [] arr;
        arr=rates.split("/");
        for(int i=0;i<arr.length;i++){
            avgRate+=Double.parseDouble(arr[i]);
        }
       }
       return avgRate;
    }
   static  public void getRates()
    { 
       double avgRate=0;
       String [] arr;
       arr=rates.split("/");
       for(int i=0;i<arr.length;i++){  
          rateDriver.rateing.add(arr[i]);
          System.out.println(arr[i]);
       }    
    }
   
}
