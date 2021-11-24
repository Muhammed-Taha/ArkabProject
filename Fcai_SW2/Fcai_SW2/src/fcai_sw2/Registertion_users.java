/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcai_sw2;

/**
 *
 * @author omer
 */
public abstract class Registertion_users extends General_user {
    boolean state=false;
    public  Registertion_users(){}
    public  Registertion_users(String username,String mobile_number,String email,String password,boolean state){
        super.username=username;
        super.mobile_number=mobile_number;
        super.email=email;
        super.password=password;
        this.state=state;
    }
    public abstract void printDetails();
    public abstract void printNotification();
    //public abstract boolean login(String user_name,String password); 
    public abstract void update(String pass);
}
