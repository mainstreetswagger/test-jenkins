package servlets.people;

import models.Person;
import repositories.IPeopleRepository;
import repositories.PeopleRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeopleListServlet", value = "/PeopleListServlet")
public class PeopleListServlet extends HttpServlet {
    //list all people
    IPeopleRepository peopleRepository;
    public PeopleListServlet() {
        peopleRepository = new PeopleRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Person> people = peopleRepository.getAll();
            request.setAttribute("title", "People");
            request.setAttribute("header", "People List");
            request.setAttribute("people", people);
            request.getRequestDispatcher("/people/people.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Person> people = peopleRepository.getAll();
            request.setAttribute("title", "People");
            request.setAttribute("header", "People List");
            request.setAttribute("people", people);
            request.getRequestDispatcher("/people/people.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
