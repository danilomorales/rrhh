/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.rrhh.modelo;

/**
 *
 * @author Docente
 */
public class Proveedor {
    private int id;
    private String prov;
    private String ruc;
    private String dir;
    private String tel;
    private String est;
    public Proveedor() {
        this.id=0;
        this.prov="";
        this.ruc="";
        this.dir="";
        this.tel="";
        this.est="";
    }

    public Proveedor(int id, String prov, String ruc, String dir, String tel, String est) {
        this.id = id;
        this.prov = prov;
        this.ruc = ruc;
        this.dir = dir;
        this.tel = tel;
        this.est = est;
    }

    public int getId() {
        return id;
    }

    public String getProv() {
        return prov;
    }

    public String getRuc() {
        return ruc;
    }

    public String getDir() {
        return dir;
    }

    public String getTel() {
        return tel;
    }

    public String getEst() {
        return est;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEst(String est) {
        this.est = est;
    }
}