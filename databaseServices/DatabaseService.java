package databaseServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.GreatestSportsMoment;

public class DatabaseService {

	// connect to the database

	String dbURL = "jdbc:mysql://localhost:3306/greatest_sports_moments_in_history";
	String user = "root";
	String password = "hybernate2015#";

	@SuppressWarnings("null")
	public int deleteOne(int id) throws SQLException {

		int numberOfRowsAffected = 0;

		// database work

		Connection con = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;

		try {
			con = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successiful " + dbURL + " user " + user + " password " + password);

			// create a SQL statement

			stmt = con.prepareStatement("DELETE FROM sports_moment WHERE id = ?");
			stmt.setInt(1, id);

			// execute statement

			rowsAffected = stmt.executeUpdate();

			// success message, if the number of rowsAffected > 0

			System.out.print("rowsAffected = " + rowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Error communicating with the database");
			e.printStackTrace();
		} finally {
			// close the connection

			if (con == null) {
				con.close();
			}

			if (stmt == null) {
				stmt.close();
			}

		}

		return numberOfRowsAffected;
	}

	@SuppressWarnings("null")
	public int insertOne(GreatestSportsMoment gsm) throws SQLException {

		int numberOfRowsAffected = 0;

		// database work

		Connection con = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;

		try {
			con = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successiful " + dbURL + " user " + user + " password " + password);

			// create a SQL statement

			stmt = con.prepareStatement("INSERT INTO sports_moment VALUES(?,?,?,?,?,?)");
			stmt.setInt(1, gsm.getId());
			stmt.setString(2, gsm.getSporting_moment());
			stmt.setString(3, gsm.getMoment_description());
			stmt.setString(4, gsm.getMoment_year());
			stmt.setString(5, gsm.getTeam_or_individual_name_outstanding());
			stmt.setInt(6, gsm.getMoment_rating());

			// execute statement

			rowsAffected = stmt.executeUpdate();

			// success message, if the number of rowsAffected > 0

			System.out.print("rowsInserted = " + rowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Error communicating with the database");
			e.printStackTrace();
		} finally {
			// close the connection

			if (con == null) {
				con.close();
			}

			if (stmt == null) {
				stmt.close();
			}

		}
		return numberOfRowsAffected;
	}

	@SuppressWarnings("null")
	public ArrayList<GreatestSportsMoment> readAll() throws SQLException {

		ArrayList<GreatestSportsMoment> everyone = new ArrayList<GreatestSportsMoment>();
		GreatestSportsMoment gsm;
		// database work

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successiful " + dbURL + " user " + user + " password " + password);

			// create a SQL statement

			stmt = con.createStatement();

			// execute the statement

			rs = stmt.executeQuery("SELECT * FROM sports_moment");

			// process the rows in the result set
			while (rs.next()) {
				System.out.print("Id = " + rs.getInt("Id") + "sporting_moment = " + rs.getString("sporting_moment")
						+ "moment_description = " + rs.getString("moment_description") + "moment_year = "
						+ rs.getString("moment_year") + "team_or_individual_name_outstanding = "
						+ rs.getString("team_or_individual_name_outstanding") + "moment_rating = "
						+ rs.getInt("moment_rating"));
				gsm = new GreatestSportsMoment(rs.getInt("Id"), rs.getString("sporting_moment"),
						rs.getString("moment_description"), rs.getString("moment_year"),
						rs.getString("team_or_individual_name_outstanding"), rs.getInt("moment_rating"));
				everyone.add(gsm);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Error communicating with the database");
			e.printStackTrace();
		} finally {
			// close the connection

			if (con == null) {
				con.close();
			}

			if (stmt == null) {
				stmt.close();
			}

			if (rs == null) {
				rs.close();
			}

		}

		return everyone;
	}

	@SuppressWarnings("null")
	public int UpdateOne(int id, GreatestSportsMoment gsm) throws SQLException {

		int numberOfRowsAffected = 0;

		// database work

		Connection con = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;

		try {
			con = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successiful " + dbURL + " user " + user + " password " + password);

			// create a SQL statement

			stmt = con.prepareStatement(
					"UPDATE sports_moment SET sporting_moment = ?, moment_description = ? , moment_year = ?, team_or_individual_name_outstanding = ?, moment_rating = ? WHERE id = ?");

			stmt.setString(1, gsm.getSporting_moment());
			stmt.setString(2, gsm.getMoment_description());
			stmt.setString(3, gsm.getMoment_year());
			stmt.setString(4, gsm.getTeam_or_individual_name_outstanding());
			stmt.setInt(5, gsm.getMoment_rating());
			stmt.setInt(6, gsm.getId());

			// execute statement

			rowsAffected = stmt.executeUpdate();

			// success message, if the number of rowsAffected > 0

			System.out.print("rowsUpdated = " + rowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Error communicating with the database");
			e.printStackTrace();
		} finally {
			// close the connection

			if (con == null) {
				con.close();
			}

			if (stmt == null) {
				stmt.close();
			}

		}

		return numberOfRowsAffected;

	}

}
