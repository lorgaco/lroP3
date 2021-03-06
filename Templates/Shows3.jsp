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
        <h2>Idioma: ${channelsBean.language}, d&iacute;a: ${channelsBean.day}</h2>
        <h3>Selecciona un canal:</h3>
        <form method='POST' action='?step=4'>
            <input type='hidden' name='query' value='shows'>
            <input type='hidden' name='language' value='${channelsBean.language}'>
            <input type='hidden' name='day' value='${channelsBean.day}'>
            <% channelsBean bean = (channelsBean)request.getAttribute("channelsBean"); %>
            <% ListIterator<String> it = bean.getChannels().listIterator();
               for(int ii=0; ii<bean.getChannels().size(); ii++){
                    String channel = it.next(); %>
                    <input type='radio' name='channel' value='<%= channel %>' <%if(ii==bean.getChannels().size()-1){%>checked<%}%>><%= channel %></option><br />
            <% }
               if(bean.getChannels().size()>0){%>
                    <p><input type='submit' value='Enviar'>
            <% }%>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].action="?step=2"'>
            <input type='submit' value='Inicio' onClick='document.forms[0].method="GET"'>
        </form>
    </body>
</html>