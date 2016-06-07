/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.rrhh.modelo;

/**
 *
 * @author Danilo
 */
public class Unidad {

    private int IdUnidad;
    private String unidad;
    
    
    public Unidad() {
    }
    public Unidad(String unidad) {
        this.unidad = unidad;
       
    }
    public int getIdUnidad() {
        return IdUnidad;
    }

    public void setIdUnidad(int IdUnidad) {
        this.IdUnidad = IdUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
  
    
}
