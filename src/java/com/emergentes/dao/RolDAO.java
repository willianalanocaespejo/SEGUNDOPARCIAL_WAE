
package com.emergentes.dao;

import com.emergentes.modelo.*;
import java.util.List;

public interface RolDAO {
    public void insert(Rol objeto) throws Exception;
    public void update(Rol objeto) throws Exception;
    public void delete(int id) throws Exception;
    public Rol getById(int id) throws Exception;
    public List<Rol> getAll() throws Exception;
    
}
