/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lazuardi
 */
public class Peminjaman {
    
    private String kode;
    private int index;
    private Proyektor[] proyektor;
    private Anggota peminjam;
    private ArrayList<Orang> listOrang;
    private ArrayList<Proyektor> listProyektor;
    
    public void addProyektor(Proyektor p){
        listProyektor.add(p);
    }
    
    public void setAnggota(String username,String password, String nama){
        listOrang.add(new Anggota(nama, username, password));
    }
        
    public void removeProyektor(String kode){
        listProyektor.remove(kode);
    }
    
    public Proyektor getProyektorByIndex(int index){
        Object[]array = listProyektor.toArray();
        return (Proyektor)array[index];
    }
    
    public Proyektor getProyektorByKode(int kode){
        for (Proyektor p : listProyektor){
            if (p.getKode() == kode){
                return p;
            }
        }
        return null;
    }
}
