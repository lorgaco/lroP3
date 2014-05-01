<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="beans.*"%>
<%@page import="packages.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>

<html>
    <head>
        <title>Servicio TV</title>
    </head>
    <body>
        <h1>Servicio de consulta de la programaci&oacute;n</h1>
        <h2>Idioma: ${showsBean.language}, d&iacute;a: ${showsBean.day}</h2>
        <h3>Estos son los programas de deportes:</h3>
        <ul>
            <% sportsBean bean = (sportsBean)request.getAttribute("showsBean"); %>
            <% ListIterator<SportPkg> it = bean.getSports().listIterator();
               for(int ii=0; ii<bean.getSports().size(); ii++){
                    SportPkg sport = it.next(); %>
                    <li><%= sport.name %> a las <%= sport.time %><br />
                    edad m&iacute;nima <%= sport.age %> años.  Duraci&oacute;n: <%= sport.duration %> minutos<p>
            <% }%>
        </ul>
        <form method='POST'>
            <input type='hidden' name='query' value='sports'>
            <input type='hidden' name='language' value='${showsBean.language}'>
            <input type='hidden' name='day' value='${showsBean.day}'>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action="?step=2"'>
            <input type='submit' value='Inicio' onClick='document.forms[0].method="GET"'>
        </form>
    </body>
</html>