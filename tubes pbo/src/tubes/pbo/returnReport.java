package tubes.pbo;

import java.time.LocalDate;

/**
 *
 * @author SMK GOWA RAYA
 */
class returnReport {
    private String IDLaporan;
    private Penjadwalan Schedule;
    private String Deskripsi_Laporan;
    private Boolean Status_Laporan;
    private LocalDate FinishMaintenance;
    
    public void setIDLaporan(String IDLaporan){
        this.IDLaporan = IDLaporan;
    }
    public void setDeskripsi(String Deskripsi_Laporan){
        this.Deskripsi_Laporan = Deskripsi_Laporan;
    }
    public void setStatusLaporan(Boolean Status_Laporan){
        this.Status_Laporan = Status_Laporan;
    }
    public void setFinishMaintenance(LocalDate FinishMaintenance){
        this.FinishMaintenance = FinishMaintenance;
    }
    public String getIDLaporan(){
        return IDLaporan;
    }
    public String getDeskripsi(){
        return Deskripsi_Laporan;
    }
    public Boolean getStatusLaporan(){
        return Status_Laporan;
    }
    public Penjadwalan getSchedule(){
        return Schedule;
    }
    public LocalDate getFinishMaintnenance(){
        return FinishMaintenance;
    }
}
