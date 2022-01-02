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
public class NoDiscount implements Discount {

    @Override
    public double cost(double price) {
        return price;
    }

    @Override
    public int calcolateDiscount(int bouns) {
        return bouns;
    }
    
}
