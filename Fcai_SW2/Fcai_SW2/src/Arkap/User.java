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
public  class  User {
    private String userName ;
    private String mobileNum;
    private String email;
    private String passWord;
    private boolean state;
    
    public User() {
    }

    public User(String userName, String mobileNum, String email, String passWord, boolean state) {
        this.userName = userName;
        this.mobileNum = mobileNum;
        this.email = email;
        this.passWord = passWord;
        this.state= state;
    }

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
     
    public String getMobileNum() {
        return mobileNum;
    }
 
    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }
   
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
