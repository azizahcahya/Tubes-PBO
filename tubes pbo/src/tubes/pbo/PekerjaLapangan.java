/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.pbo;

/**
 *
 * @author Asus
 */
public class PekerjaLapangan {
    private String Deskripsi_tugas;
    private Penjadwalan Report;

    public PekerjaLapangan(String Deskripsi_tugas, Penjadwalan Report) {
        this.Deskripsi_tugas = Deskripsi_tugas;
        this.Report = Report;
    }

    public void setDeskripsi_tugas(String Deskripsi_tugas) {
        this.Deskripsi_tugas = Deskripsi_tugas;
    }

    public void setReport(Penjadwalan Report) {
        this.Report = Report;
    }

    public String getDeskripsi_tugas() {
        return Deskripsi_tugas;
    }
    
   @Override
    public double employeeSalary() {
        return 1000000;
    }
    
    public void info(){
//        System.out.println("Nama Pekerja Lapangan          : " + getNama());
        System.out.println("Deskripsi tugas               : " + this.Deskripsi_tugas);
        System.out.println("Report                        : " + this.Report);           
    }
}
