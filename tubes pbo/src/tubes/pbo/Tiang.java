package tubes.pbo;

/**
 *
 * @author Asus
 */
public class Tiang {
    private String Kode_Tiang;
    private String Alamat_Tiang;
    private String Nama_ISP;
    private String Status;
    
    public Tiang(String Kode_Tiang){
        setKode_Tiang(Kode_Tiang);
    }
    public String getKode_Tiang() {
        return Kode_Tiang;
    }

    public void setKode_Tiang(String Kode_Tiang) {
        this.Kode_Tiang = Kode_Tiang;
    }

    public String getAlamat_Tiang() {
        return Alamat_Tiang;
    }

    public void setAlamat_Tiang(String Alamat_Tiang) {
        this.Alamat_Tiang = Alamat_Tiang;
    }

    public String getNama_ISP() {
        return Nama_ISP;
    }

    public void setNama_ISP(String Nama_ISP) {
        this.Nama_ISP = Nama_ISP;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
