//
// Assignment 3
// Question: 1 (part 2)
// Written by: Ryan Medlej (40199472) 
//
package TariffManagement;

import java.util.NoSuchElementException;


public class TariffList implements TariffPolicy{

	
	private TariffNode head;
	private TariffNode tail;
	private int size;
	
	
	public TariffList() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	public TariffList(TariffList other) {
	    if (other.head == null) {
	        this.head = null;
	        this.tail = null;
	        this.size = 0;
	    } else {
	        this.head = new TariffNode(other.head.data.clone(), null);
	        TariffNode currentOther = other.head.link;
	        TariffNode currentThis = this.head;
	        
	        while (currentOther != null) {
	            TariffNode newNode = new TariffNode(currentOther.data.clone(), null);
	            currentThis.link = newNode;
	            currentThis = newNode;
	            currentOther = currentOther.link;
	        }	        
	        this.tail = currentThis;
	        this.size = other.size;
	    }
	}

	
	public int getSize() {
		return size;
	}

	
	public void addToStart(Tariff value) {
	    // Check for duplicates before adding
	    if (contains(value.getOriginCountry(), value.getDestinationCountry(), value.getProductCategory())) {
	        return; // Don't add it if it already exists in the list
	    }

	    // No duplicate found → safe to add
	    TariffNode newNode = new TariffNode(value, head);
	    head = newNode;
	    size++;

	    // Adjust tail if it's the first element
	    if (size == 1) {
	        tail = head;
	    }
	}

	
	
	public void insertAtIndex(Tariff value, int index) { 
	    if (index < 0 || index > size) {  
	        throw new NoSuchElementException("Invalid index: " + index);
	    }

	   
	    if (index == 0) {
	        addToStart(value);
	        return;
	    }

	    TariffNode position = head;
	    int count = 0;

	    while (count < index - 1) {
	        position = position.link;
	        count++;
	    }

	    TariffNode newNode = new TariffNode(value, position.link);
	    position.link = newNode;

	    if (position == tail) {
	        tail = newNode;
	    }

	    size++;
	}

	
	public void removeAtIndex(int index) {
	    if (head == null) {
	        System.out.println("The list is empty");
	       
	    }

	    if (index < 0 || index >= size) {
	        throw new NoSuchElementException("Invalid index: " + index);
	    }

	    TariffNode removedNode;

	    // Special case: removing the head
	    if (index == 0) {
	      deleteFromStart();
	    } else {
	        TariffNode prev = head;
	        for (int i = 0; i < index - 1; i++) {
	            prev = prev.link;
	        }

	        removedNode = prev.link;
	        prev.link = removedNode.link;

	        // Special case: removing the tail
	        if (removedNode == tail) {
	            tail = prev;
	        }
	    }

	    size--;
	    
	}

	public Tariff deleteFromStart() {
	    if (head == null) {
	        throw new NoSuchElementException("Cannot delete from an empty list.");
	    } else {
	        Tariff value = head.data;
	        head = head.link;
	        size--;

	        if (head == null) {
	            tail = null;
	        }

	        return value;
	    }
	}
	
	public void replaceAtIndex(Tariff object, int index) {
	    if (head == null) {
	        System.out.println("The list is empty");
	        return;
	       
	    }

	    if (index < 0 || index >= size) {
	       return;
	    }
	    TariffNode position = head;
	    for (int i = 0; i < index; i++) {
	        position = position.link;
	    }

	    position.data = object;
	}
	   
	    
	public Tariff find(String origin, String destination, String category) {
	    TariffNode position = head;
	    int iterations = 0;

	    while (position != null) {
	        iterations++;
	        Tariff data = position.data;

	        if (data.getOriginCountry().equals(origin) &&
	            data.getDestinationCountry().equals(destination) &&
	            data.getProductCategory().equals(category)) {

	            System.out.println("Iterations made: " + iterations);
	            return data;  
	        }
	        position = position.link;
	    }

	    System.out.println("Iterations made: " + iterations);
	    return null;
	}
	public boolean contains(String origin, String destination, String category) {
	    TariffNode position = head;

	    while (position != null) {
	        Tariff data = position.data;

	        if (data.getOriginCountry().equals(origin) &&
	            data.getDestinationCountry().equals(destination) &&
	            data.getProductCategory().equals(category)) {
	            return true;
	        }

	        position = position.link;
	    }

	    return false;
	}


	public boolean equals(TariffList otherList) {
	 
	    if (this.size != otherList.size) {
	        return false;
	    }

	    TariffNode current1 = this.head;
	    TariffNode current2 = otherList.head;

	    while (current1 != null && current2 != null) {
	        if (!current1.getData().equals(current2.getData())) {
	            return false;  // Tariffs don't match
	        }

	        current1 = current1.link;
	        current2 = current2.link;
	    }

	    return true;
	}

		
	
	public void display() {
	    if (head == null) {
	        System.out.println("The list is empty.");
	        return;
	    }

	    TariffNode position = head;

	    while (position != null) {
	        System.out.println(position.data.toString());  
	        position = position.link;
	    }

	    System.out.println("");
	}

	
	
	
	
	

	
	
	
	
	

	@Override
	public String evaluateTrade(double proposedTariff, double minimumTariff) {
		
		double bounds = minimumTariff*0.20;
		
		if (proposedTariff >=(minimumTariff)) {
			return "Accepted";
					
		}
		
		if (proposedTariff<(minimumTariff)&&proposedTariff>=(minimumTariff-bounds)) {
			return "Conditionally Accepted";
					
		}
		
		else return "Rejected";
		
	
	}
	
	
	private class TariffNode implements Cloneable{

		private Tariff data;
		private TariffNode link;
		
		TariffNode (){
			this.data = data;
			this.link = link;
		}
		
		TariffNode (Tariff data, TariffNode link) {
			this.data = data;
			this.link = link;			
		}
		
		public TariffNode(TariffNode other) {
		    if (other == null) {
		        this.data = null;
		        this.link = null;
		    } else {
		        this.data = other.data.clone(); // deep copy of Tariff
		        this.link = other.link;
		    }
		}

		
		public String toString() {
			return "Data is: " +data;
		}
		
		public boolean equals (Object otherObject) {
			TariffNode otherData = (TariffNode) otherObject;
			return this.data.equals(otherData.data);
		}
		
		public Object clone() throws CloneNotSupportedException {
			TariffNode copy = (TariffNode) super.clone();
			copy.data = (Tariff) this.data.clone();
			copy.link = (TariffNode) this.link.clone();
			
			return copy;
		
		}

		public Tariff getData() {
			return data;
		}

		public TariffNode getLink() {
			return link;
		}

		public void setData(Tariff data) {
			this.data = data;
		}

		public void setLink(TariffNode link) {
			this.link = link;
		}
}

}
