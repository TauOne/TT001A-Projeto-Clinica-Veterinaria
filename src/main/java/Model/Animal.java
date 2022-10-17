/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.Instant;

/**
 *
 * @author Tauan
 */
public class Animal {

    private int codigo;
    private String nome;
    private Instant nascimento;
    private char sexo;
    private int codEspecie;
    private int codCliente;

    public Animal(int codigo, String nome, Instant nascimento, char sexo, int codEspecie, int codCliente) {
        this.codigo = codigo;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.codEspecie = codEspecie;
        this.codCliente = codCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodEspecie() {
        return codEspecie;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getNome() {
        return nome;
    }

    public Instant getNascimento() {
        return nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(Instant nascimento) {
        this.nascimento = nascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
