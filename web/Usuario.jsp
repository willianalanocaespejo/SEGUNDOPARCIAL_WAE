<%@page import="com.emergentes.modelo.*"%>
<%@page import="com.emergentes.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SEGUNDO EXAMEN</h1>

        <ul >
            <li >
                <a href="UsuarioControlador">Usuario</a>
            </li>
            <li >
                <a href="RolControlador">Rol</a>
            </li>
            <li >
                <a href="PermisoControlador">Permiso</a>
            </li>
        </ul>


        <h1>USUARIOS REGISTRADOS</h1>
        <p><a href="UsuarioControlador?action=add">Nuevo</a></p>

        <table border="1">
            <tr>
                <th>Id</th>
                <th>Usuario</th>
                <th>Correo</th>
                <th>Clave</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${lista_objetos}">        
                <tr>
                    <td>${item.id}</td>
                    <td>${item.usuario}</td>
                    <td>${item.correo}</td>
                    <td>${item.clave}</td>
                    <th><a href="UsuarioControlador?action=edit&id=${item.id}">Editar</a></th>
                    <td><a href="UsuarioControlador?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro?'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

