/**
 * 
 */
package org.answerit.superstore.service.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author monkey
 *
 */
public class SimpleJdbcConnectionPool {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String dbUrl = "jdbc:mysql://localhost/superstore";
		String dbClass = "com.mysql.jdbc.Driver";
		String username = "superstore";
		String password = "superstore";

		Class.forName(dbClass);
		Connection connection = DriverManager.getConnection(dbUrl,username, password);

		return connection;
	}

	public void closeConnection(Connection connection) throws SQLException {
		if(connection != null && !connection.isClosed())
			connection.close();
	}

}
