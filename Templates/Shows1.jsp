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
        <h2>shows</h2>
        <h3>Selecciona un idioma:</h3>
        <form method='POST' action='?step=2'>
            <input type='hidden' name='query' value='shows'>
            <% languagesBean bean = (languagesBean)request.getAttribute("languagesBean"); %>
    		<% ListIterator<String> it = bean.getLanguages().listIterator();
               for(int ii=0; ii<bean.getLanguages().size(); ii++){
                    String language = it.next(); %>
                    <input type='radio' name='language' value='<%= language %>'><%= language %></option><br />
            <% }%>
            <input type='radio' name='language' value='all' checked> Todos<BR>
            <% if(bean.getChannels().size()>0){%>
                    <p><input type='submit' value='Enviar'>
            <% }%>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].method=\"GET\"'>
        </form>
    </body>
</html>