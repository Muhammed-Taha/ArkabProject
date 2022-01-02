/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author omer
 */
public class publicHolidayDecorator extends Decorator {
    
    public publicHolidayDecorator(Discount discount) {
        super(discount);
    }
    public boolean checkHoliday(){
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
        if (dayOfWeek == 1 || dayOfWeek == 7){
            return true;
        } else {
            return false;
        }
    }
     
    @Override
    public double cost(double price){
        if(checkHoliday()){
          return super.cost(price-(price*0.05));
        }
        return super.cost(price);
    }

    @Override
    public int calcolateDiscount(int bouns) {
        if(checkHoliday()){
          return super.calcolateDiscount(bouns+5);
        }
        return super.calcolateDiscount(bouns);
    }
}
    