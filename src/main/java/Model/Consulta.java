/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tauan Rodrigues 247599
 */
public class Consulta {
    private int codigo;
    private String data;
    private String sintomas;
    private String historico;
    private int codAnimal;
    private int codVeterinario;
    private int codTratamento;

    public Consulta(int codigo, String data, String sintomas, String historico, int idAnimal, int idVeterinario, int idTratamento) {
        this.codigo = codigo;
        this.data = data;
        this.sintomas = sintomas;
        this.historico = historico;
        this.codAnimal = idAnimal;
        this.codVeterinario = idVeterinario;
        this.codTratamento = idTratamento;
    }

    public String getData() {
        return data;
    }
    
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public int getCodVeterinario() {
        return codVeterinario;
    }

    public int getCodTratamento() {
        return codTratamento;
    }

    public int getCodigo() {
        return codigo;
    }
}
