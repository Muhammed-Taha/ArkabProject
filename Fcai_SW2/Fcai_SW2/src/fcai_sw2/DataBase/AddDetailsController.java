/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Arkap.AddDetails;
import Arkap.Ride;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import Arkap.*;
/**
 *
 * @author omer
 */
public class AddDetailsController {
    static ArrayList<AddDetails>rideList=new ArrayList<AddDetails>();
    public static  void insert(String Cphone,String Dphone,String Rid)
    {  
        try {
             Year y = Year.now();
            ResultSet r=dataBase.getInstance().connection("AddDetails");
            r.moveToInsertRow();
            r.updateString("Cphone",Cphone);
            r.updateString("Dphone",Dphone);
            r.updateString("Rid",Rid);
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
            ArrayList<AddDetails> al=new ArrayList<AddDetails>();
            ResultSet r=dataBase.getInstance().connection("AddDetails");
            while(r.next())
            { 
                    AddDetails Dride=new AddDetails();
                    Dride.setCphone(r.getString("Cphone"));
                    Dride.setDphone(r.getString("Dphone"));
                    Dride.setRid(r.getString("Rid"));
                    al.add(Dride);
            }
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
        

    }
}
