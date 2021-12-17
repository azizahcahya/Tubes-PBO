package tubes.pbo;
import java.time.LocalDate;
        
/**
 *
 * @author SMK GOWA RAYA
 */
public class Penjadwalan {
    private String No_Penjadwalan;
    private PekerjaLapangan PL;
    private LocalDate Tanggal_Maintenance;
    private returnReport hasilLaporan;
    
    public Penjadwalan(String No_Penjadwalan, String No_Identitas, LocalDate Tanggal_Maintenance, String nama, String DeskripsiTugas){
        PL = new PekerjaLapangan(No_Identitas, nama, DeskripsiTugas);
        setNoPenjadwalan(No_Penjadwalan);
        setTanggalMaintenance(Tanggal_Maintenance);
        
    }
    public void setNoPenjadwalan(String No_Penjadwalan){
        this.No_Penjadwalan = No_Penjadwalan;
    }
    public void setTanggalMaintenance(LocalDate Tanggal_Maintenance){
        this.Tanggal_Maintenance = Tanggal_Maintenance;
    }
    public String getNoPenjadwalan(){
        return No_Penjadwalan;
    }
    public LocalDate getTanggalMaintenance(){
        return Tanggal_Maintenance;
    }
    public String getPekerjaLapangan(PekerjaLapangan P){
        return P.getNo_Identitas();
    }
    public void setHasilLaporan(String hasilLaporan){
        this.hasilLaporan.setDeskripsi(hasilLaporan);
    }
}
