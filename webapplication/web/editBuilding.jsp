<%-- 
    Document   : editBuilding
    Created on : Oct 13, 2016, 10:50:21 PM
    Author     : CHRIS
--%>

<%@page import="entities.Building"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BingoBangoPage123</title>
    </head>
    <body>
        <%
            Building b = (Building) session.getAttribute("editbuilding");
            
        %>
        <form action="Front" method="POST" class="login-container" >
            <p><input type="text" value="<%=b.getAddress()%>" name="address"></p>
            <p><input type="text" value="<%=b.getZip()%>" name="zip"></p>
            <p><input type="text" value="<%=b.getCity()%>" name="city"></p>
            <p><input type="text" value="<%=b.getContactPerson()%>" name="contactPerson"></p>
            <p><input type="text" value="<%=b.getContactPhone()%>" name="contactPhone"></p>
            <input name="method" type="hidden" value="edit2" />
            <input name='buildingID' type='hidden' value="<%=b.getId()%>">
            <center><p><a href="index.jsp">Already Have A Account?</a></p></center>
            <p><input type="submit" value="Apply"></p>
        </form>
        
        <h1>Hello World!</h1>
    </body>
</html>
