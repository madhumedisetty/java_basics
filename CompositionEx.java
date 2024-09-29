// Author class
class Author {
    private String name;

    // Constructor
    public Author(String name) {
        this.name = name;
    }

    // Method to get the author's name
    public String getName() {
        return name;
    }
}

// Book class
class Book {
    private String title;
    private Author author; // Composition: Book has an Author

    // Constructor
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author.getName());
    }
}

// Main class
public class CompositionEx {
    public static void main(String[] args) {
        // Create an Author object
        Author author = new Author("J.K. Rowling");

        // Create a Book object, passing the Author object
        Book book = new Book("Harry Potter", author);

        // Display book details
        book.displayBookInfo();
    }
}
