<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pagina no encontrada</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="description" content="GestionSoft " />
<meta name="author" content="GestionSoft" />
<meta http-equiv="Pragma" content="no-cache" />

<link rel="stylesheet" media="screen" type="text/css" href="/gestionsoft_static/resources/stylesheet/gs.css" />
 
</head>
<body>
	<div class="contenidoErrores">
		<div>
			<img alt="Logo GestionSoft" src="/gestionsoft_static/resources/images/logo.png" class="logo"/>
		</div>
		<h1 class="textoError">Solicitud incorrecta. Error 400.</h1>	
		<h2 class="textoError">Una p&aacute;gina de error 400 indica que la petici&oacute;n realizada no es correcta y por tanto, no se ha podido procesar.<br/>
		</h2>
		<h2 class="textoError">Para regresar a la p&aacute;gina en la que se encontraba antes del error, pinche en el bot&oacute;n Volver. Para ir<br/>
		al inicio de la aplicaci&oacute;n, presione en el bot&oacute;n de inicio</h2>
	</div>
	<div class="botoneraError">
		<input id="btnBajoTablaPrimeroError" type="button" value="<< Volver" onclick="history.back()"/>
	    <input id="btnBajoTablaSegundoError" type="button" value="Inicio" onclick="location.href='./index.xhtml'"/>
    </div>
</body>
</html>