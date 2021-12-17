package tubes.pbo;

/**
 *
 * @author Asus
 */
public class Customer {
    private String ID_Customer;
    private String Nama;
    private String Alamat;
    private receiveReport laporan;
    private returnReport Hasil;
    private Tiang T;

    public Customer(String ID_Customer, String Nama, String Kode_Tiang) {
        T = new Tiang(Kode_Tiang);
        this.ID_Customer = ID_Customer;
        this.Nama = Nama;
        
    }

    public String getID_Customer() {
        return ID_Customer;
    }

    public void setID_Customer(String ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public void setLaporan(String laporan) {
        this.laporan.setIsiLaporan(laporan); 
    }
    public receiveReport getLaporan() {
        return this.laporan; 
    }

    public boolean getHasil() {
        return Hasil.getStatusLaporan();
    }
    
    
}
