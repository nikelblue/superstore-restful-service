package org.answerit.superstore.service.dal.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import org.answerit.superstore.service.model.Category;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author nikelblue
 *
 */
public class CategoryDAOIntegrationTest {
	private static SimpleJdbcConnectionPool connectionPool;

	private CategoryDAO categoryDAO;

	private Connection connection;

	private Category category;

	@BeforeClass
	public static void beforeAllTests() {
		connectionPool = new SimpleJdbcConnectionPool();
	}

	@Before
	public void beforeEachTest() throws Exception {
		connection = connectionPool.getConnection();
		categoryDAO = new CategoryDAO(connection);
	}

	@After
	public void afterEachTest() throws Exception {
		categoryDAO = null;
		connectionPool.closeConnection(connection);
	}

	@Test
	public void testCategoryDAO_NormalOperations() throws Exception {

		//Generate pseudo-unique strings to be sure the test won't interfere with
		//existing values
		String name1 = UUID.randomUUID().toString();
		String name2 = UUID.randomUUID().toString();

		category = new Category();
		category.setName(name1);

		//Test insert
		categoryDAO.insertOrUpdateCategory(category);
		String id = category.getId();
		assertNotNull("Expected category id to be autoatically set after insertion", id);
		assertFalse("Expected generated category id to not be empty",
				id.trim().length() == 0);

		//Check inserted category
		Category actualCategory = categoryDAO.getCategory(category.getId());
		assertNotNull("Inserted category does not exist", actualCategory);
		assertEquals("Inserted category name does not match",
				category.getName(), actualCategory.getName());

		//Test update
		category.setName(name2);
		categoryDAO.insertOrUpdateCategory(category);

		//Check updated category
		actualCategory = categoryDAO.getCategory(category.getId());
		assertNotNull("Updated category does not exist", actualCategory);
		assertEquals("Updated category name does not match",
				category.getName(), actualCategory.getName());

		//Check delete category
		boolean deleted = categoryDAO.deleteCategory(category.getId());
		assertTrue("Unexpected reply for deleteCategory(validId)", deleted);

		//Check deleted category
		actualCategory = categoryDAO.getCategory(category.getId());
		Assert.assertNull("Expected category to be deleted: " + category, actualCategory);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCategoryDAO_NullConnection() {
		categoryDAO = new CategoryDAO(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertOrUpdate_NullCategory() throws Exception{
		categoryDAO.insertOrUpdateCategory(null);
	}

	@Test(expected = SQLException.class)
	public void testInsertOrUpdate_NullCategoryName() throws Exception{
		categoryDAO.insertOrUpdateCategory(new Category());
	}

	@Test(expected = SQLException.class)
	public void testInsertOrUpdate_DuplicateCategoryName() throws Exception {
		///Generate pseudo-unique strings to be sure the test won't interfere with
		//existing values
		String name = UUID.randomUUID().toString();

		Category category1 = new Category(null, name);
		Category category2 = new Category(null, name);

		categoryDAO.insertOrUpdateCategory(category1);
		categoryDAO.insertOrUpdateCategory(category2); //this should fail
	}

	@Test
	public void testGet_UnexistentCategory() throws Exception{
		Category actualCategory = categoryDAO.getCategory("-1");
		assertNull("Expected null category", actualCategory);
	}

	@Test
	public void testDelete_UnexistentCategory() throws Exception{
		boolean deleted = categoryDAO.deleteCategory("-1");
		assertFalse("Unexpected reply for deleteCategory(unexistentId)", deleted);
	}
}
