/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.DAO.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tauan Rodrigues 247599
 */
public class TratamentoDAO extends DAO{
    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    public static TratamentoDAO getInstance() {
        return (instance==null?(instance = new TratamentoDAO()):instance);
    }

    public Tratamento create(int codAnimal, String dataInicio, String dataFim) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO tratamento (codAnimal, dataInicio, dataFim) VALUES (?,?,?)");
            stmt.setInt(1, codAnimal);
            stmt.setString(2, dataInicio);
            stmt.setString(3, dataFim);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("tratamento","codigo"));
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt("codigo"), rs.getInt("codAnimal"), rs.getString("dataInicio"), rs.getString("dataFim"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamento;
    }

    public List retrieve(String query) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamentos;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM tratamento");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM tratamento WHERE codigo = " + lastId("tratamento","codigo"));
    }

    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM tratamento WHERE codigo = " + id);
        return (tratamentos.isEmpty()?null:tratamentos.get(0));
    }
 
    public List retrieveByAnimal(int codAnimal) {
        return this.retrieve("SELECT * FROM tratamento WHERE codAnimal = " + codAnimal);
    }    
    
    public Tratamento retrieveByInicio(String data) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM tratamento WHERE dataInicio = " + data);
        return (tratamentos.isEmpty()?null:tratamentos.get(0));
    }
    
    public Tratamento retrieveByFim(String data) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM tratamento WHERE dataFim = " + data);
        return (tratamentos.isEmpty()?null:tratamentos.get(0));
    }
        
    public void update(Tratamento tratamento) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE tratamento SET codAnimal=?, dataInicio=?, dataFim=? WHERE id=?");
            stmt.setInt(1, tratamento.getCodAnimal());
            stmt.setString(2, tratamento.getDataInicio());            
            stmt.setString(3, tratamento.getDataFim());
            stmt.setInt(4, tratamento.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void delete(Tratamento tratamento) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE codigo = ?");
            stmt.setInt(1, tratamento.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
