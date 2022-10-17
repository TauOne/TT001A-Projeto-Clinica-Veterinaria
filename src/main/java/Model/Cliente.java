/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author saina
 */
public class Cliente extends Pessoa{
    private String cep;
    private String email;

    public Cliente(int codigo, String nome, String endereco, String telefone, String cep, String email) {
        super(codigo, nome, endereco, telefone);
        this.cep = cep;
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /*@Override
    public String toString(){
        String desc = "Cliente(nome=" + nome + ", endereço=" + ", telefone=" + telefone + ", CEP=" + cep + ", email=" + email + ")";
        return desc + "\n";
    }*/
}
