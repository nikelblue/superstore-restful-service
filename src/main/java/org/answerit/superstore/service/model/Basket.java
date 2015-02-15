package org.answerit.superstore.service.model;

import java.util.Collection;

public class Basket {
	
	private String id;
	private Collection<BasketItem> basketItems;
	
	public Basket() {
		
	}
	
	public Basket(String id, Collection<BasketItem> basketItems) {
		this.id = id;
		this.basketItems = basketItems;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public Collection<BasketItem> getBasketItems() {
		return basketItems;
	}
	
	public void setBasketItems(Collection<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}
 


}
