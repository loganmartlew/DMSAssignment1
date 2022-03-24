/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coen-
 */
public class UserAccount {
    
    private String userName;
    private String password;
    
    public UserAccount(){}
    
    public UserAccount(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    public String getUser(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUser(String user){
        this.userName = user;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }
}
