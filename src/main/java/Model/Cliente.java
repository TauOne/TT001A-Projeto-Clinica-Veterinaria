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
    private String cepCliente;
    private String mailCliente;

    public Cliente(String cepCliente, String mailCliente, int codPessoa, String nomePessoa, String endPessoa, String telPessoa) {
        super(codPessoa, nomePessoa, endPessoa, telPessoa);
        this.cepCliente = cepCliente;
        this.mailCliente = mailCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }
    
    
}
