<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page import="beans.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>

<html>
    <head>
        <title>Servicio TV</title>
    </head>
    <body>
        <h1>Servicio de consulta de la programaci&oacute;n</h1>
        <h2>Pel&iacute;culas</h2>
        <h3>Selecciona un d&iacute;a:</h3>
        <form method='POST' action='?step=2'>
            <input type='hidden' name='query' value='movies'>
    		<% List<String> languages = TvGuide.getLanguages();
               ListIterator<String> it = languages.listIterator();
               for(int ii=0; ii<languages.size(); ii++){
                    String language = it.next();
            %>
              <input type='radio' name='language' value='${element}'>${element}</option>
            <%}%>
            <p><input type='submit' value='Enviar'>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].method=\"GET\"'>
        </form>
    </body>
</html>