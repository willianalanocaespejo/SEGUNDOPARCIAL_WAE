<%@page import="com.emergentes.modelo.*"%>
<%@page import="com.emergentes.dao.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Usuario</title>
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

        <h1>
            <c:if test="${objeto.id == 0}">Nuevo </c:if>
            <c:if test="${objeto.id > 0}">Editar </c:if>
            Usuario    
        </h1>
        <form action="UsuarioControlador" method="post">
            <input type="hidden" name="id" value="${objeto.id}">
            <table width="311">       
                <tr>
                    <td>Usuario</td>
                    <td ><input name="usuario" type="text" value="${objeto.usuario}" required></td>                   
                </tr>
                
                <tr>
                    <td>Correo</td>
                    <td ><input name="correo" type="text" value="${objeto.correo}" required></td>                   
                </tr>                

                <tr>
                    <td>Password</td>

                    <td ><input name="clave" type="password" value="" required></td>  
 
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>
        </form>
    </body>
</html>