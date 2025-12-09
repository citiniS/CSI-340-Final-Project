package factory;

import store.AmazonBookStore;
import store.BookStore;

public class AmazonFactory extends BookStoreFactory {

	public AmazonFactory(String location) {
		super("Amazon", location);
	}

	@Override
	public BookStore createBookStore() {
		return new AmazonBookStore();
	}
}
