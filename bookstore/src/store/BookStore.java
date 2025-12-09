package store;

import book.Book;
import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;

public abstract class BookStore implements Subject {
	protected List<Book> inventory;
	protected List<Observer> observers;

	public BookStore() {
		this.inventory = new ArrayList<>();
		this.observers = new ArrayList<>();
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Book book) {
		for (Observer observer : observers) {
			observer.update(book);
		}
	}

	// Template Method Pattern
	public final void processSale(Book book, boolean hasMembership) {
		System.out.println("\n--- Processing Sale at " + getStoreName() + " ---");
		System.out.println("Book: " + book.getDescription());
		
		double originalPrice = book.getPrice();
		System.out.println("Original Price: $" + String.format("%.2f", originalPrice));
		
		double discount = calculateDiscount(originalPrice, hasMembership);
		System.out.println("Discount: $" + String.format("%.2f", discount));
		
		double shipping = applyShipping(originalPrice);
		System.out.println("Shipping: $" + String.format("%.2f", shipping));
		
		double finalPrice = originalPrice - discount + shipping;
		System.out.println("Final Price: $" + String.format("%.2f", finalPrice));
		
		finalizeOrder(book, finalPrice);
	}

	protected abstract double calculateDiscount(double price, boolean hasMembership);
	protected abstract double applyShipping(double price);
	protected abstract void finalizeOrder(Book book, double finalPrice);
	public abstract String getStoreName();

	public void addBook(Book book) {
		inventory.add(book);
		notifyObservers(book);
	}

	public List<Book> getInventory() {
		return inventory;
	}
}
