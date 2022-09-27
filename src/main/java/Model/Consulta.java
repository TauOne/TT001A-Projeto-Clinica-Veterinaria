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
public class Consulta {
    private Date dataConsulta;
    private String sintomas;
    private String historico;

    public Consulta(Date dataCons, String sintomas, String historico) {
        this.dataConsulta = dataCons;
        this.sintomas = sintomas;
        this.historico = historico;
    }

    public Date getDataCons() {
        return dataConsulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getHistorico() {
        return historico;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
    
    
}
