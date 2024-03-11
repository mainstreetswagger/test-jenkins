package servlets.people;

import models.Person;
import repositories.IPeopleRepository;
import repositories.PeopleRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PeopleListServlet", value = "/Hello/people-list")
public class ListPeopleServlet extends HttpServlet {
    IPeopleRepository peopleRepository;
    public ListPeopleServlet() {
        peopleRepository = new PeopleRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Person> people;
            String id = request.getParameter("id");

            if(id == null || id == "") {
                people = peopleRepository.getAll();
            } else {
                people = new ArrayList<Person>();
                int personId = Integer.parseInt(id);
                if(personId > 0) {
                    Person person = peopleRepository.get(personId);
                    people.add(person);
                }
            }

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
    }
}
