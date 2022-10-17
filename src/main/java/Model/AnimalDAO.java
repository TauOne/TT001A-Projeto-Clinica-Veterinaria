/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.DAO.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tauan Rodrigues 247599
 */
public class AnimalDAO extends DAO {
        private static AnimalDAO instance;

    private AnimalDAO() {
        getConnection();
        createTable();
    }

    public static AnimalDAO getInstance() {
        return (instance==null?(instance = new AnimalDAO()):instance);
    }

    public Animal create(String nome, String nascimento, char sexo, int codEspecie, int codCliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (nome, nascimento, sexo, codEspecie, codCliente) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, nascimento);
            stmt.setString(3, Character.toString(sexo));
            stmt.setInt(4, codEspecie);
            stmt.setInt(5, codCliente);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("animal","codigo"));
    }

    private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("codigo"), rs.getString("nome"), Instant.parse(rs.getString("nascimento")), rs.getString("sexo").charAt(0), rs.getInt("codEspecie"), rs.getInt("codCliente"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }

    public List retrieve(String query) {
        List<Animal> animal = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animal.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM animal");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM animal WHERE codigo = " + lastId("animal","codigo"));
    }

    public Animal retrieveById(int id) {
        List<Animal> animais = this.retrieve("SELECT * FROM animais WHERE codigo = " + id);
        return (animais.isEmpty()?null:animais.get(0));
    }
    public List retrieveByClientId(int id) {
        return this.retrieve("SELECT * FROM animais WHERE codCliente = " + id);
    }
 
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM animal WHERE nome LIKE '%" + nome + "%'");
    }    
        
    public void update(Animal animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET nome=?, nascimento=?, sexo=?, codEspecie=?, codCliente=? WHERE codigo=?");
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getNascimento().toString());            
            stmt.setString(3, Character.toString(animal.getSexo()));
            stmt.setInt(4, animal.getCodEspecie());
            stmt.setInt(5, animal.getCodCliente());
            stmt.setInt(6, animal.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void delete(Animal animal) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE codigo = ?");
            stmt.setInt(1, animal.getCodigo());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
