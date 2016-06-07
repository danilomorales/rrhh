/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.rrhh.interfaces;
import java.util.List;

import pe.edu.upeu.rrhh.modelo.Unidad;

/**
 *
 * @author Danilo
 */
public interface InterfaceUnidad {
    public List<Unidad> list();
    public List<Unidad> list(int id);
    public boolean edit(Unidad unidad);
    public boolean save(Unidad unidad);
    public boolean delete(int id);
}
