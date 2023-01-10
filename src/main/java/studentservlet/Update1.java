package studentservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentDao;
import studentData.StudentData;

@WebServlet("/StudUpdate")
public class Update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String id = request.getParameter("id");
		System.out.println(id);
		String studentName = request.getParameter("studentName");
		System.out.println(studentName);
		String studentLastName = request.getParameter("studentLastName");
		System.out.println(studentLastName);
		String aadharNo = request.getParameter("AadharNo");
		System.out.println(aadharNo);
		String email = request.getParameter("email");
		System.out.println(email);
		String department = request.getParameter("department");
		System.out.println(department);
		String password = request.getParameter("password");
		System.out.println(password);

		StudentData studData = new StudentData();
		studData.setId(id);
		studData.setStudentName(studentName);
		studData.setStudentLastName(studentLastName); 
		studData.setAadharNo(aadharNo);
		studData.setEmail(email);
		studData.setDepartment(department);
		studData.setPassword(password);

		try {
			int status = StudentDao.updateUser(studData);
			if (status > 0) {
				response.sendRedirect("dashboard.jsp");
			} else {

				out.println("Sorry! unable to update record");

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
