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
        <h2>Idioma: ${showsBean.language}, d&iacute;a: ${showsBean.day}, canal: ${showsBean.channel}</h2>
        <h3>Estos son los programas:</h3>
        <ul>
            <% showsBean bean = (showsBean)request.getAttribute("showsBean"); %>
            <% ListIterator<ShowPkg> it = bean.getShows().listIterator();
               for(int ii=0; ii<bean.getShows().size(); ii++){
                    ShowPkg show = it.next(); %>
                    <li><%= show.name %> a las <%= show.time %><br />
                    edad m&iacute;nima <%= show.age %> años.<p>
            <% }%>
        </ul>
        <form method='POST'>
            <input type='hidden' name='query' value='shows'>
            <input type='hidden' name='language' value='${showsBean.language}'>
            <input type='hidden' name='day' value='${showsBean.day}'>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action="?step=3"'>
            <input type='submit' value='Inicio' onClick='document.forms[0].method="GET"'>
        </form>
    </body>
</html>