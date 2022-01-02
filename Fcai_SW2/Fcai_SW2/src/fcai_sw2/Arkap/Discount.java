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
interface Discount {
    public abstract int calcolateDiscount(int bouns); 
    public abstract double cost(double price); 
}
