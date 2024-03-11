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

@WebServlet(name = "PersonServlet", value = "/person")
public class AddPersonGetServlet extends HttpServlet {
    IPeopleRepository peopleRepository;
    public AddPersonGetServlet() {
        peopleRepository = new PeopleRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Person person = new Person();
            String id = request.getParameter("id");
            if( id != null) {
                int personId = Integer.parseInt(id);
                person = peopleRepository.get(personId);
            }

            request.setAttribute("person", person);
            request.setAttribute("title", "Create");
            request.setAttribute("header", "New");
            request.getRequestDispatcher("/people/upsertPerson.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
