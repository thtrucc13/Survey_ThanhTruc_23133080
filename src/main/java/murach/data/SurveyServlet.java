package murach.data;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import murach.business.User;

@WebServlet(name = "SurveyServlet", urlPatterns = {"/survey"})
public class SurveyServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
        String url = "/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html";  // the "join" page
        }
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String heardFrom = request.getParameter("heardFrom");
            
            // radio hoặc checkbox có thể null nếu người dùng không chọn
            String contactVia = request.getParameter("contactVia");

            // checkbox "wantsUpdate" -> nếu null thì false, nếu có giá trị thì true
            boolean wantsUpdate = request.getParameter("wantsUpdate") != null;

            // store data in User object
            User user = new User(firstName, lastName, email, dob, heardFrom, wantsUpdate, contactVia);

            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // the "thanks" page
        }

        // forward to the selected URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
