package model;

/**
 *
 * @author Asus
 */
public class PekerjaLapangan extends Employee{
    private String DeskripsiTugas;
    private Penjadwalan Report;
    
    public PekerjaLapangan(String No_Identitas, String nama, String DeskripsiTugas) {
        super(No_Identitas, nama);
        setDeskripsiTugas(DeskripsiTugas);
    }
    public void setDeskripsiTugas(String DeskripsiTugas){
        this.DeskripsiTugas = DeskripsiTugas;
    }
    
 /*   public void setReport(returnReport Report){
        this.Report.setDeskripsi(Report).setHasilLaporan(Report);
    }*/
    public String getDeskripsiTugas(){
        return DeskripsiTugas;
    }
    @Override
    public void info(){
        
    }
}
