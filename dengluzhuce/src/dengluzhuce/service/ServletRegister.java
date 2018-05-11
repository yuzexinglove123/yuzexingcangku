package dengluzhuce.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dengluzhuce.util.Register;

/**
 * Servlet implementation class ServletRegister
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegister() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b = false;
        Register myPOJO=new Register();

        String id=request.getParameter("username");
        String password=request.getParameter("password1");
        String email = request.getParameter("email");

        b=myPOJO.userregister(id,password,email);

        if(b){
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("register.jsp");
        }
	}

}
