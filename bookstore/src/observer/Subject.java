package observer;

import book.Book;

public interface Subject {
	void attach(Observer observer);
	void detach(Observer observer);
	void notifyObservers(Book book);
}
