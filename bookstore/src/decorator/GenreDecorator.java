package decorator;

import book.Book;

public abstract class GenreDecorator implements Book {
	protected Book wrappedBook;

	public GenreDecorator(Book wrappedBook) {
		this.wrappedBook = wrappedBook;
	}

	@Override
	public String getDescription() {
		return wrappedBook.getDescription();
	}

	@Override
	public double getPrice() {
		return wrappedBook.getPrice();
	}
}
