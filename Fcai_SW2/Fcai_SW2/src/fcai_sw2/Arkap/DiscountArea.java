/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.discountControler;
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class DiscountArea {
    private String areaName;
    static ArrayList<String>DiscountAreas = new ArrayList<String>();

    public DiscountArea(String areaName) {
        this.areaName = areaName;
        DiscountAreas=discountControler.All();
    }
    public DiscountArea(){}
    public void addDiscounttoarea(String area){
       this.areaName=area;
       discountControler.insert(areaName);
       DiscountAreas.add(area);
     }
    public void removeDiscounttoarea(String area){
       discountControler.delete(areaName);
       DiscountAreas.remove(area);
     }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
   public static ArrayList<String> getDiscountAreas() {
        return DiscountAreas;
    }

    public static void setDiscountAreas(ArrayList<String> DiscountAreas) {
        DiscountArea.DiscountAreas = DiscountAreas;
    }
    public String getAreaName() {
        return areaName;
    }
}
