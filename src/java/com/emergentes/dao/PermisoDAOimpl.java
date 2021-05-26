
package com.emergentes.dao;

import com.emergentes.utiles.ConexionDB;
import com.emergentes.modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermisoDAOimpl extends ConexionDB implements PermisoDAO{

    @Override
    public void insert(Permiso objeto) throws Exception {
           try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("INSERT INTO permisos(id_usuario, id_rol) VALUES (?,?)");
            ps.setInt(1, objeto.getId_usuario());
            ps.setInt(2, objeto.getId_rol());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Permiso objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("UPDATE permisos SET id_usuario=?,id_rol=? WHERE id=?");
            ps.setInt(1, objeto.getId_usuario());
            ps.setInt(2, objeto.getId_rol());
            ps.setInt(3, objeto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("DELETE FROM permisos WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Permiso getById(int id) throws Exception {
        Permiso objeto= new Permiso();
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT p.*,u.usuario as usuario, r.descripcion as rol FROM permisos p LEFT JOIN roles r ON p.id_rol = r.id LEFT JOIN usuarios u ON p.id_usuario = u.id where p.id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                objeto.setId(rs.getInt("id"));
                objeto.setId_usuario(rs.getInt("id_usuario"));
                objeto.setId_rol(rs.getInt("id_rol"));

            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return objeto;}

    @Override
    public List<Permiso> getAll() throws Exception {
        List<Permiso> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT p.*,u.usuario as usuario, r.descripcion as rol FROM permisos p LEFT JOIN roles r ON p.id_rol = r.id LEFT JOIN usuarios u ON p.id_usuario = u.id;");
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Permiso>();
            while (rs.next()) {
                Permiso objeto=new Permiso();
                objeto.setId(rs.getInt("id"));
                objeto.setId_usuario(rs.getInt("id_usuario"));
                objeto.setId_rol(rs.getInt("id_rol"));
                objeto.setUsuario(rs.getString("usuario"));
                objeto.setRol(rs.getString("rol"));
                lista.add(objeto);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return lista;
    }
    
}
