/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ingarukal11
 */
public class GestionLibro {
    
    public static Connection getConexion() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/struts_el2";
            String user = "root";
            String password = "mysql";
            
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet listarLibros() throws SQLException, Exception{
        ResultSet rs = null;
        try{
            String sql = "call ListarLibros()";
            CallableStatement cs = getConexion().prepareCall(sql);
            rs = cs.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(getConexion() != null){
                getConexion().close();
            }
        }
    }
    
    public ResultSet buscarLibro(String id) throws SQLException, Exception{
        ResultSet rs = null;
        try{
            String sql = "call BuscarLibro(?)";
            CallableStatement cs = getConexion().prepareCall(sql);
            cs.setString(1, id);
            rs = cs.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(getConexion() != null){
                getConexion().close();
            }
        }
    }
    
    public int insertarLibro(String idLibro, String titulo, double precio, int cantidad, String origen, int idTema) throws Exception{
        int i = 0;
        try{
            String sql = "call InsertarLibro(?, ?, ?, ?, ?, ?)";
            CallableStatement cs = getConexion().prepareCall(sql);
            cs.setString(1, idLibro);
            cs.setString(2, titulo);
            cs.setDouble(3, precio);
            cs.setInt(4, cantidad);
            cs.setString(5, origen);
            cs.setInt(6, idTema);
            i = cs.executeUpdate();
            return i;
        }
        catch(Exception e){
            e.printStackTrace();
            return i;
        }finally{
            if(getConexion() != null){
                getConexion().close();
            }
        }
    }
    
}
