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
    private int codigo;
    private int idAnimal;
    private Date dataInico;
    private Date dataFim;

    public Tratamento(int codigo, int idAnimal, Date dataInico, Date dataFim) {
        this.codigo = codigo;
        this.dataInico = dataInico;
        this.dataFim = dataFim;
        this.idAnimal = idAnimal;
    }

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataInico() {
        return dataInico;
    }

    public void setDataInico(Date dataInico) {
        this.dataInico = dataInico;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    private void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    
}
