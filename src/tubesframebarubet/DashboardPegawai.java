package tubesframebarubet;

import Connection.connect;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fauzan
 */
public class DashboardPegawai extends javax.swing.JFrame {
    public int getID(){
        return Integer.parseInt(idRR.getText());
    }
    public DashboardPegawai() {
        initComponents();
        ArrayList<List> tiangList = new ArrayList<>();
        ArrayList<List> adminList = new ArrayList<>();
        ArrayList<List> plList = new ArrayList<>();
        ArrayList<List> inProg = new ArrayList<>();
        ArrayList<List> done = new ArrayList<>();
        
        
        //TIANG
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("select * from tiang");
            
            ResultSet rs = stmt.executeQuery("select * from tiang");
            rs.last();
            String [] namaCust = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            
            while (rs.next()){
                List cust = new List();
                namaCust[i] = rs.getString(1);
                cust.add(rs.getString(1));
                cust.add(rs.getString(2));
                cust.add(rs.getString(3));
                cust.add(rs.getString(4));
                tiangList.add(cust);
                i++;
            }
            stmt.close();
            con.close();
            listTiang.setListData(namaCust);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        listTiang.addListSelectionListener(((ListSelectionEvent e) -> {
            txtKodeTiang.setText(tiangList.get(listTiang.getSelectedIndex()).getItem(0));
            txtAlamatTiang.setText(tiangList.get(listTiang.getSelectedIndex()).getItem(1));
            txtNamaISP.setText(tiangList.get(listTiang.getSelectedIndex()).getItem(2));
            txtStatus.setText(tiangList.get(listTiang.getSelectedIndex()).getItem(3));
        }));
        //ADMIN
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("select * from admin");
            
            ResultSet rs = stmt.executeQuery("select * from admin");
            rs.last();
            String [] namaAdmin = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            
            while (rs.next()){
                List adm = new List();
                namaAdmin[i] = rs.getString(2);
                adm.add(rs.getString(2));
                adm.add(rs.getString(1));
                adm.add(rs.getString(3));
                adminList.add(adm);
                i++;
            }
            stmt.close();
            con.close();
            listAdmin.setListData(namaAdmin);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        listAdmin.addListSelectionListener(((ListSelectionEvent e) -> {
            nama.setText(adminList.get(listAdmin.getSelectedIndex()).getItem(0));
            noID.setText(adminList.get(listAdmin.getSelectedIndex()).getItem(1));
            salary.setText(adminList.get(listAdmin.getSelectedIndex()).getItem(2));
            posisi.setText("Admin");
            
        }));
        
        //PEKERJA LAPANGAN
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("select * from pekerjalapangan");
            
            ResultSet rs = stmt.executeQuery("select * from pekerjalapangan");
            rs.last();
            String [] namaPL = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            
            while (rs.next()){
                List pl = new List();
                namaPL[i] = rs.getString(2);
                pl.add(rs.getString(2));
                pl.add(rs.getString(1));
                pl.add(rs.getString(3));
                plList.add(pl);
                i++;
            }
            stmt.close();
            con.close();
            listPekerja.setListData(namaPL);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        listPekerja.addListSelectionListener(((ListSelectionEvent e) -> {
            nama.setText(plList.get(listPekerja.getSelectedIndex()).getItem(0));
            noID.setText(plList.get(listPekerja.getSelectedIndex()).getItem(1));
            salary.setText(plList.get(listPekerja.getSelectedIndex()).getItem(2));
            posisi.setText("Pekerja Lapangan");
            
        }));
        
        //PENJADWALAN - INPROGRESS
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("SELECT pj.No_IdentitasPL ,pj.IDReceiveReport , pl.nama , pj.Tgl_Maintenance , t.Status FROM penjadwalan AS pj INNER JOIN pekerjalapangan AS pl on pj.No_IdentitasPL = pl.No_IdentitasPL INNER JOIN receivereport AS rr on pj.IDReceiveReport = rr.ID_ReceiveReport INNER JOIN Tiang AS t on rr.Kode_Tiang = t.Kode_Tiang");
            ResultSet rs = stmt.executeQuery("SELECT pj.No_IdentitasPL ,pj.IDReceiveReport , pl.nama , pj.Tgl_Maintenance , "
                    + "t.Status FROM penjadwalan AS pj INNER JOIN pekerjalapangan AS pl on pj.No_IdentitasPL = pl.No_IdentitasPL "
                    + "INNER JOIN receivereport AS rr on pj.IDReceiveReport = rr.ID_ReceiveReport INNER JOIN Tiang AS t on rr.Kode_Tiang = t.Kode_Tiang");
            rs.last();
            String [] idReceive = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            
            while (rs.next()){
                List prog = new List();
                idReceive[i] = rs.getString(2);
                prog.add(rs.getString(2));
                prog.add(rs.getString(3));
                prog.add(rs.getString(4));
                prog.add(rs.getString(5));
                inProg.add(prog);
                i++;
            }
            stmt.close();
            con.close();
            inProgressList.setListData(idReceive);
        }catch(Exception e){
            e.printStackTrace();
        }            

        inProgressList.addListSelectionListener(((ListSelectionEvent e) -> {
            idRR.setText(inProg.get(inProgressList.getSelectedIndex()).getItem(0));
            txtPL.setText(inProg.get(inProgressList.getSelectedIndex()).getItem(1));
            tgl.setText(inProg.get(inProgressList.getSelectedIndex()).getItem(2));
            diperbaiki.setText(inProg.get(inProgressList.getSelectedIndex()).getItem(3));
            
        }));
        
        //PENJADWALAN - SELESAI
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("SELECT rt.IDLaporan" +
                            ", pl.nama" +
                            ", rt.Tgl_Maintenance" +
                            ", t.Status " +
                            "FROM returnreport AS rt " +
                            "INNER JOIN pekerjalapangan AS pl " +
                            "on pl.No_IdentitasPL = rt.No_IdentitasPL " +
                            "INNER JOIN receivereport AS rr " +
                            "on rt.IDLaporan = rr.ID_ReceiveReport " +
                            "INNER JOIN Tiang AS t " +
                            "on rr.Kode_Tiang=t.Kode_Tiang",
                  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery("SELECT rt.IDLaporan" +
                            ", pl.nama" +
                            ", rt.Tgl_Maintenance" +
                            ", t.Status " +
                            "FROM returnreport AS rt " +
                            "INNER JOIN pekerjalapangan AS pl " +
                            "on pl.No_IdentitasPL = rt.No_IdentitasPL " +
                            "INNER JOIN customer AS c " +
                            "on rt.ID_Customer = c.ID_Customer " +
                            "INNER JOIN Tiang AS t " +
                            "on c.Kode_Tiang=t.Kode_Tiang");
            rs.last();
            String [] namaCust = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            
            while (rs.next()){
                List cust = new List();
                namaCust[i] = rs.getString(1);
                cust.add(rs.getString(1));
                cust.add(rs.getString(2));
                cust.add(rs.getString(3));
                cust.add(rs.getString(4));
                done.add(cust);
                i++;
            }
            stmt.close();
            con.close();
            selesai.setListData(namaCust);
            
        }catch(Exception e_1301194103){
            e_1301194103.printStackTrace();
        }
        selesai.addListSelectionListener(((ListSelectionEvent e) -> {
            idRR.setText(done.get(selesai.getSelectedIndex()).getItem(0));
            txtPL.setText(done.get(selesai.getSelectedIndex()).getItem(1));
            tgl.setText(done.get(selesai.getSelectedIndex()).getItem(2));
            diperbaiki.setText(done.get(selesai.getSelectedIndex()).getItem(3));
        }));
    }
    FormSetPenjadwalan setP = new FormSetPenjadwalan();
    formPerbaikan fixed = new formPerbaikan();
    FormUbahPegawai ubah =  new FormUbahPegawai(); 
    FormUbahTiang ubahTiang=  new FormUbahTiang(); 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idRR = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        setPenjadwalan = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        inProgressList = new javax.swing.JList<>();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        selesai = new javax.swing.JList<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        diperbaiki = new javax.swing.JLabel();
        setPerbaikan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listTiang = new javax.swing.JList<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtKodeTiang = new javax.swing.JLabel();
        txtAlamatTiang = new javax.swing.JLabel();
        txtNamaISP = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        butUbah = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listAdmin = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listPekerja = new javax.swing.JList<>();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        noID = new javax.swing.JLabel();
        posisi = new javax.swing.JLabel();
        salary = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel7.setText("IdReceiveReport");

        jLabel8.setText("Pekerja Lapangan");

        jLabel9.setText("Tanggal Maintenance");

        jLabel10.setText("Sudah diperbaiki");

        jLabel11.setText(".");

        jLabel12.setText(".");

        jLabel13.setText(".");

        jLabel14.setText(".");

        jButton3.setText("Set Perbaikan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList8);

        jList9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(jList9);

        jLabel36.setText("In Progress");

        jLabel37.setText("Selesai");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37)
                                .addGap(29, 29, 29)))
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(19, 19, 19))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("IdReceiveReport");

        idRR.setText(".");

        jLabel3.setText("Pekerja Lapangan");

        txtPL.setText(".");

        jLabel5.setText("Tanggal Maintenance");

        tgl.setText(".");

        setPenjadwalan.setText("Set Penjadwalan");
        setPenjadwalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPenjadwalanActionPerformed(evt);
            }
        });

        inProgressList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(inProgressList);

        jLabel34.setText("In Progress");

        selesai.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(selesai);

        jLabel35.setText("Selesai");

        jLabel38.setText("Sudah diperbaiki");

        diperbaiki.setText(".");

        setPerbaikan.setText("Set Perbaikan");
        setPerbaikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPerbaikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel38)
                    .addComponent(setPenjadwalan))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setPerbaikan)
                    .addComponent(diperbaiki)
                    .addComponent(tgl)
                    .addComponent(txtPL)
                    .addComponent(idRR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel35)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idRR))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPL))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tgl))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(diperbaiki))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setPenjadwalan)
                            .addComponent(setPerbaikan))))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Set Penjadwalan", jPanel1);

        listTiang.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listTiang);

        jLabel26.setText("Kode Tiang");

        jLabel27.setText("Alamat Tiang");

        jLabel28.setText("Nama ISP");

        jLabel29.setText("Status");

        txtKodeTiang.setText(".");

        txtAlamatTiang.setText(".");

        txtNamaISP.setText(".");

        txtStatus.setText(".");

        jButton7.setText("Tambah");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        butUbah.setText("Ubah");
        butUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUbahActionPerformed(evt);
            }
        });

        jButton9.setText("Hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus)
                            .addComponent(txtNamaISP)
                            .addComponent(txtAlamatTiang)
                            .addComponent(txtKodeTiang)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(20, 20, 20)
                        .addComponent(butUbah)
                        .addGap(20, 20, 20)
                        .addComponent(jButton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtKodeTiang))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtAlamatTiang))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtNamaISP))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtStatus))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(butUbah)
                            .addComponent(jButton9)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Tiang", jPanel4);

        listAdmin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listAdmin);

        jLabel15.setText("Daftar Pegawai");

        jLabel16.setText("Pekerja Lapangan");

        listPekerja.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listPekerja);

        jLabel17.setText("Admin");

        jButton4.setText("Tambah");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel18.setText("Nama");

        jLabel19.setText("No Identitas");

        jLabel20.setText("Posisi");

        jLabel21.setText("Salary");

        nama.setText(".");

        noID.setText(".");

        posisi.setText(".");

        salary.setText(".");

        jButton5.setText("Ubah");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Hapus");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noID)
                            .addComponent(nama)
                            .addComponent(jButton4)
                            .addComponent(posisi)
                            .addComponent(salary)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(69, 69, 69)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(0, 73, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel15))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(nama))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(noID))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(posisi))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(salary))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Pegawai", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    new LoginPage().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//        new HapusPegawai().setVisible(true);
//        this.dispose();
        try {
            Connection con = (Connection)connect.configDB();
            String Posisi = posisi.getText();
            String sql;
            if (Posisi == "Admin"){
                 sql = "DELETE FROM admin  WHERE No_IdentitasA = '" + noID.getText()+"'";
            }else{
                 sql = "DELETE FROM pekerjalapangan  WHERE No_IdentitasPL = '" + noID.getText()+"'";
            }
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Terhapus");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String Nama = nama.getText();
        String id = noID.getText();
        
        String gaji = salary.getText();
        ubah.setVisible(true);
        ubah.pack();
        ubah.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ubah.txtNama.setText(Nama);
        ubah.txtID.setText(id);
        ubah.txtSalary.setText(gaji);
        if (posisi.getText()=="Admin"){
            ubah.butAdmin.setSelected(true);
        } else{
            ubah.butPekerja.setSelected(true);
        }
        
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new formTambahPegawai().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void butUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUbahActionPerformed
        String KodeTiang = txtKodeTiang.getText();
        String AlamatTiang = txtAlamatTiang.getText();
        String NamaISP = txtNamaISP.getText();
        String Status = txtStatus.getText();
        
        ubahTiang.setVisible(true);
        ubahTiang.pack();
        ubahTiang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ubahTiang.kode.setText(KodeTiang);
        ubahTiang.alamat.setText(AlamatTiang);
        ubahTiang.isp.setText(NamaISP);
        ubahTiang.status.setText(Status);
        
       
        this.dispose();
//        new FormUbahTiang().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_butUbahActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new FormTambahTiang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void setPenjadwalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPenjadwalanActionPerformed
//        String id = idRR.getText();
//        setP.setVisible(true);
//        setP.pack();
//        setP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        
//        setP.idReceiveReport.setText(id);
        new FormSetPenjadwalan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_setPenjadwalanActionPerformed

    private void setPerbaikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPerbaikanActionPerformed
        String id = idRR.getText();
        String pl = txtPL.getText();
        String tanggal = tgl.getText();
        fixed.setVisible(true);
        fixed.pack();
        fixed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        fixed.idReceiveReport.setText(id);
        fixed.namaPL.setText(pl);
        fixed.tglMain.setText(tanggal);
        this.dispose();
    }//GEN-LAST:event_setPerbaikanActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            Connection con = (Connection)connect.configDB();
            String sql = "DELETE FROM tiang  WHERE Kode_Tiang= '" + txtKodeTiang.getText()+"'";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Terhapus");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butUbah;
    private javax.swing.JLabel diperbaiki;
    private javax.swing.JLabel idRR;
    private javax.swing.JList<String> inProgressList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList8;
    private javax.swing.JList<String> jList9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JList<String> listAdmin;
    private javax.swing.JList<String> listPekerja;
    private javax.swing.JList<String> listTiang;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel noID;
    private javax.swing.JLabel posisi;
    private javax.swing.JLabel salary;
    private javax.swing.JList<String> selesai;
    private javax.swing.JButton setPenjadwalan;
    private javax.swing.JButton setPerbaikan;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel txtAlamatTiang;
    private javax.swing.JLabel txtKodeTiang;
    private javax.swing.JLabel txtNamaISP;
    private javax.swing.JLabel txtPL;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
}
