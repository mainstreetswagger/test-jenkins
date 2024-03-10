<%--
  Created by IntelliJ IDEA.
  User: KWalker
  Date: 3/10/2024
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title><%=request.getAttribute("title").toString()%></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="m-2 d-flex align-items-center justify-content-center">
    <div class="container m-2">
        <div><h2><%=request.getAttribute("header").toString()%></h2></div>
        <div class="border border-dark rounded">
            <div class="d-flex justify-content-between">
                <form action="/person" method="get">
                    <input class="btn btn-success" type="button" value="New" />
                </form>
            </div>
            <form method="post" >
                <fieldset>
                    <div>
                        <label>Name:</label>
                        <input type="text" name="name" value="" />
                    </div>
                    <div>
                        <label>Surname:</label>
                        <input type="text" name="surname" value="" />
                    </div>
                    <div>
                        <label>Age:</label>
                        <input type="number" name="age" value="1" min="1" max="100"/>
                    </div>
                    <div>
                        <label>&nbsp;</label>
                        <input type="submit" value="Submit" class="submit" />
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>

