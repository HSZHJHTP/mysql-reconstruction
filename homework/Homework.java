package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcUtil.JdbcUtil;

import org.junit.Test;

public class Homework {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		connection = JdbcUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "CREATE TABLE teacher(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),age INT,GENDER VARCHAR(20),dateOfBirth VARCHAR(20))";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
	}

	@Test
	public void insert() {
		Connection connection = null;
		Statement statement = null;
		connection = JdbcUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO teacher(NAME) VALUES('小红');";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
	}

	@Test
	public void select() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = JdbcUtil.getConnection();
			statement = connection.createStatement();
			String teacherName = "小红";
			String sql = "SELECT * FROM teacher where name='" + teacherName
					+ "';";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				System.out.print("id:" + id + "\t");
				System.out.print("name:" + name);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
	}

	@Test
	public void delete() {
		Connection connection = null;
		Statement statement = null;
		connection = JdbcUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM teacher WHERE id=1";
			int result = statement.executeUpdate(sql);
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}

	}
	@Test
	public void update(){
		Connection connection = null;
		Statement statement = null;
		connection = JdbcUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "UPDATE teacher SET gender='男' WHERE id=2";
			int result = statement.executeUpdate(sql);
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}

	}
	
}
