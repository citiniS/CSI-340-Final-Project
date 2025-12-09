package factory;

import store.BookStore;

public abstract class BookStoreFactory {
	protected String storeName;
	protected String location;

	public BookStoreFactory(String storeName, String location) {
		this.storeName = storeName;
		this.location = location;
	}

	public abstract BookStore createBookStore();

	public String getStoreName() {
		return storeName;
	}

	public String getLocation() {
		return location;
	}
}
