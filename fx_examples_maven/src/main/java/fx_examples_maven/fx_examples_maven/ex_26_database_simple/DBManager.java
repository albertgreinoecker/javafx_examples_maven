package fx_examples_maven.fx_examples_maven.ex_26_database_simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	
	Connection con;
	
	public DBManager() throws SQLException {
		/*
        String jdbcUrl = "jdbc:mysql://localhost:3306/uni";
        String username = "root";
        String password = "root";
        con = DriverManager.getConnection(jdbcUrl, username, password);
        */
		String jdbcUrl = "jdbc:sqlite:src/main/resources/db/uni.sqlite";
        con = DriverManager.getConnection(jdbcUrl);
	}
	
	public void close() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Professor get(String persNr) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Professoren WHERE persNr = ?");
	    stmt.setString(1, persNr);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
	        String name = rs.getString("name");
	        String rang = rs.getString("rang");
	        String raum = rs.getString("raum");
	        return new Professor(persNr, name, rang, raum);
	    }
	    return null;
	}
	
	public List<Professor> getAll() throws SQLException {
		List<Professor> professors = new ArrayList<>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Professoren");
	    ResultSet rs = stmt.executeQuery();
	    while (rs.next()) {
	        String persNr = rs.getString("persNr");
	        String name = rs.getString("name");
	        String rang = rs.getString("rang");
	        String raum = rs.getString("raum");
	        professors.add(new Professor(persNr, name, rang, raum));
	    }
	    return professors;
	}
	
	public void insert(Professor p) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("INSERT INTO Professoren (persNr, name, rang, raum) VALUES (?, ?, ?, ?)");
		stmt.setString(1, p.getPersNr());
		stmt.setString(2, p.getName());
		stmt.setString(3, p.getRang());
		stmt.setString(4, p.getRaum());
		stmt.executeUpdate();
	}
	
	public void delete(String persNr) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("DELETE FROM Professoren WHERE persNr = ?");
		stmt.setString(1, persNr);
		stmt.executeUpdate();
	}
	
	public void update(Professor p) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("UPDATE Professoren SET name = ?, rang = ?, raum = ? WHERE persNr = ?");
		stmt.setString(1, p.getName());
		stmt.setString(2, p.getRang());
		stmt.setString(3, p.getRaum());
		stmt.setString(4, p.getPersNr());
		stmt.executeUpdate();
	}

}
