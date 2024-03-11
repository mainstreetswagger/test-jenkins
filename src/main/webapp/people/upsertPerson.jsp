<%@ page import="models.Person" %>
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
            <%Person person = (Person)request.getAttribute("person");%>
            <form action="/Hello/person-create" method="post">
                <input type="hidden" value="<%=person.getId()%>" name="id" />
                    <div>
                        <label>Name:</label>
                        <input type="text" name="name" value="<%=person.getName()%>" />
                    </div>
                    <div>
                        <label>Surname:</label>
                        <input type="text" name="surname" value="<%=person.getSurname()%>" />
                    </div>
                    <div>
                        <label>Age:</label>
                        <input type="number" name="age" min="1" max="100" value="<%=person.getAge()%>" />
                    </div>
                    <div>
                        <label>&nbsp;</label>
                        <input type="submit" value="Submit" class="submit" />
                    </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

