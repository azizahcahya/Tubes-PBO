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
public class Tiang {
    private String Kode_tiang ;
    private String Alamat_Tiang;
    private String Nama_ISP;
    private String Status;

    public void setKode_tiang(String Kode_tiang) {
        this.Kode_tiang = Kode_tiang;
    }

    public void setAlamat_Tiang(String Alamat_Tiang) {
        this.Alamat_Tiang = Alamat_Tiang;
    }

    public void setNama_ISP(String Nama_ISP) {
        this.Nama_ISP = Nama_ISP;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getKode_tiang() {
        return Kode_tiang;
    }

    public String getAlamat_Tiang() {
        return Alamat_Tiang;
    }

    public String getNama_ISP() {
        return Nama_ISP;
    }

    public String getStatus() {
        return Status;
    }
}
