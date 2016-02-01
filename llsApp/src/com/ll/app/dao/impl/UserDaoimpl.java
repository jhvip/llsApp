package com.ll.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ll.app.dao.UserDao;
import com.ll.app.entity.User;
import com.ll.app.utils.JdbcUtils;

public class UserDaoimpl implements UserDao{

	@Override
	public boolean userRegist(User user) {
		String sql = "insert into User(userName, password, registTime) "
				+ "values(?,?,?);";
		Connection connection = JdbcUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRegistTime());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtils.close(null, preparedStatement, connection);
		}	
		return true;
	}

}
