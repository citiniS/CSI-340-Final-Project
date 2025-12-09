package observer;

import book.Book;

public class Customer implements Observer {
	private String name;
	private String email;

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public void update(Book book) {
		System.out.println("Notification to " + name + " (" + email + "): " 
				+ book.getDescription() + " is back in stock!");
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
