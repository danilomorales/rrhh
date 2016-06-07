<%-- 
    Document   : listardpto
    Created on : 01-oct-2014, 18:21:04
    Author     : DavidReyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.edu.upeu.rrhh.modelo.Departamento" %>
<jsp:useBean id="list1" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../WEB-INF/jspf/jscss.jspf" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../../WEB-INF/jspf/top.jspf" %>
        
        <div class="table-responsive">
            <a href="<%= request.getContextPath()%>/dpto?op=2" class="btn btn-mini btn-primary" role="button">Nuevo</a>
            <hr>
            <table class="table table-bordered" style="width: 800px;">
                <tr>
                    <th>Id</th>
                    <th>Departamento</th>
                    <th>Centro Costos</th>
                    <th>Status</th>
                    <th></th>
                </tr>
                <% for(int i=0; i<list1.size();i++){
                    Departamento departamento = new Departamento();
                    departamento = (Departamento)list1.get(i);
                    %>
                <tr>
                    <td><%= departamento.getIddpto()%></td>
                    <td><%= departamento.getDpto()%></td>
                    <td><%= departamento.getCostos()%></td>
                    <td><%= departamento.getStatus()%></td>
                    <td>
                        <a href="dpto?op=3&id=<%= departamento.getIddpto()%>" class="btn btn-mini btn-primary" role="button">Editar</a>
                        <a href="dpto?op=6&id=<%= departamento.getIddpto()%>" class="btn btn-mini btn-primary" role="button">Eliminar</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
        <%@include file="../../WEB-INF/jspf/bottom.jspf" %>
    </body>
</html>
