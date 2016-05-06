/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import configdb.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import viewlogin.*;
import viewpetugas.*;
import viewanggota.*;

/**
 *
 * @author Juvetic
 */
public class Controller implements ActionListener {

    
    private Connection con;
    private Statement stmt;
    private ResultSet rs;    
    private DBConnection dbcon;
    
    private String currentView;
    private JPanel mainPanel;
    private JPanel mainPanelAnggota; 
    
    private LoginPetugas viewLoginPetugas;
    private RegisPetugas viewRegPetugas;
    
    private MenuUtamaAnggota viewUtamaAnggota;
    private MenuUtama viewUtama;

    private MenuProyektor mp;
    private LihatProyektor lp;
    private TambahProyektor tp;
    
    private MenuPeminjaman mj;
    private MenuPengembalian mb;
    private TambahPengembalian tb;
    private TambahPeminjaman tj;
    private LihatPeminjaman lj;
    
    private MenuAnggota ma;
    private TambahAnggota ta;
    private LihatAnggota la;
    
    private BrowseAnggota ba;
    private BrowseProyektor bp;
    
    private LihatPeminjamanAnggota lpa;
    
    private BuatLaporan bl;
    private MenuUser mu;
    
    private static String username; //**
    DefaultTableModel tabelModel;
    
    public Controller() {
        
        //Buat Koneksi
        dbcon = new DBConnection();
        con = dbcon.openConnection();
        
        //Buat Objek Tiap Menu
        this.viewLoginPetugas = new LoginPetugas();
        this.viewRegPetugas = new RegisPetugas();
        this.viewUtama = new MenuUtama();
        this.viewUtamaAnggota = new MenuUtamaAnggota();
        
        //subMenu-menu petugas
        this.mp = new MenuProyektor();
        this.lp = new LihatProyektor();
        this.mj = new MenuPeminjaman();
        this.mb = new MenuPengembalian();
        this.tb = new TambahPengembalian();
        this.tj = new TambahPeminjaman();
        this.tp = new TambahProyektor();
        this.lj = new LihatPeminjaman();
        this.bl = new BuatLaporan();
        this.mu = new MenuUser();
        this.ma = new MenuAnggota();
        this.ta = new TambahAnggota();
        this.la = new LihatAnggota();
        
        //Browse
        this.ba = new BrowseAnggota();
        this.bp = new BrowseProyektor();
       
        //subMenu-menu anggota
        this.lpa = new LihatPeminjamanAnggota();
        
        viewUtama.addListener(this);
        viewLoginPetugas.addListener(this);
        viewRegPetugas.addListener(this);
        viewUtamaAnggota.addListener(this);
        mb.addListener(this);
        mp.addListener(this);
        mj.addListener(this);
        bl.addListener(this);
        mu.addListener(this);
        tp.addListener(this);
        tb.addListener(this);
        tj.addListener(this);
        ma.addListener(this);
        ta.addListener(this);
        
        //Pemberian Kode Tiap Menu
        mainPanel = viewUtama.getMainPanel();
        mainPanel.add(mp, "0"); //0
        mainPanel.add(lp, "1"); //1
        mainPanel.add(tp, "2"); //2
        mainPanel.add(mj, "3"); //3
        mainPanel.add(mb, "4"); //4
        mainPanel.add(tb, "5"); //5
        mainPanel.add(tj, "6"); //6
        mainPanel.add(lj, "7"); //7
        mainPanel.add(bl, "8"); //8
        mainPanel.add(mu, "9"); //9
        mainPanel.add(ma, "10"); //10
        mainPanel.add(ta, "11"); //11
        mainPanel.add(la, "12"); //12
        
        mainPanelAnggota = viewUtamaAnggota.getMainPanel();
        mainPanelAnggota.add(lpa, "11");
        
        viewLoginPetugas.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Buat source
        Object source = e.getSource();
        
        //Button Menu Proyektor
        if(source.equals(viewUtama.getBtnProyektor()))
        {
            currentView = "0";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Menu Peminjaman
        else if(source.equals(viewUtama.getBtnPeminjaman()))
        {
            currentView = "3";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Menu Pengembalian
        else if(source.equals(viewUtama.getBtnPengembalian()))
        {
            currentView = "4";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Menu Pelaporan
        else if (source.equals(viewUtama.getBtnPelaporan()))
        {
            currentView = "8";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Menu Anggota
        else if (source.equals(viewUtama.getBtnAnggota()))
        {
            currentView = "10";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Tambah Anggota
        else if (source.equals(ma.getBtnTambahAnggota()))
        {
            currentView = "11";
            viewUtama.getCardLayout().show(mainPanel, currentView);
            la.getTblAnggota().repaint();
        }
        
        //Button Lihat Anggota
        else if (source.equals(ma.getBtnLihatAnggota()))
        {
            currentView = "12";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Menu Akun Saya
        else if (source.equals(viewUtama.getBtnAkunSaya()))
        {
            viewUtama.dispose();
            viewLoginPetugas.setVisible(true);
            viewLoginPetugas.getTxtUsername().setText("");
            viewLoginPetugas.getTxtPassword().setText("");
        }
        
        //Button Tambah Proyektor
        else if (source.equals(mp.getBtnTambahProyektor()))
        {
            currentView = "2";
            viewUtama.getCardLayout().show(mainPanel, currentView);
            lp.getTblProyektor().repaint();
        }
        
        //Button Lihat Proyektor
        else if (source.equals(mp.getBtnLihatProyektor()))
        {
            currentView = "1";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Tambah Peminjaman
        else if (source.equals(mj.getBtnTambahPeminjaman()))
        {
            currentView = "6";
            viewUtama.getCardLayout().show(mainPanel, currentView);
            lj.getTblPeminjaman().repaint();
        }
        
        //Button Lihat Peminjaman
        else if (source.equals(mj.getBtnLihatDataPeminjaman()))
        {
            currentView = "7";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Button Tambah Pengembalian
        else if (source.equals(mb.getBtnTambahPb()))
        {
            currentView = "5";
            viewUtama.getCardLayout().show(mainPanel, currentView);
            lj.getTblPeminjaman().repaint();
        }
        
        //Button Lihat Pengembalian
        else if (source.equals(mb.getBtnLihatPb()))
        {
            currentView = "7";
            viewUtama.getCardLayout().show(mainPanel, currentView);
        }
        
        //Simpan Data Proyektor
        else if (source.equals(tp.getBtnSimpan()))
        {
            if(!tp.getTxMerek().getText().isEmpty())
            {
                if(!tp.getTxHarga().getText().isEmpty())
                {
                    if(!tp.getTxJumlah().getText().isEmpty())
                    {
                        try 
                        {
                            stmt = con.createStatement();
                            String sql = "INSERT INTO `t_proyektor` "
                                    + "(`pr_nama`, `pr_harga`, `pr_stok`) "
                                    + "VALUES ('" + tp.getTxMerek().getText() + "', "
                                    + "'" + tp.getTxHarga().getText() + "', "
                                    + "'" + tp.getTxJumlah().getText() + "');";
                            stmt.executeUpdate(sql);
                            tp.getTxHarga().setText("");
                            tp.getTxJumlah().setText("");
                            tp.getTxMerek().setText("");
                            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                        } catch (SQLException ex) {
                                System.out.println("Error " + ex);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Isi Jumlah!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Isi Harga Sewa!");
                }
            }
            else    
            {
                JOptionPane.showMessageDialog(null, "Isi Merk!");
            }
            
        }
        
        //Simpan Data Peminjaman
        else if (source.equals(tj.getBtnSimpan()))
        {
            if(!tj.getTxIDAnggota().getText().isEmpty())
            {
                if(!tj.getTxTglPinjam().getText().isEmpty())
                {
                    if(!tj.getTxTglJatuhTempo().getText().isEmpty())
                    {
                        if(!tj.getTxIDProyektr().getText().isEmpty())
                        {
                            try 
                            {
                                stmt = con.createStatement();
                                String sql = "INSERT INTO `t_peminjaman` "
                                        + "(us_id, pj_tglpinjam, pj_tgljatuhtempo, pr_id, pj_status) "
                                        + "VALUES (" + tj.getTxIDAnggota().getText() + ", "
                                        + "'" + tj.getTxTglPinjam().getText() + "', "
                                        + "'" + tj.getTxTglJatuhTempo().getText() + "', "
                                        + tj.getTxIDProyektr().getText() + ", "
                                        + "'Belum Kembali')";
                                stmt.executeUpdate(sql);
                                tj.getTxTglPinjam().setText("");
                                tj.getTxTglJatuhTempo().setText("");
                                tj.getTxIDProyektr().setText("");
                                tj.getTxIDAnggota().setText("");
                                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                            } catch (SQLException ex) {
                                    System.out.println("Error " + ex);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Isi ID Proyektor!");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Isi Tanggal Jatuh Tempo!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Isi Tanggal Pinjam!");
                }
            }
            else    
            {
                JOptionPane.showMessageDialog(null, "Isi ID Anggota!");
            }
            
        }
        
        //Simpan Data Pengembalian
        else if (source.equals(tb.getBtnSimpan()))
        {
            if(!tb.getTxIDPeminjaman().getText().isEmpty())
            {
                if(!tb.getTxTglJatuhTempo().getText().isEmpty())
                {
                    if(!tb.getTxTglKembali().getText().isEmpty())
                    {
                        if(!tb.getTxHari().getText().isEmpty())
                        {
                            if(!tb.getTxDenda().getText().isEmpty())
                            {
                                try 
                                {
                                    stmt = con.createStatement();
                                    String sql = "UPDATE `t_peminjaman` "
                                            + "SET `pj_tglkembali`='" + tb.getTxTglKembali().getText() + "',"
                                            + "`pj_terlambathari`=" + tb.getTxHari().getText() + ","
                                            + "`pj_denda`=" + tb.getTxDenda().getText() + ","
                                            + "`pj_status`='Sudah Kembali' "
                                            + "WHERE pj_id=" + tb.getTxIDPeminjaman().getText();
                                    stmt.executeUpdate(sql);
                                    tb.getTxHari().setText("");
                                    tb.getTxTglJatuhTempo().setText("");
                                    tb.getTxTglKembali().setText("");
                                    tb.getTxDenda().setText("");
                                    tb.getTxIDPeminjaman().setText("");
                                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                                } catch (SQLException ex) {
                                        System.out.println("Error " + ex);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Cek Denda!");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Isi Keterlambatan Hari!");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Isi Tanggal Kembali!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Cek Tanggal Jatuh Tempo!");
                }
            }
            else    
            {
                JOptionPane.showMessageDialog(null, "Isi ID Peminjaman!");
            }
        }
        
        //Tambah Pengembalian -> Cek Tanggal Jatuh Tempo
        else if (source.equals(tb.getBtnCekTglJatuh()))
        {
            try {
                String sql = "SELECT pj_tgljatuhtempo FROM t_peminjaman "
                        + "WHERE pj_id=" + tb.getTxIDPeminjaman().getText();

                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                    String tgl = rs.getString(1);
                    tb.getTxTglJatuhTempo().setText(tgl);
                }              
            } catch (SQLException ex) {
                System.out.println("Data gagal ditampilkan!" + ex);
            }
        }
        
        //Tambah Pengembalian -> Cek Denda
        else if (source.equals(tb.getBtnCekDenda()))
        {
            int denda = Integer.parseInt(tb.getTxHari().getText()) * 1000;
            tb.getTxDenda().setText(Integer.toString(denda));
        }
        
        //Login Petugas -> Masuk
        else if (source.equals(viewLoginPetugas.getBtnLogin()))
        {
            if(!viewLoginPetugas.getTxtUsername().getText().isEmpty())
            {
                if(!viewLoginPetugas.getTxtPassword().getText().isEmpty())
                {
                    try {
                        String us = "";
                        String pass = "";
                        
                        // Create SQL Query
                        stmt = con.createStatement();
                        String sql = "SELECT us_username, us_password "
                                + "FROM t_user "
                                + "WHERE us_username='" + viewLoginPetugas
                                        .getTxtUsername().getText()
                                + "' AND us_password='" + viewLoginPetugas
                                        .getTxtPassword().getText() + "'";
                        rs = stmt.executeQuery(sql);

                        // Check Username and Password
                        while (rs.next()) {
                            us = rs.getString(1);
                            pass = rs.getString(2);
                        }

                        // Cek username & pass benar
                        if (viewLoginPetugas.getTxtUsername().getText().equals(us) 
                                && viewLoginPetugas.getTxtPassword().getText().equals(pass))
                        {
                            viewLoginPetugas.dispose(); //View Login di-close
                            viewUtama.setVisible(true);
                            
                            //Main Panel -> Menu Peminjaman
                            currentView = "3";
                            viewUtama.getCardLayout().show(mainPanel, currentView);
                            
                            //Pembertahuan "Selamat Datang"
                            JOptionPane.showMessageDialog(null, "Selamat Datang, " + us + "!");
                        } else {
                            viewLoginPetugas.getTxtUsername().setText("");
                            viewLoginPetugas.getTxtPassword().setText("");
                            JOptionPane.showMessageDialog(null, 
                                    "Kata Pengguna atau Kata Sandi salah!");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error" + ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Isi Kata Sandi!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Isi Kata Pengguna!");
            }
        }
        
        //Login Petugas -> Buat Akun
        else if (source.equals(viewLoginPetugas.getBtnRegistrasi()))
        {
            viewLoginPetugas.dispose(); //View Login di-close
            viewRegPetugas.setVisible(true);
        }
        
        //Login Anggota -> Masuk
        else if (source.equals(viewLoginPetugas.getBtnLihatPinjam()))
        {
            viewLoginPetugas.dispose();
            viewUtamaAnggota.setVisible(true);
        }
        
        //Cetak Laporan
        else if (source.equals(bl.getBtnLaporan()))
        {
            JOptionPane.showMessageDialog(null, "Coming soon!");
        }
        
        //Browse Pinjam
        else if (source.equals(bl.getBtnLaporan()))
        {
            bp.setVisible(true);
        }
        
        //Regis Petugas
        else if (source.equals(viewRegPetugas.getBtnBuatAkun()))
        {
            if(!viewRegPetugas.getTxtNama().getText().isEmpty())
            {
                if(!viewRegPetugas.getTxtUsername().getText().isEmpty())
                {
                    if(!viewRegPetugas.getTxtPassword().getText().isEmpty())
                    {
                        try {
                            stmt = con.createStatement();
                            String sql = "INSERT INTO "
                                    + "t_user (us_nama, us_username, us_password, us_status) "
                                    + "VALUES ('" + viewRegPetugas.getTxtNama().getText() + "', "
                                    + "'" + viewRegPetugas.getTxtUsername().getText() + "', "
                                    + "'" + viewRegPetugas.getTxtPassword().getText() + "', "
                                    + "'Petugas')";
                            stmt.executeUpdate(sql);
                            
                            JOptionPane.showMessageDialog(null, "Akun berhasil dibuat!");
                            
                            viewRegPetugas.dispose();
                            viewLoginPetugas.setVisible(true);
                            
                            viewLoginPetugas.getTxtUsername().setText("");
                            viewLoginPetugas.getTxtPassword().setText("");
                            } catch (SQLException ex) {
                                System.out.println("Error " + ex);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Isi Kata Sandi!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Isi Kata Pengguna!");
                }
            }
            else    
            {
                JOptionPane.showMessageDialog(null, "Isi Nama!");
            }
        }
        
        //Regis Anggota
        else if (source.equals(ta.getBtnSimpan()))
        {
            if(!ta.getTxNamaAnggota().getText().isEmpty())
            {
                try {
                    stmt = con.createStatement();
                    String sql = "INSERT INTO "
                            + "t_user (us_nama, us_status) "
                            + "VALUES ('" + ta.getTxNamaAnggota().getText() + "', "
                            + "'Anggota')";
                    stmt.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null, "Akun berhasil dibuat!");

                    ta.getTxNamaAnggota().setText("");
                    } catch (SQLException ex) {
                        System.out.println("Error " + ex);
                }
            }
            else    
            {
                JOptionPane.showMessageDialog(null, "Isi Nama!");
            }
        }
        
        //Akun Saya -> Logout
        else if(source.equals(mu.getBtnLogout()))
        {
            viewUtama.dispose();
            viewLoginPetugas.setVisible(true);
        }
        
        //View Anggota -> Keluar
        else if(source.equals(viewUtamaAnggota.getBtnKeluar()))
        {
            viewUtamaAnggota.dispose();
            viewLoginPetugas.setVisible(true);
        }
        
        //Tambah Peminjaman -> Browse Anggota
        else if(source.equals(tj.getBtnCariIDAnggota()))
        {
            ba.setVisible(true);
        }
        
        //Tambah Peminjaman -> Browse Proyektor
        else if(source.equals(tj.getCariIDProyektor()))
        {
            bp.setVisible(true);
        }
    }   
}
