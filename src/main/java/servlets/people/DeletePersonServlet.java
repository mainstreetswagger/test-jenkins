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
import java.lang.reflect.Method;
import java.rmi.server.ExportException;

@WebServlet(name = "PersonDeleteServlet", value = "/person-delete")
public class DeletePersonServlet extends HttpServlet {
    IPeopleRepository peopleRepository;
    public DeletePersonServlet() {
        peopleRepository = new PeopleRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            int personId = 0;
            boolean result = false;
            if(id != null){
                personId = Integer.parseInt(id);
                if(personId > 0) {
                    result = peopleRepository.delete(personId);
                }
            }
            if(result) {
                response.sendRedirect("/people-list");
            } else {
                throw new Exception("Failed to delete...");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
