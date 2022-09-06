/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author saina
 */
public class Animal {
    private int codAnimal;
    private String nomeAnimal;
    private int idadeAnimal;
    private char sexoAnimal;

    public Animal(int codAnimal, String nomeAnimal, int idadeAnimal, char sexoAnimal) {
        this.codAnimal = codAnimal;
        this.nomeAnimal = nomeAnimal;
        this.idadeAnimal = idadeAnimal;
        this.sexoAnimal = sexoAnimal;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public char getSexoAnimal() {
        return sexoAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public void setSexoAnimal(char sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }
    
    
}
