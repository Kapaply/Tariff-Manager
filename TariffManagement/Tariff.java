//
// Assignment 3
// Question: 1 (part 2)
// Written by: Ryan Medlej (40199472) 
//
package TariffManagement;

public class Tariff {

		private String destinationCountry;
		private String originCountry;
		private String productCategory;
		private double minimumTariff;
		
		public Tariff(String destinationCountry, String originCountry, String productCategory, double minimumTariff) {
			
			this.destinationCountry = destinationCountry;
			this.originCountry = originCountry;
			this.productCategory = productCategory;
			this.minimumTariff = minimumTariff;
			
		}
		
		public Tariff() {
			this("N/A","N/A","N/A",0);
		}
		
		public Tariff(Tariff other) {
			this(other.destinationCountry,other.originCountry,other.productCategory,other.minimumTariff);
		}
		
		public String getDestinationCountry() {
			return destinationCountry;
		}
		public String getOriginCountry() {
			return originCountry;
		}
		public String getProductCategory() {
			return productCategory;
		}
		public double getMinimumTariff() {
			return minimumTariff;
		}
		public void setDestinationCountry(String destinationCountry) {
			this.destinationCountry = destinationCountry;
		}
		public void setOriginCountry(String originCountry) {
			this.originCountry = originCountry;
		}
		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}
		public void setMinimumTariff(double minimumTariff) {
			this.minimumTariff = minimumTariff;
		}
		
		@Override
		public Tariff clone() {
		    return new Tariff(destinationCountry, originCountry, productCategory, minimumTariff);
		}

		@Override
		public boolean equals(Object obj) {
		    if (this == obj)
		        return true;
		    if (obj == null || getClass() != obj.getClass())
		        return false;

		    Tariff other = (Tariff) obj;

		    return Math.abs(this.minimumTariff-other.minimumTariff)<0.000001 &&
		            this.getDestinationCountry().equals(other.getDestinationCountry())
		            && this.getOriginCountry().equals(other.getOriginCountry())
		            && this.getProductCategory().equals(other.getProductCategory());
		}

					
					
					
		
		
		public String toString() {
			return this.destinationCountry+","+this.originCountry+","+this.productCategory+","+this.minimumTariff;
		}
		
		
}
