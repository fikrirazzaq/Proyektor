/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lazuardi
 */
public abstract class Orang {
    
    private String username;
    private String password;
    private String nama;
    private int id;
    
    public Orang(String nama, String username, String password){
        this.username = username;
        this.nama = nama;
        this.password = password;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama (){
        return nama;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername (){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword (){
        return password;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId (){
        return id;
    }
}
