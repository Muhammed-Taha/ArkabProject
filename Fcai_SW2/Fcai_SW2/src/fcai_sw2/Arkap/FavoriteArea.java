/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkap;

import DataBase.driverControler;
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class FavoriteArea {
     static ArrayList<String> favoriteAreas=new ArrayList<String>(); 
     static public void  addFavoriteAreas(String favoriteArea,Driver d){
        favoriteAreas.add(favoriteArea);
        driverControler.addFavoritetoDataBase(d.getMobileNum(),favoriteArea);
    } 

    public static ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public static void setFavoriteAreas(ArrayList<String> favoriteAreas) {
        FavoriteArea.favoriteAreas = favoriteAreas;
    }
     
}
