
package com.emergentes.dao;

import com.emergentes.utiles.ConexionDB;
import com.emergentes.modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolDAOimpl extends ConexionDB implements RolDAO{

    @Override
    public void insert(Rol objeto) throws Exception {
           try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("INSERT INTO roles(descripcion) VALUES (?)");
            ps.setString(1, objeto.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Rol objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("UPDATE roles SET descripcion=? WHERE id=?");
            ps.setString(1, objeto.getDescripcion());
            ps.setInt(2, objeto.getId());
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
            PreparedStatement ps=this.conn.prepareStatement("DELETE FROM roles WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Rol getById(int id) throws Exception {
        Rol objeto= new Rol();
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM roles where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));

            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return objeto;}

    @Override
    public List<Rol> getAll() throws Exception {
        List<Rol> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM roles");
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Rol>();
            while (rs.next()) {
                Rol objeto=new Rol();
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));
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
