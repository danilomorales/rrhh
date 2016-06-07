/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.rrhh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.rrhh.Factory.ConexionBD;
import pe.edu.upeu.rrhh.Factory.FactoryConnectionDB;
import pe.edu.upeu.rrhh.interfaces.InterfaceUnidad;
import pe.edu.upeu.rrhh.modelo.Unidad;

/**
 *
 * @author Danilo
 */
public class UnidadDAO implements InterfaceUnidad {
ConexionBD conn;

    @Override
   public List<Unidad> list() {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM unidad");
        List<Unidad> list = new ArrayList<Unidad>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
            Unidad prov = new Unidad();
            prov.setIdUnidad(rs.getInt("IdUnidad"));
            prov.setUnidad(rs.getString("unidad"));
         
            list.add(prov);
            }
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return list;
    }
    @Override
    public List<Unidad> list(int id) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM unidad WHERE IdUnidad=").append(id);
        List<Unidad> list = new ArrayList<Unidad>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
            Unidad prov = new Unidad();
            prov.setIdUnidad(rs.getInt("IdUnidad"));
            prov.setUnidad(rs.getString("unidad"));
      
            list.add(prov);
            }
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return list;
    }

    @Override
   public boolean edit(Unidad unidad) {
       this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean save = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE departamento SET IdUnidad = ").append(unidad.getIdUnidad());
            sql.append(", unidad = '").append(unidad.getUnidad());
           
            this.conn.execute(sql.toString());
            save = true;
            //System.out.println(departamento.getDpto());
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
//        System.out.println(departamento.getIddpto());
//        System.out.println(departamento.getDpto());
//        System.out.println(departamento.getCostos());
//        System.out.println(departamento.getStatus());
        return save;
    }
    @Override
     public boolean save(Unidad unidad) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean save = false;
        try {
//            System.out.println(departamentp.getId()+", "+departamentp.getProv()+", "+departamentp.getDir()+", "+departamentp.getRuc()+", "+departamentp.getTel()+", "+departamentp.getEst());
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO unidad(idunidad,unidad) VALUES(").append("NULL");
                sql.append(", '").append(unidad.getUnidad());
             
                //String sql1 = "INSERT INTO Proveedor(iddepartamentp)VALUES(10)";
                this.conn.execute(sql.toString());
                save = true;
        } catch (Exception e) {
            this.conn.close();
        }        
        return save;
    }
    @Override
  public boolean delete(int id) {
         this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean delete = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM unidad WHERE idunidad = ").append(id);
            this.conn.execute(sql.toString());
            delete = true;
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        return delete;
    }
    
}
