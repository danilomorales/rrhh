<%-- 
    Document   : index
    Created on : 07-jul-2014, 11:31:10
    Author     : Docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.edu.upeu.rrhh.modelo.Proveedor" %>
<jsp:useBean id="list" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/jscss.jspf" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/top.jspf" %>
        <div class="table-responsive">
            <a href="<%= request.getContextPath()%>/proveedor?op=create" class="btn btn-mini btn-primary" role="button">Nuevo</a>
            <table class="table table-bordered" style="width: 900px;">
                <tr>
                    <th>Id</th>
                    <th>Proveedor</th>
                    <th>RUC</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Estado</th>
                    <th></th>
                </tr>
                <% for(int i=0; i<list.size();i++){
                    Proveedor proveedor = new Proveedor();
                    proveedor = (Proveedor)list.get(i);
                    %>
                <tr>
                    <td><%= proveedor.getId() %></td>
                    <td><%= proveedor.getProv() %></td>
                    <td><%= proveedor.getRuc() %></td>
                    <td><%= proveedor.getDir() %></td>
                    <td><%= proveedor.getTel() %></td>
                    <td><%= proveedor.getEst() %></td>
                    <td>
                        <a href="index" class="btn btn-mini btn-primary" role="button">Editar</a>
                        <a href="proveedor" class="btn btn-mini btn-primary" role="button">Eliminar</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
        <%@include file="../WEB-INF/jspf/bottom.jspf" %>
    </body>
</html>
