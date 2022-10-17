/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.Instant;


/**
 *
 * @author Tauan Rodrigues 247599
 */
public class Tratamento {
    private int codigo;
    private int codAnimal;
    private Instant dataInicio;
    private Instant dataFim;

    public Tratamento(int codigo, int codAnimal, Instant dataInicio, Instant dataFim) {
        this.codigo = codigo;
        this.codAnimal = codAnimal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public int getCodAnimal() {
        return codAnimal;
    }

    public Instant getDataInicio() {
        return dataInicio;
    }

    public void setDataInico(Instant dataInico) {
        this.dataInicio = dataInico;
    }

    public Instant getDataFim() {
        return dataFim;
    }

    public void setDataFim(Instant dataFim) {
        this.dataFim = dataFim;
    }

}
