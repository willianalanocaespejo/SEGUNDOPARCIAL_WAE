
package com.emergentes.dao;

import com.emergentes.modelo.*;
import java.util.List;

public interface PermisoDAO {
    public void insert(Permiso objeto) throws Exception;
    public void update(Permiso objeto) throws Exception;
    public void delete(int id) throws Exception;
    public Permiso getById(int id) throws Exception;
    public List<Permiso> getAll() throws Exception;
    
}
