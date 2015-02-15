/**
 * 
 */
package org.answerit.superstore.service.model;

/**
 * @author monkey
 *
 */
public class BasketItem {
	
	private Product product;
	private int quantity;
	
	public BasketItem() {
		
	}

	public BasketItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product){
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuatity(int quantity) {
		this.quantity = quantity;
	}

}
