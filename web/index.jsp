<%-- 
    Document   : index
    Created on : 12-may-2018, 17:27:54
    Author     : ingarukal11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio | Libros</title>
        <style type="text/css">
            .btn-buscar {background-color: deepskyblue;color: white; margin-top: 10px}
        </style>
    </head>
    <body>
    <center>
        <fieldset style="width: 900px">
            <legend>Mantenimiento de Libros</legend>
            <s:form action="buscarLibro" method="post">
                <s:textfield label="ID Libro " name="idLibro"/>
                <s:submit cssClass="btn-buscar" value="Buscar"></s:submit>
            </s:form>
            <p><s:property value="mensaje"></s:property></p>
            <div style="margin-top: 20px">
                <a href="registrarLibro.jsp" style="margin-right: 10px">Nuevo Libro</a>
                <a href="<s:url action='listarLibros'/>">Listar Libros</a>
            </div>
        </fieldset>
    </center>
    </body>
</html>
