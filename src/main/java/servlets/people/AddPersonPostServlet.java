package servlets.people;

import models.Person;
import repositories.IPeopleRepository;
import repositories.PeopleRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonPostServlet", value = "/person-create")
public class AddPersonPostServlet extends HttpServlet {
    IPeopleRepository peopleRepository;
    public AddPersonPostServlet() {
        peopleRepository = new PeopleRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            int personId = 0;
            boolean result = false;
            personId = Integer.parseInt(id);
            if(personId > 0) {
                result = peopleRepository.update(new Person(personId, name, surname, age));
                String route = String.format("/people-list?id=%d", personId);
                response.sendRedirect(route);
            } else {
                personId = peopleRepository.add(new Person(name, surname, age));
                String route = String.format("/people-list?id=%d", personId);
                response.sendRedirect(route);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
