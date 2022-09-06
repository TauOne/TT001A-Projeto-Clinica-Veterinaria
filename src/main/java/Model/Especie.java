/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author saina
 */
public class Especie {
    private int codEspecie;
    private String nomeEspecie;

    public Especie(int codEspecie, String nomeEspecie) {
        this.codEspecie = codEspecie;
        this.nomeEspecie = nomeEspecie;
    }

    public int getCodEspecie() {
        return codEspecie;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }
    
    
}
