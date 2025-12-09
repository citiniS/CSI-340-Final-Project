package factory;

import store.BarnesNobleBookStore;
import store.BookStore;

public class BarnesNobleFactory extends BookStoreFactory {

	public BarnesNobleFactory(String location) {
		super("Barnes & Noble", location);
	}

	@Override
	public BookStore createBookStore() {
		return new BarnesNobleBookStore();
	}
}
