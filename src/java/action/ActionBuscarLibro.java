/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.GestionLibro;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ingarukal11
 */
public class ActionBuscarLibro extends ActionSupport{
    
    private String idLibro;
    private String titulo;
    private double precio;
    private int cantidad;
    private String origen;
    private String tema;
    private boolean noData = false;
        
    ResultSet rs = null;
    GestionLibro gl = new GestionLibro();
    
    public String execute() throws Exception{
        try{
            rs = gl.buscarLibro(idLibro.trim());
            int i = 0;
            if(rs != null){
                while(rs.next()){
                    i++;
                    idLibro = rs.getString("idLibro");
                    titulo = rs.getString("titulo");
                    precio = rs.getDouble("precio");
                    cantidad = rs.getInt("cantidad");
                    origen = rs.getString("origen");
                    tema = rs.getString("nombre");
                }
            }
            if(i == 0){
                noData = false;
            }else{
                noData = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return SUCCESS;
    }

    /**
     * @return the idLibro
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    
    
    @Override
    public void validate(){
        if(idLibro == null || idLibro.trim().equals("")){
            addFieldError("idLibro", "Se debe ingresar un ID Libro");
        }else{
            Pattern patronIdLibro = Pattern.compile("[L][I][B][0-9]{5}");
            Matcher matchIdLibro = patronIdLibro.matcher(idLibro);
            if(!matchIdLibro.matches()){
                addFieldError("idLibro", "Formato incorrecto. Ejem. LIB00001");
            }
        }
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
