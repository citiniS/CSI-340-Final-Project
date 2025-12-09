package store;

import book.Book;

public class BarnesNobleBookStore extends BookStore {

	@Override
	protected double calculateDiscount(double price, boolean hasMembership) {
		if (hasMembership) {
			return price * 0.10;
		} else if (price > 50.0) {
			return price * 0.05;
		}
		return 0.0;
	}

	@Override
	protected double applyShipping(double price) {
		if (price >= 40.0) {
			return 0.0;
		}
		return 4.99;
	}

	@Override
	protected void finalizeOrder(Book book, double finalPrice) {
		System.out.println("Barnes & Noble order confirmed. Estimated delivery: 3-5 days");
	}

	@Override
	public String getStoreName() {
		return "Barnes & Noble";
	}
}
