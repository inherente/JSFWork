<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.inherente.reloaded.core.ServletHandler" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="STYLESHEET" type="text/css" href="codebase/dhtmlxgrid.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Allocate Title here</title>
    <script src="codebase/dhtmlxcommon.js"></script>
    <script src="codebase/dhtmlxgrid.js"></script>
    <script src="codebase/dhtmlxgridcell.js"></script>
    <script>
        var theGrid;
        function doInitGrid() {

        	theGrid = new dhtmlXGridObject('gridContainer');
        	theGrid.setImagePath("codebase/imgs/");
        	theGrid.setSkin("light");
        	alert();
        	theGrid.init();
        	theGrid.loadXML('<%= request.getAttribute(ServletHandler.FILE_NAME_KEY) %>');

        }
    </script>

</head>
<body onload="doInitGrid()">
    <hr/>
    <h1>H1</h1>
    <div id="gridContainer" style="width:100%;height:150px;"></div>

</body>
</html>