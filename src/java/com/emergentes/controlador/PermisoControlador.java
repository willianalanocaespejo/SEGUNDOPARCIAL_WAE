package com.emergentes.controlador;

import com.emergentes.dao.*;
import com.emergentes.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PermisoControlador", urlPatterns = {"/PermisoControlador"})
public class PermisoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            PermisoDAO dao = new PermisoDAOimpl();

            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            RolDAO daoRol = new RolDAOimpl();

            int id;

            List<Usuario> lista_usuario;
            List<Rol> lista_rol;

            Permiso obj = new Permiso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_usuario = daoUsuario.getAll();
                    lista_rol = daoRol.getAll();

                    request.setAttribute("lista_usuario", lista_usuario);
                    request.setAttribute("lista_rol", lista_rol);

                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("frmpermiso.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_usuario = daoUsuario.getAll();
                    lista_rol = daoRol.getAll();

                    request.setAttribute("lista_usuario", lista_usuario);
                    request.setAttribute("lista_rol", lista_rol);

                    id = Integer.parseInt(request.getParameter("id"));
                    obj = dao.getById(id);
                    System.out.println(obj);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("frmpermiso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/PermisoControlador");
                    break;
                case "view":
                    List<Permiso> lista = dao.getAll();
                    request.setAttribute("lista_objetos", lista);
                    request.getRequestDispatcher("Permiso.jsp").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error Controlador Permiso" + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     
        int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));
        String usuario = request.getParameter("usuario");
        String rol = request.getParameter("rol");
        
                 Permiso obj = new Permiso();

        obj.setId(id);
        obj.setId_usuario(id_usuario);
        obj.setId_rol(id_rol);
        obj.setUsuario(usuario);
        obj.setRol(rol);

        if (id == 0) {
            try {
                PermisoDAO dao = new PermisoDAOimpl();
                dao.insert(obj);
                response.sendRedirect(request.getContextPath() + "/PermisoControlador");

            } catch (Exception e) {
                System.out.println("Error al insertar " + e.getMessage());
            }
        } else {
            try {
                PermisoDAO dao = new PermisoDAOimpl();
                dao.update(obj);
                response.sendRedirect(request.getContextPath() + "/PermisoControlador");

            } catch (Exception e) {
                System.out.println("Error actualizar" + e.getMessage());
            }
        }

    }

}
