/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesframebarubet;

import Connection.connect;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Fauzan
 */
public class DashboardCustomer extends javax.swing.JFrame {

    public DashboardCustomer() {
        initComponents();
        ArrayList<List> list = new ArrayList<>();
        ArrayList<List> listDone = new ArrayList<>();
        ArrayList<List> tiangList = new ArrayList<>();
        //In Progress
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("select ID_Customer, Kode_Tiang, Nama, Alamat	,Laporan from customer, receivereport",
                  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery("select * from customer join receivereport on customer.ID_Customer=receivereport.ID_Customer");
            rs.last();
            String [] namaCust = new String[rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            
            while (rs.next()){
                List cust = new List();
                namaCust[i] = rs.getString(3);
                cust.add(rs.getString(3));
                cust.add(rs.getString(4));
                cust.add(rs.getString(2));
                cust.add(rs.getString(8));
                list.add(cust);
                i++;
            }
            stmt.close();
            con.close();
            inProgress.setListData(namaCust);
            
        }catch(Exception e_1301194103){
            e_1301194103.printStackTrace();
        }
        inProgress.addListSelectionListener(((ListSelectionEvent e) -> {
            labelNama.setText(list.get(inProgress.getSelectedIndex()).getItem(0));
            labelAlamat.setText(list.get(inProgress.getSelectedIndex()).getItem(1));
            labelKode.setText(list.get(inProgress.getSelectedIndex()).getItem(2));
            labelLaporan.setText(list.get(inProgress.getSelectedIndex()).getItem(3));
        }));
        
        //Selesai
        try{
            Connection con = (Connection)connect.configDB();
            PreparedStatement stmt = con.prepareStatement("SELECT c.nama, c.alamat, c.Kode_Tiang, rr.Laporan FROM returnreport AS rt INNER JOIN receivereport AS rr on rr.ID_ReceiveReport = rt.IDLaporan INNER JOIN customer AS c on c.ID_Customer = rr.ID_Customer",
                  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery("SELECT c.nama, c.alamat, c.Kode_Tiang, rt.Status_Laporan FROM returnreport AS rt "
                    + "INNER JOIN customer AS c on c.ID_Customer = rt.ID_Customer");
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
                listDone.add(cust);
                i++;
            }
            stmt.close();
            con.close();
            listSelesai.setListData(namaCust);
            
        }catch(Exception e_1301194103){
            e_1301194103.printStackTrace();
        }
        listSelesai.addListSelectionListener(((ListSelectionEvent e) -> {
            labelNama.setText(listDone.get(listSelesai.getSelectedIndex()).getItem(0));
            labelAlamat.setText(listDone.get(listSelesai.getSelectedIndex()).getItem(1));
            labelKode.setText(listDone.get(listSelesai.getSelectedIndex()).getItem(2));
            labelLaporan.setText(listDone.get(listSelesai.getSelectedIndex()).getItem(3));
        }));
        
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
            txtISP.setText(tiangList.get(listTiang.getSelectedIndex()).getItem(2));
            txtStatus.setText(tiangList.get(listTiang.getSelectedIndex()).getItem(3));
        }));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inProgress = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSelesai = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelKode = new javax.swing.JLabel();
        labelLaporan = new javax.swing.JLabel();
        labelAlamat = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtKodeTiang = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtAlamatTiang = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtISP = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listTiang = new javax.swing.JList<>();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Komplain BTS");

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel4.setText("Alamat");

        jLabel5.setText(".");

        jLabel6.setText("Laporan");

        jScrollPane1.setViewportView(inProgress);

        jLabel8.setText("In Progress");

        jScrollPane2.setViewportView(listSelesai);

        jLabel9.setText("Selesai");

        jLabel10.setText("Kode Tiang");

        labelKode.setText(".");

        labelLaporan.setText(".");

        labelAlamat.setText(".");

        labelNama.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel5)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAlamat)
                            .addComponent(labelLaporan)
                            .addComponent(labelKode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jButton2)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(labelNama)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNama)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(labelAlamat))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(labelKode))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelLaporan))
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Komplain", jPanel1);

        jLabel26.setText("Kode Tiang");

        txtKodeTiang.setText(".");

        jLabel27.setText("Alamat Tiang");

        txtAlamatTiang.setText(".");

        jLabel28.setText("Nama ISP");

        txtISP.setText(".");

        jLabel29.setText("Status");

        txtStatus.setText(".");

        listTiang.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listTiang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus)
                    .addComponent(txtISP)
                    .addComponent(txtAlamatTiang)
                    .addComponent(txtKodeTiang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtKodeTiang))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtAlamatTiang))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtISP))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtStatus)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tiang", jPanel2);

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
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    new formKomplain().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    new LoginPage().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> inProgress;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelKode;
    private javax.swing.JLabel labelLaporan;
    private javax.swing.JLabel labelNama;
    private javax.swing.JList<String> listSelesai;
    private javax.swing.JList<String> listTiang;
    private javax.swing.JLabel txtAlamatTiang;
    private javax.swing.JLabel txtISP;
    private javax.swing.JLabel txtKodeTiang;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
}
