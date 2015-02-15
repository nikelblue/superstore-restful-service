/**
 * 
 */
package org.answerit.superstore.service.model;

import org.answerit.superstore.service.model.Product;
import org.junit.Test;

/**
 * @author monkey
 *
 */
public class ProductTest {

	@Test
	public void test() {
		Product myProduct = new Product("Prod-101", "book", "Core Java", 20, 0.12);
		
		System.out.println(myProduct.getDescription());
	}

}
