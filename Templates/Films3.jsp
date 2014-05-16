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
        <h2>D&iacute;a: ${filmsBean.day}, canal: ${filmsBean.channel}</h2>
        <h3>Estas son las pel&iacute;culas:</h3>
        <ul>
            <% showsBean bean = (showsBean)request.getAttribute("filmsBean"); %>
            <% ListIterator<ShowPkg> it = bean.getShows().listIterator();
               for(int ii=0; ii<bean.getShows().size(); ii++){
                    ShowPkg film = it.next(); %>
                    <li><%= film.name %> a las <%= film.time %><br />
                    <%= film.synopsis %><p>
            <% }%>
        </ul>
        <form method='POST'>
            <input type='hidden' name='query' value='movies'>
            <input type='hidden' name='day' value='${filmsBean.day}'>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action="?step=2"'>
            <input type='submit' value='Inicio' onClick='document.forms[0].method="GET"'>
        </form>
    </body>
</html>