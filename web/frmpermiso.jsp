<%@page import="com.emergentes.modelo.*"%>
<%@page import="com.emergentes.dao.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Permiso</title>
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
                Permiso    
            </h1>
            <form action="PermisoControlador" method="post">
                <input type="hidden" name="id" value="${objeto.id}">
            <table width="311">       

                <tr>
                    <td>Usuario</td>
                    <td>
                        <select name="id_usuario" class="form-control" required>
                            <c:forEach var="item" items="${lista_usuario}"> 
                                <option value= ${item.id}     
                                            <c:if test="${objeto.id_usuario == item.id}">
                                                selected
                                            </c:if>
                                        >${item.usuario}</option>
                            </c:forEach>
                        </select>                
                    </td>
                </tr>
                
                <tr>
                    <td>Rol</td>
                    <td>
                        <select name="id_rol" class="form-control" required>
                            <c:forEach var="item" items="${lista_rol}"> 
                                <option value= ${item.id}    
                                            <c:if test="${objeto.id_rol == item.id}">
                                                selected
                                            </c:if>
                                        >${item.descripcion}</option>
                            </c:forEach>
                        </select>                
                    </td>
                </tr>                
                

                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>
        </form>
    </body>
</html>



