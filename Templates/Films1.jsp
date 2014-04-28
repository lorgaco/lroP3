<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="Bean"%>

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
            <% Bean bean = (Bean)request.getAttribute("days"); %>
            <% List<String> days = bean.getDays(); %>
            <% ListIterator<String> it = days.listIterator(); %>
    		<% for(int ii=0; ii<days.size(); ii++){ %>
            <%    String day = it.next(); %>
    		<%    if(ii==days.size()-1){ %>
        	        <input type='radio' name='day' value='<%=day%>' checked><%=day%><BR>
        	<%	  } %>
    		<%    else{ %>
    		    	  <input type='radio' name='day' value='<%=day%>' ><%=day%><BR>
   		    <% 	  } %>
    		<% } %>
            <p><input type='submit' value='Enviar'>
            <input type='submit' value='Atr&aacute;s' onClick='document.forms[0].method=\"GET\"'>
        </form>
    </body>
</html>