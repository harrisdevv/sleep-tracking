package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.app.model.LoginBean;
import com.app.utils.JDBCConnection;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select id, is_admin from users where username = ? and password = ? ")) {
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			long uid = rs.getLong("id");
			boolean isAdmin = rs.getBoolean("is_admin");
			loginBean.setAdmin(isAdmin);
			loginBean.setUid(uid);
		} catch (SQLException e) {
			JDBCConnection.printSQLException(e);
		}
		return status;
	}
}
