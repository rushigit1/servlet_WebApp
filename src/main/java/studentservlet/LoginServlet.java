package studentservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sys", "rushi123");
			
			PrintWriter out = response.getWriter();
			String StudentName = request.getParameter("studentName");
			
			String StudentLastName = request.getParameter("studentLastName");
			String Password = request.getParameter("password");
			
			
			PreparedStatement ps = con.prepareStatement("Select * from studentinfo where StudentName = ? and StudentLastName = ? and Password = ?;");
			ps.setString(1, StudentName);
			ps.setString(2, StudentLastName);
			ps.setString(3, Password);
			System.out.println();
			
			ResultSet rs = ps.executeQuery();
		   
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
				
			}else {
				out.println("<div align = center><font color = red size = 12>Login Failed!!!</div><br>");
				out.println("<div align = center><a href=login.jsp> Try Again!!</a></div>");
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
	
	}

}
