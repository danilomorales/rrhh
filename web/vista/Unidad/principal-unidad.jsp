<%-- 
    Document   : principal-unidad
    Created on : 06-jun-2016, 18:44:29
    Author     : Danilo
--%>


<%@page import="pe.edu.upeu.rrhh.modelo.Unidad" %>
<jsp:useBean id="list1" scope="session" class="java.util.ArrayList"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%@include file="../../WEB-INF/jspf/jscss.jspf" %>
        
         
        
    </head>
   <body>
        <%@include file="../../WEB-INF/jspf/top.jspf" %>
        
        <div class="table-responsive">
            <a href="<%= request.getContextPath()%>/uni?op=2" class="btn btn-mini btn-primary" role="button">Nuevo</a>
            <hr>
            <table class="table table-bordered" style="width: 800px;">
                <tr>
                    <th>Id</th>
                    <th>Unidad</th>
                    
                    <th></th>
                </tr>
                <% for(int i=0; i<list1.size();i++){
                    Unidad unidad = new Unidad();
                    unidad = (Unidad)list1.get(i);
                    %>
                <tr>
                    <td><%= unidad.getIdUnidad()%></td>
                    <td><%= unidad.getUnidad()%></td>
                   
                    <td>
                        <a href="uni?op=3&id=<%= unidad.getIdUnidad()%>" class="btn btn-mini btn-primary" role="button">Editar</a>
                        <a href="uni?op=6&id=<%= unidad.getIdUnidad()%>" class="btn btn-mini btn-primary" role="button">Eliminar</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
        <%@include file="../../WEB-INF/jspf/bottom.jspf" %>
    </body>
</html>
