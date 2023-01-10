package studentservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentDao;
import studentData.StudentData;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studDao;

	public StudentServlet() {
		this.studDao = new StudentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/insert":
			try {
				insertUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:

			// handle list
			try {
				listUser(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;

		}
		

	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String studentName = request.getParameter("studentName");
		String studentLastName = request.getParameter("studentLastName");
		String aadharNo = request.getParameter("aadharNo");
		StudentData newStud = new StudentData();
		studDao.insertUser(newStud);
		response.sendRedirect("list");
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {

		List<StudentData> listUser = studDao.selectAllStudentList();
		request.setAttribute("listUser", listUser);
		RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
		rd.forward(request, response);
	}

}