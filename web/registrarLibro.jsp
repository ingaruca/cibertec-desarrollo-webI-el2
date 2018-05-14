<%-- 
    Document   : registrarLibro
    Created on : 12-may-2018, 17:47:09
    Author     : ingarukal11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro | Libros</title>
        <style type="text/css">
            .btn-registrar {background-color: green;color: white; margin-top: 10px}
        </style>
    </head>
    <body>
    <center>
        <fieldset style="width: 900px; margin-bottom: 20px">
            <legend>Registro de Libro</legend>
            <s:form action="registrarLibro" method="post">
                <s:textfield label="ID Libro " name="idLibro"/>
                <s:textfield label="Título " name="titulo"/>
                <s:textfield label="Precio" name="precio"/>
                <s:textfield label="Cantidad " name="cantidad"/>
                <s:textfield label="Origen " name="origen"/>
                <s:select label="Tema " name="idTema" 
                          list="#{'1':'Filosofia', '2':'Poesia', '3':'Arte', '4':'Novela'}"
                          headerKey="-1" headerValue="--- Seleccionar ---"
                ></s:select>
                <s:submit cssClass="btn-registrar" value="Registrar"></s:submit>
            </s:form>
            <s:if test="ctr>0">
                <span style="color: green"><s:property value="mensaje"></s:property></span>
            </s:if>
            <s:else>
                <span style="color: red"><s:property value="mensaje"></s:property></span>
            </s:else>
        </fieldset>
        <a href="index.jsp">Regresar</a>
    </center>        
    </body>
</html>
