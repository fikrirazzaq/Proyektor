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
public class Proyektor {
    
    private String nama;
    private int kode;
    private int hargasewa;
    private static int stok;
    
    public Proyektor(String nama, int hargasewa){
        this.nama = nama;
        this.hargasewa = hargasewa;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama (){
        return nama;
    }
    
    public void setKode(int kode){
        this.kode = kode;
    }
    
    public int getKode (){
        return kode;
    }
    
    public void setHargaSewa(int hargasewa){
        this.hargasewa = hargasewa;
    }
    
    public int getHargaSewa (){
        return hargasewa;
    }
    
    public void setStok(int stok){
        this.stok = stok;
    }
    
    public int getStok (){
        return stok;
    }
}
