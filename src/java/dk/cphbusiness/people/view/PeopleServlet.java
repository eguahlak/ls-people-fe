package dk.cphbusiness.people.view;

import dk.cphbusiness.people.contract.PeopleManager;
import dk.cphbusiness.people.contract.dto.PersonSummary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javafx.print.Collation;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PeopleServlet", urlPatterns = {"/Manager"})
public class PeopleServlet extends HttpServlet {
  

  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    PeopleManager manager = Bridge.getInstance().getManager();
    
    Collection<PersonSummary> people = manager.listPeople();
    request.setAttribute("people", people);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("hello.jsp");
    dispatcher.forward(request, response);
    
//    PrintWriter out = response.getWriter();
//    
//    out.println("<!DOCTYPE html>");
//    out.println("<html>");
//    out.println("  <head>");
//    out.println("  </head>");
//    out.println("  <body>");
//    out.println("    <h1>Hello World!</h1>");
//    out.println("  </body>");
//    out.println("</html>");
    
    }

  

  }
