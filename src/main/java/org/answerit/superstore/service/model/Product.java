/**
 * 
 */
package org.answerit.superstore.service.model;

/**
 * @author monkey
 *
 */
public class Product {
	
	private String id;
	private String name;
	private String description;
	private double price_before_tax;
	private double tax;

	public Product() {
		
	}
	
	public Product(String id, String name, String description, double price_before_tax, double tax) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price_before_tax = price_before_tax;
		this.tax = tax;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice_before_tax() {
		return price_before_tax;
	}
	
	public void setPrice_before_tax(double price_before_tax) {
		this.price_before_tax = price_before_tax;
	}
	
	public double getTax() {
		return tax;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	

}
