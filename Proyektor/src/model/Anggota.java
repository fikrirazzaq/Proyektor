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
public class Anggota extends Orang {
    
    private String username;
    private String password;
    private String nama;
    private int id;
    
    public Anggota(String nama, String username, String password){
        super(nama, username, password);
    }
    
    @Override
    public void setNama(String nama){
        this.nama = nama;
    }
    
    @Override
    public String getNama (){
        return nama;
    }
    
    @Override
    public void setUsername(String username){
        this.username = username;
    }
    
    @Override
    public String getUsername (){
        return username;
    }
    
    @Override
    public void setPassword(String password){
        this.password = password;
    }
    
    @Override
    public String getPassword (){
        return password;
    }
    
    @Override
    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public int getId (){
        return id;
    }
}
