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
    private int codAnimal;
    private Date dataInico;
    private Date dataFim;

    public Tratamento(int codigo, int codAnimal, Date dataInico, Date dataFim) {
        this.codigo = codigo;
        this.codAnimal = codAnimal;
        this.dataInico = dataInico;
        this.dataFim = dataFim;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public int getIdAnimal() {
        return codAnimal;
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

}
