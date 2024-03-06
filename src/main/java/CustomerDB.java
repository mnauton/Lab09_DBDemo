
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerDB
 */
public class CustomerDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
//jdbc:mysql://localhost:3306/mydb1860?useSSL=false

	private static final String DATABASE_URL = "jdbc:mysql://danu6.it.nuigalway.ie:3306/mydb1860?useSSL=false";

	//private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/employees?useSSL=false";

	private static final String USERNAME = "mydb1860o";
	private static final String PASSWORD = "mydb1860o";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = null;
			java.sql.Statement stmt = null;

			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT customerName FROM customers");

			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println(name);

			}

			con.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}