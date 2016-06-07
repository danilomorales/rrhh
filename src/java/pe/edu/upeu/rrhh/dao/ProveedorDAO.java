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
import pe.edu.upeu.rrhh.interfaces.InterfaceProveedor;
import pe.edu.upeu.rrhh.modelo.Proveedor;

public class ProveedorDAO implements InterfaceProveedor{
    ConexionBD conn;

    public ProveedorDAO() {        
    }
    @Override
    public List<Proveedor> list() {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM proveedor");
        List<Proveedor> list = new ArrayList<Proveedor>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
            Proveedor prov = new Proveedor();
            prov.setId(rs.getInt("idproveedor"));
            prov.setProv(rs.getString("proveedor"));
            prov.setRuc(rs.getString("ruc"));
            prov.setDir(rs.getString("direccion"));
            prov.setTel(rs.getString("telefono"));
            prov.setEst(rs.getString("estado"));
            list.add(prov);
            }
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return list;
    }
    @Override
    public List<Proveedor> list2() {
         this.conn = FactoryConnectionDB.open(FactoryConnectionDB.ORACLE);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM proveedor");
        List<Proveedor> list = new ArrayList<Proveedor>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            Proveedor prov = new Proveedor();
            prov.setId(rs.getInt("idproveedor"));
            prov.setProv(rs.getString("proveedor"));
            prov.setRuc(rs.getString("ruc"));
            prov.setDir(rs.getString("direccion"));
            prov.setTel(rs.getString("telefono"));
            prov.setEst(rs.getString("estado"));
            list.add(prov);
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return list;
    }
    @Override
    public Proveedor edit(int id) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        Proveedor proveedor  = new Proveedor();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM proveedor WHERE idproveedor = ").append(id);
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while(rs.next()){
                proveedor.setId(rs.getInt("idproveedor"));
                proveedor.setProv(rs.getString("proveedor"));
                proveedor.setRuc(rs.getString("ruc"));
                proveedor.setDir(rs.getString("direccion"));
                proveedor.setTel(rs.getString("telefono"));
                proveedor.setEst(rs.getString("estado"));
            }
        } catch (SQLException e) {
        } finally{
            this.conn.close();
        }
        return proveedor;
    }

    @Override
    public boolean save(Proveedor proveedor) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean save = false;
        try {
//            System.out.println(proveedor.getId()+", "+proveedor.getProv()+", "+proveedor.getDir()+", "+proveedor.getRuc()+", "+proveedor.getTel()+", "+proveedor.getEst());
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO proveedor(idproveedor,proveedor,ruc,direccion,telefono,estado)VALUES(").append(proveedor.getId());
                sql.append(", '").append(proveedor.getProv());
                sql.append("', '").append(proveedor.getRuc());
                sql.append("', '").append(proveedor.getDir());
                sql.append("', '").append(proveedor.getTel());
                sql.append("', '").append(proveedor.getEst()).append("')");
                //String sql1 = "INSERT INTO Proveedor(idproveedor)VALUES(10)";
                this.conn.ejecutar(sql.toString());
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
            sql.append("DELETE FROM proveedor WHERE idproveedor = ").append(id);
            this.conn.ejecutar(sql.toString());
        } catch (Exception e) {
            
        }finally{
            this.conn.close();
        }
        return delete;
    }   

    @Override
        public boolean edit(Proveedor proveedor) {
        this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
        boolean edit = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE proveedor SET idproveedor = ").append(proveedor.getId());
            sql.append(", proveedor = '").append(proveedor.getProv());
            sql.append("', ruc = '").append(proveedor.getProv());
            sql.append("', direccion = '").append(proveedor.getProv());
            sql.append("', telefono = '").append(proveedor.getProv());
            sql.append("', estado = '").append(proveedor.getEst()).append("')");
            edit = true;
        } catch (Exception e) {
        }finally{
            this.conn.close();
        }
        return edit;
    }
}