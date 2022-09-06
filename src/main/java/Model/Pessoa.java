/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author saina
 */
public class Pessoa {
    private int codPessoa;
    private String nomePessoa;
    private String endPessoa;
    private String telPessoa;

    public Pessoa(int codPessoa, String nomePessoa, String endPessoa, String telPessoa) {
        this.codPessoa = codPessoa;
        this.nomePessoa = nomePessoa;
        this.endPessoa = endPessoa;
        this.telPessoa = telPessoa;
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getEndPessoa() {
        return endPessoa;
    }

    public String getTelPessoa() {
        return telPessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setEndPessoa(String endPessoa) {
        this.endPessoa = endPessoa;
    }

    public void setTelPessoa(String telPessoa) {
        this.telPessoa = telPessoa;
    }
    
    
}
