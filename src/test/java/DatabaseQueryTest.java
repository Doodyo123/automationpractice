import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseQueryTest {
	// Execute Queries
	// database_homework_2
	@Test
	public void canRunQueryTwo() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "1234");
		System.out.println("Connected to MySQL DB");

		Statement smt = con.createStatement();

		ResultSet result = smt.executeQuery("SELECT DISTINCT title from sakila.film\r\n" + 
				"WHERE title LIKE '%airplane%'");

		while(result.next()) {

			String title = result.getString("title");
			System.out.println("Database record is " + title);
		}
		con.close();
	}

	// Execute Queries
	// database_homework_7
	@Test
	public void canRunQuerySeven() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "1234");
		System.out.println("Connected to MySQL DB");

		String createProcedure = null;
		String queryDrop = "DROP PROCEDURE IF EXISTS getInventory";

		createProcedure = 
				"create procedure getInventory()" +
						"begin " +
						"SELECT inventory_id, title, store_id FROM sakila.film AS A\r\n" + 
						"LEFT JOIN sakila.inventory AS B\r\n" + 
						"ON B.film_id = A.film_id\r\n" + 
						"WHERE A.title = 'Alien Center'\r\n" + 
						"AND B.store_id = 2;" +
						"end";
		Statement stmt = null;
		Statement stmtDrop = null;

		System.out.println("Calling Drop PROCEDURE");
		stmtDrop = con.createStatement();
		stmtDrop.execute(queryDrop);
		if (stmtDrop!= null) {
			stmtDrop.close();
		}

		stmt = con.createStatement();
		stmt.executeUpdate(createProcedure);
		if(stmt != null) {
			stmt.close();
		}

		CallableStatement cs = null;
		cs = con.prepareCall("{call getInventory}");
		ResultSet rs = cs.executeQuery();

		while(rs.next()) {

			String id = rs.getString("inventory_id");
			System.out.println("Database record is " + id);
		}
		con.close();
	}

	// Execute Queries
	// database_homework_8
	@Test
	public void canRunQueryEight() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "1234");
		System.out.println("Connected to MySQL DB");
		String insertQuery = "INSERT INTO store(store_id, manager_staff_id, address_id, last_update)\r\n" + 
				"VALUES (4, 4, 4, '2006-02-15 04:57:12');";

		con.setAutoCommit(false);
		try {
			PreparedStatement updatedStore = con.prepareStatement(insertQuery);
			updatedStore.executeUpdate();
			System.out.println("table updated");
		} catch (SQLException e){
			if(e.toString() == "Duplicate entry '4' for key 'store.PRIMARY'") {
				System.out.println(e);
				Statement deleteStatement = con.createStatement();
				deleteStatement.executeQuery("DELETE FROM store WHERE store_id = 4;");
				canRunQueryEight();
			}
		}
		con.commit();
		con.close();
	}

	// Execute Queries
	// database_homework_9
	@Test
	public void canRunQueryNine() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "1234");
		System.out.println("Connected to MySQL DB");
		String updateQuery = "UPDATE store\r\n" + 
				"SET last_update = CURDATE()\r\n" + 
				"WHERE store_id = 4;";

		con.setAutoCommit(false);
		PreparedStatement updatedStore = con.prepareStatement(updateQuery);
		updatedStore.executeUpdate();
		con.commit();

		con.close();
	}

	// Execute Queries
	// database_homework_10
	@Test
	public void canRunQueryTen() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "1234");
		System.out.println("Connected to MySQL DB");
		String deleteQuery = "DELETE FROM store\r\n" + 
				"WHERE store_id = 3;";

		con.setAutoCommit(false);
		PreparedStatement updatedStore = con.prepareStatement(deleteQuery);
		updatedStore.executeUpdate();
		con.commit();

		con.close();
	}
}
