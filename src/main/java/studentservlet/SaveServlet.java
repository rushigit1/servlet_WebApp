package studentservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentDao;
import studentData.StudentData;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String studentName = request.getParameter("studentName");
		String studentLastName = request.getParameter("studentLastName");
		String aadharNo = request.getParameter("AadharNo");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String password = request.getParameter("password");
		
		StudentData studData = new StudentData();
		
		studData.setStudentName(studentName);
		studData.setStudentLastName(studentLastName);
		studData.setAadharNo(aadharNo);
		studData.setEmail(email);
		studData.setDepartment(department);
		studData.setPassword(password);

		
		try {
			int status = StudentDao.insertUser(studData);
			if (status > 0) {
				out.println("<p><Record saved successfully!</p>");
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				
					rd.forward(request, response);
			} else {
				
				RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
				rd.forward(request, response);
				out.println("Sorry! unable to save record");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}

}
