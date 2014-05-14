<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Servicio de TV</title>
    </head>
    <body>
        <h1>Servicio de consulta de la programaci&oacute;n</h1>
        <h2>Bienvenido a este servicio</h2>
        Estado de los TVML:<br />${errorBean.Error}
        <h3>Selecciona lo que quieres buscar:</h3>
        <form method='POST' action='?step=1'>
            <input type='radio' name='query' value='shows'> Consulta Series<br>
            <input type='radio' name='query' value='movies'> Consulta Pel&iacute;culas<br>
            <input type='radio' name='query' value='sports' checked> Consulta Deportes<br>
            <p><input type='submit' value='Enviar'>
        </form>
    </body>
</html>