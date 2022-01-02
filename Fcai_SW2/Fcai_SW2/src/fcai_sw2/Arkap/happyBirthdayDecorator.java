/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.clientControler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author omer
 */
public class happyBirthdayDecorator extends Decorator {
    String id;
    public happyBirthdayDecorator(Discount discount,String id) {
        super(discount);
        this.id=id;
    }

    @Override
    public double cost(double price){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
        LocalDateTime now = LocalDateTime.now();  
        String Birth=dtf.format(now); 
        if(clientControler.Search(id).getBirthDay().equals(Birth)){
          return super.cost(price-(price*0.05));
        }
        return super.cost(price);
    }

    @Override
    public int calcolateDiscount(int bouns) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
        LocalDateTime now = LocalDateTime.now();  
        String Birth=dtf.format(now); 
        if(clientControler.Search(id).getBirthDay().equals(Birth)){
          return super.calcolateDiscount(bouns+5);
        }
        return super.calcolateDiscount(bouns);
    }
}
    