package dengluzhuce.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dengluzhuce.util.UserLogin;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean b = false;
		UserLogin mypojo = new UserLogin();

		// 取得表单传递的参数
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 如果输入为空，报message提示用户
		String result = "";
		try {
			b = mypojo.isuserLogin(id, password);
			PrintWriter out = response.getWriter();
			// 如果验证结果为true，跳到登陆成功jsp

			if (b) {
				out.println("success");
				result = "success";
				// Cookie
				Cookie username = new Cookie("username", id);
				username.setPath("/");
				username.setMaxAge(60 * 60);
				response.addCookie(username);
				response.sendRedirect("success.jsp");

			} else {
				// 验证失败
				out.println("fail");
				result = "fail";
				response.sendRedirect("LoginFailed.jsp");

			}
			out.write(result);
			out.flush();
			out.close();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 进行数据库验证
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
