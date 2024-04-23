package com.PricingModule;

public class PricingModule {

	private String user;

		private long id;
		private String Gallons;
		private String Address;
		private String Date;
		private String Price;
		private String Due;

		public PricingModule(String Gallons, String Address, String Date, String Price, String Due) {
			this.Gallons = Gallons;
			this.Address = Address;
			this.Date = Date;
			this.Price = Price;
			this.Due = Due;
		}

		public PricingModule() {
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getGallons() {
			return Gallons;
		}

		public void setGallons(String Gallons) {
			this.Gallons = Gallons;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String Address) {
			this.Address = Address;
		}

		public String getDate() {
			return Date;
		}

		public void setDate(String Date) {
			this.Date = Date;
		}

		public String getPrice() {
			return Price;
		}

		public void setPrice(String Price) {
			this.Price = Price;
		}

		public String getDue() {
			return Due;
		}

		public void setDue(String Due) {
			this.Due = Due;
		}

		public String toString() {
			return "Quote{" +
					"id=" + id +
					", Gallons='" + Gallons + '\'' +
					", Address='" + Address + '\'' +
					", Date='" + Date + '\'' +
					", Price='" + Price + '\'' +
					", Due='" + Due + '\'' +
					'}';
		}

}