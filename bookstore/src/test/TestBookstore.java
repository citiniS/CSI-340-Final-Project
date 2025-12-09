package test;

import book.*;
import decorator.*;
import observer.*;
import store.*;
import factory.*;

public class TestBookstore {

	public static void testFactoryPattern() {
		System.out.println("=== Testing Factory Pattern ===");
		
		BookStoreFactory amazonFactory = new AmazonFactory("Seattle, WA");
		BookStoreFactory barnesFactory = new BarnesNobleFactory("New York, NY");
		BookStoreFactory indieFactory = new IndieBooksFactory("Portland, OR");
		
		BookStore amazon = amazonFactory.createBookStore();
		BookStore barnesNoble = barnesFactory.createBookStore();
		BookStore indie = indieFactory.createBookStore();
		
		System.out.println("Created: " + amazon.getStoreName());
		System.out.println("Created: " + barnesNoble.getStoreName());
		System.out.println("Created: " + indie.getStoreName());
		System.out.println();
	}

	public static void testDecoratorPattern() {
		System.out.println("=== Testing Decorator Pattern ===");
		
		Book book1 = new ConcreteBook("The Great Gatsby", "F. Scott Fitzgerald", 15.99);
		Book book2 = new ConcreteBook("Sapiens", "Yuval Noah Harari", 24.99);
		Book book3 = new ConcreteBook("Dune", "Frank Herbert", 18.99);
		
		Book fictionBook = new FictionDecorator(book1);
		Book nonFictionBook = new NonFictionDecorator(book2);
		Book sciFiBook = new SciFiDecorator(book3);
		
		System.out.println(fictionBook.getDescription() + " - $" + fictionBook.getPrice());
		System.out.println(nonFictionBook.getDescription() + " - $" + nonFictionBook.getPrice());
		System.out.println(sciFiBook.getDescription() + " - $" + sciFiBook.getPrice());
		System.out.println();
	}

	public static void testObserverPattern() {
		System.out.println("=== Testing Observer Pattern ===");
		
		BookStore amazon = new AmazonBookStore();
		
		Customer alice = new Customer("Alice", "alice@email.com");
		Customer bob = new Customer("Bob", "bob@email.com");
		
		amazon.attach(alice);
		amazon.attach(bob);
		
		Book book = new FictionDecorator(new ConcreteBook("1984", "George Orwell", 13.99));
		System.out.println("Adding book to store...");
		amazon.addBook(book);
		System.out.println();
	}

	public static void testTemplateMethod() {
		System.out.println("=== Testing Template Method Pattern ===");
		
		Book book = new SciFiDecorator(new ConcreteBook("Foundation", "Isaac Asimov", 16.99));
		
		BookStore amazon = new AmazonBookStore();
		BookStore barnesNoble = new BarnesNobleBookStore();
		BookStore indie = new IndieBooksBookStore();
		
		amazon.processSale(book, true);
		barnesNoble.processSale(book, false);
		indie.processSale(book, true);
		System.out.println();
	}

	public static void testAllPatternsTogether() {
		System.out.println("=== Testing All Patterns Together ===");
		
		// Factory Pattern
		BookStoreFactory factory = new AmazonFactory("Seattle, WA");
		BookStore store = factory.createBookStore();
		
		// Observer Pattern
		Customer customer = new Customer("Charlie", "charlie@email.com");
		store.attach(customer);
		
		// Decorator Pattern
		Book book = new SciFiDecorator(
				new FictionDecorator(
						new ConcreteBook("Neuromancer", "William Gibson", 14.99)
				)
		);
		
		System.out.println("Adding book: " + book.getDescription());
		store.addBook(book);
		
		// Template Method Pattern
		store.processSale(book, true);
		System.out.println();
	}

	public static void main(String[] args) {
		testFactoryPattern();
		testDecoratorPattern();
		testObserverPattern();
		testTemplateMethod();
		testAllPatternsTogether();
		
		System.out.println("All tests complete!");
	}
}
