/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.rideControler;

/**
 *
 * @author omer
 */
public class TwoPassangerDecorator extends Decorator {
   String id; 
    public TwoPassangerDecorator(Discount discount,String id) {
        super(discount);
        this.id=id;
    }
    
    @Override
    public double cost(double price){
        if(rideControler.Search(id).getNumberOfpassangers()==2){
        return super.cost(price-(price*0.05));
        }
        return super.cost(price);
    }

    @Override
    public int calcolateDiscount(int bouns) {
        if(rideControler.Search(id).getNumberOfpassangers()==2){
        return super.calcolateDiscount(bouns+5);
        }
        return super.calcolateDiscount(bouns);
    }
}
    

