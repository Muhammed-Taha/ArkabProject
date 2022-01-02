/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.clientControler;

/**
 *
 * @author omer
 */
public class firstRideDecorator  extends Decorator {
   String id;
    public firstRideDecorator(Discount discount,String id) {
        super(discount);
        this.id=id;
    }
    
    @Override
    public double cost(double price){
        if(clientControler.Search(id).getCounter()==0)
        {
           clientControler.updateCounter(id);
          return super.cost(price-(price*0.1));
        }
        return super.cost(price);
    }

    @Override
    public int calcolateDiscount(int bouns) {
       if(clientControler.Search(id).getCounter()==0)
        {
           clientControler.updateCounter(id);
          return super.calcolateDiscount(bouns+10);
        }
        return super.calcolateDiscount(bouns);
    }
}
    

