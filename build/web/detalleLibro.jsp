<%-- 
    Document   : detalleLibro
    Created on : 12-may-2018, 18:36:19
    Author     : ingarukal11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle | Libro</title>
    </head>
    <body>
    <center>
        <fieldset style="width: 900px; padding-top: 40px; padding-bottom: 40px; margin-bottom: 20px">
            <s:if test="noData==true">
            <legend>Detalle de Libro - ID <s:property value="idLibro"/></legend>
            <table style="width: 500px" border="1px">
                <tr>
                    <td><strong>Título</strong></td>
                    <td><s:property value="titulo"/></td>
                </tr>
                <tr>
                    <td><strong>Precio</strong></td>
                    <td>S/ <s:property value="precio"/></td>
                </tr>
                <tr>
                    <td><strong>Cantidad</strong></td>
                    <td><s:property value="cantidad"/></td>
                </tr>
                <tr>
                    <td><strong>Origen</strong></td>
                    <td><s:property value="origen"/></td>
                </tr>
                <tr>
                    <td><strong>Tema</strong></td>
                    <td><s:property value="tema"/></td>
                </tr>
            </table>
            </s:if>
            <s:else>
                <p style="color: red">El ID ingresado no existe.</p>
            </s:else>
        </fieldset>
                <a href="index.jsp">Regresar</a>        
    </center>
    </body>
</html>
