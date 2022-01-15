package model;

/**
 *
 * @author Asus
 */
public class Admin extends Employee{
    private Penjadwalan jadwal;
    
    public String getReport(Customer C){
        return C.getLaporan().getIsiLaporan();
    }
    public Admin(String NoIdentitas, String nama) {
        super(NoIdentitas, nama);
    }

/*    public void setPenjadwalan(Penjadwalan jadwal) {
        this.jadwal.;
    }
*/
    
    @Override
    public void info(){
        
    }
    
    
}
