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
public class ExameDAO extends DAO{
    private static ExameDAO instance;

    private ExameDAO() {
        getConnection();
        createTable();
    }

    public static ExameDAO getInstance() {
        return (instance==null?(instance = new ExameDAO()):instance);
    }

    public Exame create(String nome, int codConsulta, String descricao, String resultado) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO exame (nome, codConsulta, descricao, resultado) VALUES (?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setInt(2, codConsulta);
            stmt.setString(3, descricao);
            stmt.setString(4, resultado);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("exame","codigo"));
    }

    private Exame buildObject(ResultSet rs) {
        Exame exame = null;
        try {
            exame = new Exame(rs.getInt("codigo"), rs.getString("nome"), rs.getInt("codConsulta"), rs.getString("decricao"), rs.getString("resultado"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exame;
    }

    public List retrieve(String query) {
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                exames.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exames;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM exame");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM exame WHERE codigo = " + lastId("exame","codigo"));
    }

    public Exame retrieveById(int id) {
        List<Exame> exames = this.retrieve("SELECT * FROM exame WHERE codigo = " + id);
        return (exames.isEmpty()?null:exames.get(0));
    }
    
    public List retrieveByConsulta(int codConsulta) {
        return this.retrieve("SELECT * FROM exame WHERE codConsulta = " + codConsulta);
    }
 
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM exame WHERE nome LIKE '%" + nome + "%'");
    }    
        
    public void update(Exame exame) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE exame SET nome=?, codConsulta=?, descricao=?, resultado=? WHERE id=?");
            stmt.setString(1, exame.getNome());
            stmt.setInt(2, exame.getCodConsulta());            
            stmt.setString(3, exame.getDescricao());
            stmt.setString(4, exame.getResultado());
            stmt.setInt(5, exame.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void delete(Exame exame) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM exame WHERE codigo = ?");
            stmt.setInt(1, exame.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
