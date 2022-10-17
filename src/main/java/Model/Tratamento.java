/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tauan Rodrigues 247599
 */
public class Tratamento {
    private int codigo;
    private int codAnimal;
    private String dataInicio;
    private String dataFim;

    public Tratamento(int codigo, int codAnimal, String dataInicio, String dataFim) {
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInico(String dataInico) {
        this.dataInicio = dataInico;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

}
