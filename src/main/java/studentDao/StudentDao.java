package studentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentData.StudentData;

public class StudentDao {

	private static String url = "jdbc:mysql://localhost/sys";
	private static String username = "root";
	private static String password = "New-0000";
	private static String drivername = "com.mysql.cj.jdbc.Driver";

	private static final String INSERT_USERS_SQL = "INSERT INTO studentinfo"
			+ "(StudentName, StudentLastName, AadharNo, email, department, password) VALUES" + "(?, ?, ?, ?, ?, ?);";
	private static final String SELECT_USERS_BY_ID = "select id, StudentName, StudentLastName,AadharNo,email, department, password from studentinfo where id = ?";
	private static final String SELECT_ALL_USERS = "select id, StudentName, StudentLastName, AadharNo, email, department, password from studentinfo";
	private static final String DELETE_USERS_SQL = "delete from StudentInfo where id = ?";
	private static final String UPDATE_USERS_SQL = "update studentinfo set StudentName = ?, StudentLastName = ?, AadharNo = ?,email = ?, department = ?, password= ? where id = ?";
	private static final String SEARCH_BY_NAME = "select * from studentinfo where StudentName =? ";

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName(drivername);

			try {

				con = DriverManager.getConnection(url, username, password);

			} catch (SQLException ex) {

				System.out.println("Failed to create the database connection.");

			}

		} catch (ClassNotFoundException ex) {

			System.out.println("Driver not found.");

		}

		return con;

	}

	public static int insertUser(StudentData studData) throws SQLException {
		int status = 0;
		Connection con = null;
		con = getConnection();
		try {

			PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);

			ps.setString(1, studData.getStudentName());
			ps.setString(2, studData.getStudentLastName());
			ps.setString(3, studData.getAadharNo());
			ps.setString(4, studData.getEmail());
			ps.setString(5,studData.getDepartment());
			ps.setString(6, studData.getPassword());
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				con.close();
			}

		}
		return status;

	}

	// Update Users
	public static int updateUser(StudentData stud) throws SQLException {
		int status = 0;
		Connection con = null;
		con = getConnection();
		try {

			PreparedStatement ps1 = con.prepareStatement(UPDATE_USERS_SQL);
			ps1.setString(1, stud.getStudentName());
			ps1.setString(2, stud.getStudentLastName());
			ps1.setString(3, stud.getAadharNo());
			ps1.setString(4, stud.getEmail());
			ps1.setString(5,stud.getDepartment());
			ps1.setString(6, stud.getPassword());
			ps1.setString(7, stud.getId());

			status = ps1.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}

		}

		return status;
	}

	// select user by id
	public static StudentData selectUserById(String id) {
		StudentData studData = new StudentData();
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement ps2 = con.prepareStatement(SELECT_USERS_BY_ID);
			ps2.setString(1, id);
			System.out.println(ps2);
			ResultSet rs = ps2.executeQuery();

			while (rs.next()) {

				studData.setId(rs.getString(1));
				studData.setStudentName(rs.getString(2));
				studData.setStudentLastName(rs.getString(3));
				studData.setAadharNo(rs.getString(4));
				studData.setEmail(rs.getString(5));
				studData.setDepartment(rs.getString(6));
				studData.setPassword(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studData;

	}

	// select all users
	public static List<StudentData> selectAllStudentList() {
		List<StudentData> student = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement ps3 = con.prepareStatement(SELECT_ALL_USERS);
			System.out.println(ps3);
			ResultSet rs = ps3.executeQuery();

			while (rs.next()) {
				
				StudentData studData = new StudentData();
				
				studData.setId(rs.getString(1));
				studData.setStudentName(rs.getString(2));
				studData.setStudentLastName(rs.getString(3));
				studData.setAadharNo(rs.getString(4));
				studData.setEmail(rs.getString(5));
				studData.setDepartment(rs.getString(6));
				studData.setPassword(rs.getString(7));
				student.add(studData);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return student;
	}

	// search user by name
	public static List<StudentData> searchUser(String searchText, String fieldName) {
		List<StudentData> student = new ArrayList<>();
		Connection con = null;
		con = getConnection();
		try {
			PreparedStatement p = con.prepareStatement("select id,StudentName,StudentLastName,AadharNo,email,department,password from studentinfo where "+fieldName+" =?;");
			p.setString(1, searchText);
			
			System.out.println(p);
			ResultSet rs = p.executeQuery();

			while (rs.next()) {
				StudentData studData = new StudentData();
				studData.setId(rs.getString("id"));
				studData.setStudentName(rs.getString("StudentName"));
				studData.setStudentLastName(rs.getString("StudentLastName"));
				studData.setAadharNo(rs.getString("AadharNo"));
				studData.setEmail(rs.getString("email"));
				studData.setDepartment(rs.getString("department"));
				studData.setPassword(rs.getString("password"));
				
				student.add(studData);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

		return student;

	}
//

	public static boolean deleteUser(String id) throws SQLException {
		boolean rowDelete;
		Connection con;
		con = getConnection();
		try {

			PreparedStatement ps4 = con.prepareStatement(DELETE_USERS_SQL);

			ps4.setString(1, id);
			int k = ps4.executeUpdate();
			if(k>0) {
				rowDelete=true;
			}else {
				rowDelete=false;
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return rowDelete;

	}

	public static String getSearchByName() {
		return SEARCH_BY_NAME;
	}

//	

}
