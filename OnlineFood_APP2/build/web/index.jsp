<%-- 
    Document   : index
    Created on : Apr 11, 2021, 7:01:28 PM
    Author     : 14168
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        ServletContext sc = getServletContext();
        RequestDispatcher rd=sc.getRequestDispatcher("/HomeHandlerServlet");
        rd.forward(request,response);
        %>
    </head>
   
</html>
