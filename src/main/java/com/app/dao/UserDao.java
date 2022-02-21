package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.model.User;
import com.app.utils.JDBCConnection;

public class UserDao {

	private static final String SELECT_USER_BY_ID = "select id, username, password from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USER_BY_ID = "delete from users where id = ?;";
	private static final String UPDATE_USER = "update users set first_name = ?, last_name = ?, username= ?, password = ? where id = ?;";

	public int signupUser(User user) throws ClassNotFoundException {
		String INSERT_USERS_QUERY = "INSERT INTO users (first_name, last_name, username, password, is_admin) VALUES "
				+ " (?, ?, ?, ?, ?);";
		int result = 0;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_QUERY)) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setBoolean(5, user.isAdmin());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			JDBCConnection.printSQLException(e);
		}
		return result;
	}

	public User select(long uid) {
		User user = null;
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setLong(1, uid);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				boolean isAdmin = rs.getBoolean("is_admin");
				user = new User(id, firstName, lastName, username, password, isAdmin);
			}
		} catch (SQLException exception) {
			JDBCConnection.printSQLException(exception);
		}
		return user;
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				boolean isAdmin = rs.getBoolean("is_admin");
				User user = new User(id, firstName, lastName, username, password, isAdmin);
				users.add(user);
			}
		} catch (SQLException exception) {
			JDBCConnection.printSQLException(exception);
		}
		return users;
	}
}
