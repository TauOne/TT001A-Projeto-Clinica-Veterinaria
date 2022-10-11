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
public class Animal {
    private int codigo;
    private int codEspecie;
    private String nome;
    private Date nascimento;
    private char sexo;

    public Animal(int codigo, int codEspecie, String nome, Date nascimento, char sexo) {
        this.codigo = codigo;
        this.codEspecie = codEspecie;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodEspecie() {
        return codEspecie;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }  
}
