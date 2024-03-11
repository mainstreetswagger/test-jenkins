<%--
  Created by IntelliJ IDEA.
  User: KWalker
  Date: 3/10/2024
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
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
                <div class="d-flex justify-content-between">
                    <div class="m-2">
                        <form action="/person" method="get">
                            <input class="btn btn-success" type="submit" value="New" />
                        </form>
                    </div>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th class="col-1">Id</th>
                    <th class="col-1">Name</th>
                    <th class="col-1">Surname</th>
                    <th class="col-1">Age</th>
                    <th class="col-2">Actions</th>
                </tr>
                </thead>
                <tbody>
                <%List<Person> people = (ArrayList<Person>)request.getAttribute("people");%>
                <%for(int i = 0; i < people.size(); i++) {%>
                <tr>
                    <td class="col-1"><%=people.get(i).getId()%></td>
                    <td class="col-1"><%=people.get(i).getName()%></td>
                    <td class="col-1"><%=people.get(i).getSurname()%></td>
                    <td class="col-1"><%=people.get(i).getAge()%></td>
                    <td class="col-2">
                        <div>
                            <a href="/person?id=<%=people.get(i).getId()%>">Update</a> | <a href="/person-delete?id=<%=people.get(i).getId()%>">Delete</a>
                        </div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div></div>
</body>
</html>
