package decorator;

import book.Book;

public class SciFiDecorator extends GenreDecorator {

	public SciFiDecorator(Book wrappedBook) {
		super(wrappedBook);
	}

	@Override
	public String getDescription() {
		return wrappedBook.getDescription() + " [Sci-Fi]";
	}

	@Override
	public double getPrice() {
		return wrappedBook.getPrice() + 1.50;
	}
}
