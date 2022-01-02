/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author omer
 */
public class dataBase {
    private static  dataBase instance;
    public static dataBase getInstance(){
        if(instance == null){
            instance = new dataBase();
        }
        return instance;
    }
    public ResultSet connection(String tableName) throws SQLException{
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost/fcai_sw2?serverTimezone=UTC", "admin","fci20190352");
            Statement s = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String q="SELECT * FROM tname";
            String querey=q.replaceAll("tname",tableName );
            ResultSet r = s.executeQuery(querey);
            return r;
    }
}
