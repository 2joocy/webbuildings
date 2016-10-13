<%-- 
    Document   : index
    Created on : 12-10-2016, 23:25:00
    Author     : William-PC
--%>

<%@page import="DbHandler.DbBuildingHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            DbBuildingHandler db = new DbBuildingHandler();
            out.print(db.showBuildings(db.getBuildings()));
        %>
    </body>
</html>
