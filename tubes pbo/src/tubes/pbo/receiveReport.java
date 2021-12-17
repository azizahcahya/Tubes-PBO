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
public class receiveReport {
    private String IDreceiveReport;
    private Customer Pelapor;
    private String isiLaporan; 

    public String getIDreceiveReport() {
        return IDreceiveReport;
    }

    public void setIDreceiveReport(String IDreceiveReport) {
        this.IDreceiveReport = IDreceiveReport;
    }

    public String getIsiLaporan() {
        return isiLaporan;
    }

    public void setIsiLaporan(String isiLaporan) {
        this.isiLaporan = isiLaporan;
    }

    public String getPelapor() {
        return Pelapor.getNama();
    }
    
    
}
