/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

/**
 *
 * @author omer
 */
public abstract class Decorator implements Discount {
    private Discount Dis;
    public Decorator(Discount discount){
        this.Dis=discount;
    }
    @Override
    public double cost(double price){
        return this.Dis.cost(price);
    }
    @Override
    public int calcolateDiscount(int bouns)
    {
    return this.Dis.calcolateDiscount(bouns);
    }
}
