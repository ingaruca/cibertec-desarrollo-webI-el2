/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ingarukal11
 */
public class Libro {
    
    private String idLibro;
    private String titulo;
    private double precio;
    private int cantidad;    
    private String origen;
    
    private int idTema;    
    private String nombreTema;
    
    public Libro(){
        
    }
    
    public Libro(String idLibro, String titulo, double precio, int cantidad, String origen, String nombreTema){
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.origen = origen;
        this.nombreTema = nombreTema;
    }
    
    public Libro(String idLibro, String titulo, double precio, int cantidad, String origen, int idTema){
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.origen = origen;
        this.idTema = idTema;
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
     * @return the nombreTema
     */
    public String getNombreTema() {
        return nombreTema;
    }

    /**
     * @param nombreTema the nombreTema to set
     */
    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }
    
    
    
}
