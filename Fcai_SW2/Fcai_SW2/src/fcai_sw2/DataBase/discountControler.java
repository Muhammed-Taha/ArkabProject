/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Arkap.DiscountArea;
import Arkap.Ride;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class discountControler {
    static public  void insert(String areaName)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("discount");
            r.moveToInsertRow();
            r.updateString("areaName",areaName);
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    } 
    public static ArrayList All()
    {
        try {
            ArrayList<String> al=new ArrayList<String>();
            ResultSet r=dataBase.getInstance().connection("discount");
            while(r.next())
            {
                 al.add(r.getString("areaName"));
            }
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    static public  void delete(String areaName)
    {
        try {
            ResultSet r=dataBase.getInstance().connection("discount");
            r.next();
            r.deleteRow();         
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }         
}
