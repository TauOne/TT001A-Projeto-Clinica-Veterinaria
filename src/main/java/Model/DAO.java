/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tauan Rodrigues 247599
 */
public abstract class DAO {

    public static final String DBURL = "jdbc:sqlite:ProjClinicVetTT001A2022";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS codigo FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("codigo");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    protected final boolean createTable() {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS cliente( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "endereco VARCHAR, \n"
                    + "telefone VARCHAR, \n"
                    + "cep VARCHAR, \n"
                    + "email VARCHAR); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "codEspecie INTEGER, \n"
                    + "codCliente INTEGER, \n"
                    + "nome VARCHAR, \n"
                    + "nascimento VARCHAR, \n"
                    + "sexo CHAR); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS especie( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS veterinario( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "endereco VARCHAR, \n"
                    + "telefone VARCHAR); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS tratamento( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "codAnimal INTEGER, \n"
                    + "dataInicio VARCHAR, \n"
                    + "dataFim VARCHAR); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS consulta( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "data VARCHAR, \n"
                    + "sintomas TEXT, \n"
                    + "historico TEXT, \n"
                    + "codAnimal INTEGER, \n"
                    + "codVeterinario INTEGER, \n"
                    + "codTratamento INTEGER); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS exame( \n"
                    + "codigo INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "descricao VARCHAR, \n"
                    + "resultado VARCHAR); \n");
            executeUpdate(stmt);
            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO especie (codigo, nome) VALUES (1, 'cachorro')");
            executeUpdate(stmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
