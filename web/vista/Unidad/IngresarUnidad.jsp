<%-- 
    Document   : IngresarUnidad
    Created on : 06-jun-2016, 18:45:03
    Author     : Danilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <strong>REGISTRAR UNIDAD</strong>
            <hr>
            
            <form role="form" method="get" action="dpto">
                
                <div class="form-group">
                    <label for="exampleInputEmail1">Unidad:</label>
                    <input type="text" class="form-control" name="depar" placeholder="Ingresar Departamento" autofocus="">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Centro de Costos:</label>
                    <input type="text" class="form-control" name="costos" placeholder="Ingresar Centro de Costos">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Status:</label>
                    <input type="text" class="form-control" name="status" placeholder="Ingresar Status">
                    <input type="hidden" class="form-control" name="op" value="5">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Resgistrar">
                </div>
            </form>
        </div>
        <%@include file="../../WEB-INF/jspf/bottom.jspf" %>

    </body>
</html>