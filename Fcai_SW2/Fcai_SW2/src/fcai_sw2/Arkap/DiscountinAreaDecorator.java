/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.clientControler;
import DataBase.rideControler;

/**
 *
 * @author omer
 */
public class DiscountinAreaDecorator extends Decorator {
    String id;
    public DiscountinAreaDecorator(Discount discount,String id) {
        super(discount);
        this.id=id;
    }
    @Override
    public double cost(double price){
        for(int i=0;i<Admin.getDiscount().getDiscountAreas().size();i++){
            if(Admin.getDiscount().getDiscountAreas().get(i).equals(rideControler.Search(id).getDestinationArea())){
               return super.cost(price-(price*0.1));
            }
        }
        return super.cost(price);
    }

    @Override
    public int calcolateDiscount(int bouns) {
        for(int i=0;i<Admin.getDiscount().getDiscountAreas().size();i++){
            if(Admin.getDiscount().getDiscountAreas().get(i).equals(rideControler.Search(id).getDestinationArea())){
               return super.calcolateDiscount(bouns+10);
            }
        }
        return super.calcolateDiscount(bouns);
    }

}
