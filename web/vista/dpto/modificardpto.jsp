<%-- 
    Document   : modificardpto
    Created on : 01-oct-2014, 18:21:41
    Author     : DavidReyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.edu.upeu.rrhh.modelo.Departamento" %>
<jsp:useBean id="list2" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../../WEB-INF/jspf/jscss.jspf" %>
        <title>JSP Page</title>
        <style type="text/css">
            *{
                margin: 0 auto;
            }
            #caja{
                width: 300px;
            }
        </style>
    </head>
    <body>
         <%@include file="../../WEB-INF/jspf/top.jspf" %>
        <div id="caja">
            <strong>MODIFICAR DEPARTAMENTO</strong>
            <hr>
            <% for(int i=0; i<list2.size();i++){
                    Departamento departamento = new Departamento();
                    departamento = (Departamento)list2.get(i);
            %>
            <form role="form" method="get" action="dpto" >
                <div class="form-group">
                    <label for="exampleInputEmail1">Departamento:</label>
                    <input type="text" class="form-control" value="<%= departamento.getDpto()%>" name="depar">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Centro de Costos:</label>
                    <input type="text" class="form-control" value="<%= departamento.getCostos()%>" name="costos">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Status:</label>
                    <input type="text" class="form-control" value="<%= departamento.getStatus()%>" name="status">
                    <input type="hidden" name="id" value="<%= departamento.getIddpto()%>">
                    <input type="hidden" name="op" value="4">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Modificar">
                </div>
            </form>
            <%}%>
        </div>
        <%@include file="../../WEB-INF/jspf/bottom.jspf" %>
    </body>
</html>
