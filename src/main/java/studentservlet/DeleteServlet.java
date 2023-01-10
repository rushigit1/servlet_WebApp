package studentservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentDao;



@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Connection con = StudentDao.getConnection();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			PreparedStatement ps = con.prepareStatement("Delete from studentinfo where id=?");
			ps.setString(1, id);
			int k = ps.executeUpdate();
			
			if(k>0) {
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			}else {
			
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.include(request, response);
				pw.print("Student couldn't deleted");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
	}

	

}