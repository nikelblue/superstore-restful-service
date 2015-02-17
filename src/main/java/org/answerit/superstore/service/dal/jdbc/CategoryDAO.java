package org.answerit.superstore.service.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.answerit.superstore.service.model.Category;

/**
 * 
 * @author nikelblue
 *
 */
public class CategoryDAO {
	private final Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public void insertOrUpdateCategory(Category category) throws SQLException {
		if(category == null)
			throw new IllegalArgumentException("NULL category not allowed");
		if(category.getId() == null)
			insertCategory(category);
		updateCategory(category);
	}

	/**
	 * 
	 * @param category
	 * @throws SQLException
	 * @see {@linkplain http://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-last-insert-id.html}
	 */
	private void insertCategory(Category category) throws SQLException {
		final String sql = "INSERT INTO CATEGORY (name) VALUES (?)";
		try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, category.getName());
			int inserted = ps.executeUpdate();
			if (inserted != 1)
				throw new SQLException("Category not inserted: " + category);

			try (ResultSet rs = ps.getGeneratedKeys();) {
				if (rs.next()) {
					category.setId(rs.getString(1));
				} else {
					throw new SQLException("No ID assigned for category: " + category);
				}
			}
		}
	}

	/**
	 * 
	 * @param category
	 * @throws SQLException
	 * @see http://tutorials.jenkov.com/jdbc/preparedstatement.html
	 */
	private void updateCategory(Category category) throws SQLException {
		final String sql = "UPDATE CATEGORY SET name = ? WHERE id = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, category.getName());
			ps.setLong(2, Long.parseLong(category.getId()));

			//TODO: Write your code here
		}
	}

	/**
	 * 
	 * @param id
	 * @return 
	 * 		<code>null</code> if the category does not exists or the category otherwise.
	 * @see {@link http://tutorials.jenkov.com/jdbc/preparedstatement.html}
	 *
	 */
	public Category getCategory(String id) throws SQLException {
		final String sql = "SELECT name FROM category WHERE id = ?";
		//TODO: write your code here
		return null; //return the category here
	}

	/**
	 * 
	 * @param id
	 * @throws SQLException
	 * @return
	 * 		<code>true</code> if the category has been successfully deleted or
	 * 		<code>false</code> otherwise (i.e. category didn't exist.
	 * @see {@link http://www.mkyong.com/jdbc/jdbc-preparestatement-example-delete-a-record/}
	 */
	public boolean deleteCategory(String id) throws SQLException {
		final String sql = "DELETE ..."; //TODO: write DELETE statement here
		//TODO: write your code here
		return false; //TODO: return the correct value
	}
}
