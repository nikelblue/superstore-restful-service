/**
 * 
 */
package org.answerit.superstore.service.model;

/**
 * @author monkey
 *
 */
public class Catagory {
	private String id;
	private String name;
	
	public Catagory() {
		
	}
	
	public Catagory(String id, String name) {
		this.id = id;
		this.name = name;
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

}
