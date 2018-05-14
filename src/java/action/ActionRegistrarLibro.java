/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.GestionLibro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ingarukal11
 */
public class ActionRegistrarLibro extends ActionSupport{
    
    private String idLibro;
    private String titulo;
    private double precio;
    private int cantidad;
    private String origen;
    private int idTema;
    
    private String mensaje = "";
    private int ctr = 0;
    
    GestionLibro gl = new GestionLibro();
    
    public String execute() throws Exception{
        try{
            ctr = gl.insertarLibro(idLibro, titulo, precio, cantidad, origen, idTema);
            if(ctr > 0){
                mensaje = "Registro Exitoso!";
            }else{
                mensaje = "El ID Libro ya se encuentra registrado";
            }
        }catch(Exception e){
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
     * @return the idTema
     */
    public int getIdTema() {
        return idTema;
    }

    /**
     * @param idTema the idTema to set
     */
    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
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
        
        if(titulo == null || titulo.trim().equals("")){
            addFieldError("titulo", "Se debe ingresar un título");
        }else{
            if(titulo.length() < 3 || titulo.length() > 30){
                addFieldError("titulo", "El título debe contener de 3 a 30 caracteres");
            }
        }
        
        if(precio == 0.0){
            addFieldError("precio", "Se debe ingresar un precio mayor a 0.0");
        }else{
            Pattern patronIdLibro = Pattern.compile("[0-9]{2,3}[.][0-9]{1,2}");
            Matcher matchIdLibro = patronIdLibro.matcher(precio + "");
            if(!matchIdLibro.matches()){
                addFieldError("precio", "Formato incorrecto. Ejem. S/ 50.00");
            }
        }
        
        if(origen == null || origen.trim().equals("")){
            addFieldError("origen", "Se debe ingresar el origen del libro");
        }else{
            if(origen.length() < 3 || origen.length() > 30){
                addFieldError("origen", "El origen debe contener de 3 a 30 caracteres");
            }
        }
        
        if(cantidad == 0){
            addFieldError("cantidad", "Se debe ingresar una cantidad mayor a 0");
        }else{
            Pattern patronIdLibro = Pattern.compile("[0-9]{2,3}");
            Matcher matchIdLibro = patronIdLibro.matcher(cantidad + "");
            if(!matchIdLibro.matches()){
                addFieldError("cantidad", "Para la cantidad solo se aceptan unidades enteras");
            }
        }
        
        if(idTema == -1){
            addFieldError("idTema", "Se debe seleccionar un tema");
        }
    }
    
}
