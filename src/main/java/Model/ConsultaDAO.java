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
public class ConsultaDAO extends DAO{
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    public static ConsultaDAO getInstance() {
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }

    public Consulta create(String data, String sintomas, String historico, int codAnimal, int codVeterinario, int codTratamento) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (data, sintomas, historico, codAnimal, codVeterinario, codTratamento) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, data);
            stmt.setString(2, sintomas);
            stmt.setString(3, historico);
            stmt.setInt(4, codAnimal);
            stmt.setInt(5, codVeterinario);
            stmt.setInt(6, codTratamento);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consulta","codigo"));
    }

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            consulta = new Consulta(rs.getInt("codigo"), rs.getString("nascimento"), rs.getString("sintomas"), rs.getString("historico"), rs.getInt("codAnimal"), rs.getInt("codVeterinario"), rs.getInt("codTratamento"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }

    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consulta WHERE codigo = " + lastId("consulta","codigo"));
    }

    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE data = " + id);
        return (consultas.isEmpty()?null:consultas.get(0));
    }
    
    public Consulta retrieveByDate(String date) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE data = " + date);
        return (consultas.isEmpty()?null:consultas.get(0));
    }
 
    public List retrieveByPeriod(String data1, String data2) {
        return this.retrieve("SELECT * FROM consulta WHERE data > " + data1 + " and data < " + data2);
    }    
        
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET data=?, sintomas=?, historico=?, codAnimal=?, codVeterinario=? codTratamento=? WHERE codigo=?");
            stmt.setString(1, consulta.getData());
            stmt.setString(2, consulta.getSintomas());            
            stmt.setString(3, consulta.getHistorico());
            stmt.setInt(4, consulta.getCodAnimal());
            stmt.setInt(5, consulta.getCodVeterinario());
            stmt.setInt(6, consulta.getCodTratamento());
            stmt.setInt(7, consulta.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE codigo = ?");
            stmt.setInt(1, consulta.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
