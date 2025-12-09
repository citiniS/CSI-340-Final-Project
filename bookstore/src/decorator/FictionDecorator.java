package decorator;

import book.Book;

public class FictionDecorator extends GenreDecorator {

	public FictionDecorator(Book wrappedBook) {
		super(wrappedBook);
	}

	@Override
	public String getDescription() {
		return wrappedBook.getDescription() + " [Fiction]";
	}
}
