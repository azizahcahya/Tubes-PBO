/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public abstract class Employee {
    private String No_Identitas;
    private String Nama;

    public Employee(String No_Identitas, String Nama) {
        this.No_Identitas = No_Identitas;
        this.Nama = Nama;
    }

    public String getNo_Identitas() {
        return No_Identitas;
    }

    public void setNo_Identitas(String No_Identitas) {
        this.No_Identitas = No_Identitas;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    
    public void info(){
        
    }
}
