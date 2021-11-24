
package fcai_sw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author omer
 */
public class Ride {
    String sourceArea ;
    String  destinationArea;
    boolean state =false;
    String id;
    Ride(){
    }
    Ride(String sourceArea,String destinationArea,boolean s,String i){
      this.sourceArea=sourceArea ;
      this.destinationArea=destinationArea;  
      this.id=i;
      this.state=s;
      this.insert(sourceArea,destinationArea,i);
    }
    public void insert(String sourceArea,String destinationArea,String id)
    {  
        try {
             Year y = Year.now();
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `ride`");
            
            r.moveToInsertRow();
            r.updateString("sourceArea",sourceArea);
            r.updateString("destinationArea",destinationArea);
            r.updateString("id",id);
            r.updateBoolean("state", false);
            r.insertRow();            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void update(String id)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `ride` WHERE id = '"+id+"'");
            r.next();
            r.updateBoolean("state",true);
            r.updateRow();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static ArrayList All()
    {
        try {
            ArrayList<Ride> al=new ArrayList<Ride>();
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `ride`");
            while(r.next()&&r.getBoolean("state")==false)
            {
                Ride ride=new Ride();
                ride.sourceArea=r.getString("sourceArea");
                ride.destinationArea=r.getString("destinationArea");
                ride.id=r.getString("id");
                ride.state=r.getBoolean("state");
                al.add(ride);
            }
            return al;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
        

    }
    public Ride Search(String i)
    {
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT * FROM `ride` WHERE id = '"+i+"'");
            r.next();
                Ride ride=new Ride();
                ride.sourceArea=r.getString("sourceArea");
                ride.destinationArea=r.getString("destinationArea");
                ride.state=r.getBoolean("state");
                ride.id=r.getString("id");
                return ride;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
         return null;
    }
    public void printDetails(){
        System.out.print("From   "+ this.sourceArea+"     to\t");
        System.out.print(this.destinationArea);
    }
}
