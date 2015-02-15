/**
 * 
 */
package org.answerit.superstore.service.model;

/**
 * @author monkey
 *
 */
public class User {
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String deliveryAddress;
	private String billingAddress;
	
	public User() {
		
	}
	
	public User(String id, String email, String firstName, String lastName, 
			String phoneNumber, String deliveryAddress, String billingAddress) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.billingAddress = billingAddress;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}
		
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getBillingAddress(){
		return billingAddress;
	}
	
	public void setBillingAddress(String billingAddress){
		this.billingAddress = billingAddress;
	}
	
	
}
