<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
        <h2>Idioma: ${daysBean.language}</h2>
        <h3>Selecciona un d&iacute;a:</h3>
        <form method='POST' action='?step=3'>
            <input type='hidden' name='query' value='shows'>
            <input type='hidden' name='language' value='${daysBean.language}'>
            <% daysBean bean = (daysBean)request.getAttribute("daysBean"); %>
    		<% ListIterator<String> it = bean.getDays().listIterator();
               for(int ii=0; ii<bean.getDays().size(); ii++){
                    String day = it.next(); %>
                    <input type='radio' name='day' value='<%= day %>' <%if(ii==bean.getDays().size()-1){%>checked<%}%>><%= day %></option><br />
            <% }
               if(bean.getDays().size()>0){%>
                    <p><input type='submit' value='Enviar'>
            <% }%>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action="?step=1"'>
            <input type='submit' value='Inicio' onClick='document.forms[0].method="GET"'>
        </form>
    </body>
</html>