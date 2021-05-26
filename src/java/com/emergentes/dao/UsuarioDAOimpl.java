
package com.emergentes.dao;

import com.emergentes.utiles.ConexionDB;
import com.emergentes.modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public void insert(Usuario objeto) throws Exception {
           try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("INSERT INTO usuarios(usuario, correo, clave) VALUES (?,?,md5(?))");
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getCorreo());
            ps.setString(3, objeto.getClave());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("UPDATE usuarios SET usuario=?,correo=?,clave=md5(?) WHERE id=?");
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getCorreo());
            ps.setString(3, objeto.getClave());
            ps.setInt(4, objeto.getId());
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
            PreparedStatement ps=this.conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario objeto= new Usuario();
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM usuarios where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                objeto.setId(rs.getInt("id"));
                objeto.setUsuario(rs.getString("usuario"));
                objeto.setCorreo(rs.getString("correo"));
                objeto.setClave(rs.getString("clave"));

            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return objeto;}

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario objeto=new Usuario();
                objeto.setId(rs.getInt("id"));
                objeto.setUsuario(rs.getString("usuario"));
                objeto.setCorreo(rs.getString("correo"));
                objeto.setClave(rs.getString("clave"));
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
