package factory;

import store.IndieBooksBookStore;
import store.BookStore;

public class IndieBooksFactory extends BookStoreFactory {

	public IndieBooksFactory(String location) {
		super("Indie Books", location);
	}

	@Override
	public BookStore createBookStore() {
		return new IndieBooksBookStore();
	}
}
