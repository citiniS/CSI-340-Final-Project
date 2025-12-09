package store;

import book.Book;

public class AmazonBookStore extends BookStore {

	@Override
	protected double calculateDiscount(double price, boolean hasMembership) {
		if (hasMembership) {
			return price * 0.10;
		}
		return 0.0;
	}

	@Override
	protected double applyShipping(double price) {
		if (price >= 25.0) {
			return 0.0;
		}
		return 3.99;
	}

	@Override
	protected void finalizeOrder(Book book, double finalPrice) {
		System.out.println("Amazon order confirmed. Estimated delivery: 2 days");
	}

	@Override
	public String getStoreName() {
		return "Amazon";
	}
}
