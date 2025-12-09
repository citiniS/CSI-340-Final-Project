package store;

import book.Book;

public class IndieBooksBookStore extends BookStore {

	@Override
	protected double calculateDiscount(double price, boolean hasMembership) {
		if (hasMembership) {
			return price * 0.15;
		}
		return 0.0;
	}

	@Override
	protected double applyShipping(double price) {
		return 0.0;
	}

	@Override
	protected void finalizeOrder(Book book, double finalPrice) {
		System.out.println("Indie Books order confirmed. Local delivery today!");
	}

	@Override
	public String getStoreName() {
		return "Indie Books";
	}
}
