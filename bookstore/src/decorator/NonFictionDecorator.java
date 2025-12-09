package decorator;

import book.Book;

public class NonFictionDecorator extends GenreDecorator {

	public NonFictionDecorator(Book wrappedBook) {
		super(wrappedBook);
	}

	@Override
	public String getDescription() {
		return wrappedBook.getDescription() + " [Non-Fiction]";
	}

	@Override
	public double getPrice() {
		return wrappedBook.getPrice() + 2.00;
	}
}
