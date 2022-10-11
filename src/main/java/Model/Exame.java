/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author saina
 */
public class Exame {
    private int codigo;
    private int codConsulta;
    private String descricao;
    private String resultado;

    public Exame(int codigo, int codConsulta, String descricao, String resultado) {
        this.codigo = codigo;
        this.codConsulta = codConsulta;
        this.descricao = descricao;
        this.resultado = resultado;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodConsulta() {
        return codConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
