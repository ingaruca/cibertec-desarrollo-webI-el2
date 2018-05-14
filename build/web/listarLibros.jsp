<%-- 
    Document   : listarLibros
    Created on : 12-may-2018, 19:56:06
    Author     : ingarukal11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado | Libros</title>
        <style>
            table, td, th {border: 1px solid black;}
            table {border-collapse: collapse;width: 60%;}
            th {height: 30px;}
        </style>
    </head>
    <body>
    <center>
        <fieldset style="width: 900px; margin-bottom: 20px">
            <legend>Listado de Libros</legend>
            <s:if test="noData==true">
                <table style="width: 700px">
                    <thead>
                        <tr style="background-color: #E0E0E1">
                            <th>ID Libro</th>
                            <th>Título</th>
                            <th>Precio S/</th>
                            <th>Cantidad</th>
                            <th>Origen</th>
                            <th>Tema</th>
                        </tr>
                    </thead>
                    <s:iterator value="lista">
                        <tr>
                            <td><s:property value="idLibro"></s:property></td>
                            <td><s:property value="titulo"></s:property></td>
                            <td><s:property value="precio"></s:property></td>
                            <td><s:property value="cantidad"></s:property></td>
                            <td><s:property value="origen"></s:property></td>
                            <td><s:property value="nombreTema"></s:property></td>
                        </tr>
                    </s:iterator>
                </table>
            </s:if>
            <s:else>
                <div style="color:red">Datos no encontrados.</div>
            </s:else>
        </fieldset>
        <a href="index.jsp">Regresar</a>
    </center>
    </body>
</html>
