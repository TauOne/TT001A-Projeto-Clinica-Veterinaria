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
    private int idAnimal;
    private int idVeterinario;
    private int idTratamento;

    public Consulta(Date dataConsulta, String sintomas, String historico, int idAnimal, int idVeterinario, int idTratamento) {
        this.dataConsulta = dataConsulta;
        this.sintomas = sintomas;
        this.historico = historico;
        this.idAnimal = idAnimal;
        this.idVeterinario = idVeterinario;
        this.idTratamento = idTratamento;
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

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }
    
}
