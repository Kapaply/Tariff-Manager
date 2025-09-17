//
// Assignment 3
// Question: 1 (part 1)
// Written by: Ryan Medlej (40199472) 
//
package files;

public class Product {
	
	private String product;
	private String country;
	private String category;
	private double initialPrice;
	
	public Product(){
		
		 this("", "", "", 0.0);
	}
	
	public Product(String product,String country,String category,double initialPrice) {
		
		this.product = product;
		this.country = country;
		this.category = category;
		this.initialPrice = initialPrice;
		
	}
	
	public Product(Product other) {
	    this(other.product, other.country, other.category, other.initialPrice);
	}

	public String getProduct() {
		return product;
	}

	public String getCountry() {
		return country;
	}

	public String getCategory() {
		return category;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}
	
	public double tariffPrice() {
	    double tariffRate = 0.0;

	    switch (country) {
	        case "China":
	            tariffRate = 0.25;
	            break;
	        case "USA":
	            if (category.equalsIgnoreCase("Electronics")) {
	                tariffRate = 0.10;
	            }
	            break;
	        case "Japan":
	            if (category.equalsIgnoreCase("Automobiles")) {
	                tariffRate = 0.15;
	            }
	            break;
	        case "India":
	            if (category.equalsIgnoreCase("Agriculture")) {
	                tariffRate = 0.05;
	            }
	            break;
	        case "South Korea":
	            if (category.equalsIgnoreCase("Electronics")) {
	                tariffRate = 0.08;
	            }
	            break;
	        case "Saudi Arabia":
	            if (category.equalsIgnoreCase("Energy")) {
	                tariffRate = 0.12;
	            }
	            break;
	        case "Germany":
	            if (category.equalsIgnoreCase("Manufacturing")) {
	                tariffRate = 0.06;
	            }
	            break;
	        case "Bangladesh":
	            if (category.equalsIgnoreCase("Textile")) {
	                tariffRate = 0.04;
	            }
	            break;
	        case "Brazil":
	            if (category.equalsIgnoreCase("Agriculture")) {
	                tariffRate = 0.09;
	            }
	            break;
	        default:
	            tariffRate = 0.0;
	    }

	    return initialPrice + (initialPrice * tariffRate);
	}
	
	public String toString() {
		return this.product +","+this.country+","+this.category+","+this.initialPrice;
	}


}
