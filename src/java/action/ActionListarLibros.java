/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.Libro;
import com.opensymphony.xwork2.ActionSupport;
import dao.GestionLibro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingarukal11
 */
public class ActionListarLibros extends ActionSupport{
    
    private List<Libro> lista = null;
    private boolean noData = false;
    
    ResultSet rs = null;
    Libro libro = null;
    GestionLibro gl = new GestionLibro();
    
    public String execute() throws Exception{
        try{
            lista = new ArrayList<Libro>();
            rs = gl.listarLibros();
            int i = 0;
            if(rs != null){
                while(rs.next()){
                    i++;
                    libro = new Libro();
                    libro.setIdLibro(rs.getString("idLibro"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setPrecio(rs.getDouble("precio"));
                    libro.setCantidad((rs.getInt("cantidad")));
                    libro.setOrigen(rs.getString("origen"));
                    libro.setNombreTema(rs.getString("nombre"));
                    
                    lista.add(libro);
                }
            }
            if(i == 0){
                noData = false;
            }
            else{
                noData = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return SUCCESS;
    }

    /**
     * @return the lista
     */
    public List<Libro> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Libro> lista) {
        this.lista = lista;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }
    
    
    
}
