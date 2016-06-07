<%-- 
    Document   : modificarUnidad
    Created on : 06-jun-2016, 21:17:10
    Author     : Danilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.edu.upeu.rrhh.modelo.Unidad" %>
<jsp:useBean id="list2" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <strong>MODIFICAR UNIDAD</strong>
            <hr>
            <% for(int i=0; i<list2.size();i++){
                    Unidad unidad = new Unidad();
                    unidad = (Unidad)list2.get(i);
            %>
            <form role="form" method="get" action="Unidad" >
                <div class="form-group">
                    <label for="exampleInputEmail1">Unidad:</label>
                    <input type="text" class="form-control" value="<%= unidad.getUnidad()%>" name="unid">
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
