package org.answerit.superstore.service.dal.jdbc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class SimpleJdbcConnectionPoolIntegrationTest {

	@Test
	public void test() throws Exception {
		SimpleJdbcConnectionPool connectionPool = new SimpleJdbcConnectionPool();
		Connection connection = connectionPool.getConnection();
		assertNotNull("Conection must not be null", connection);
		assertFalse(connection.isClosed());
		
		connectionPool.closeConnection(connection);
		assertTrue(connection.isClosed());
	}

}
