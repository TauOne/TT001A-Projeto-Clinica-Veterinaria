/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author saina
 */
public class Tratamento {
    private int codTrat;
    private Date dataIni;
    private Date dataFim;

    public Tratamento(int codTrat, Date dataIni, Date dataFim) {
        this.codTrat = codTrat;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
    }

    public int getCodTrat() {
        return codTrat;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    
}
