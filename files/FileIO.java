//
// Assignment 3
// Question: 1 (part 1)
// Written by: Ryan Medlej (40199472) 
//
package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {
	
		ArrayList<Product> products = new ArrayList<>();
		
	// For reading: Create the scanner
		public void readData() {
		    Scanner file = null;

		    try {
		    	file = new Scanner(new FileInputStream("TradeData.txt"));

		    } catch (FileNotFoundException fnfex) {
		        System.out.println("File not found!");
		        System.exit(0);
		    }

		    while (file.hasNextLine()) {
		        String line = file.nextLine();

		        try {
		            String[] parts = line.split(",");
		            String product = parts[0].trim();
		            String country = parts[1].trim();
		            String category = parts[2].trim();
		            double initialPrice = Double.parseDouble(parts[3].trim());
		            
		            Product temp = new Product(product, country, category, initialPrice);
		            double newPrice = temp.tariffPrice();
		            Product p = new Product(product, country, category, newPrice);
		            products.add(p);

		      
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid price format on line: " + line);
		        } catch (Exception e) {
		            System.out.println("Unexpected error on line: " + line);
		            e.printStackTrace();
		        }
		    }
		    
		    products.trimToSize();

		    file.close();
		}
	
		public void writeData() {
			PrintWriter output = null;
			
			  try {
				  output = new PrintWriter(new FileOutputStream("UpdatedTradeData.txt"));

			    } catch (FileNotFoundException fnfex) {
			        System.out.println("File not found!");
			        System.exit(0);
			    }
			  sortData();
			  for (Product p: products) {
				  output.println(p.toString());
			  }
			  output.close();
		}
		public void sortData() {
		    for (int i = 0; i < products.size(); i++) {
		        for (int j = i + 1; j < products.size(); j++) {
		            if (products.get(i).getProduct().compareToIgnoreCase(products.get(j).getProduct()) > 0) {
		                // Swap them
		                Product temp = products.get(i);
		                products.set(i, products.get(j));
		                products.set(j, temp);
		            }
		        }
		    }
		}
}

