<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<script type="text/javascript" language="Javascript" SRC="./ExtJS/ext-all.js"></script>
	<link rel="stylesheet" type="text/css" href="./ExtJS/ext-all-gray.css" />
	
	<script type="text/javascript" language="Javascript" SRC="./js/DesktopApplication/main.js"></script>
	<script type="text/javascript" language="Javascript" SRC="./js/DesktopApplication/tabPanel.js"></script>
	<script type="text/javascript" language="Javascript" SRC="./js/DesktopApplication/toolbar.js"></script>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Restaurant Manager - Desktop</title>
	</head>
	
	<body>
		<div id='center'></div>
		
		<script type="text/javascript">
			/*Quando il documento � caricato eseguo l'applicazione*/
			Ext.EventManager.onDocumentReady(desktop_main);
		</script>
		
	</body>
	
</html>