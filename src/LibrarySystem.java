import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is already available.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", available=" + available +
                '}';
    }
}

class User {
    private String name;
    private String address;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println("Book added to user's borrowed list.");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println("Book removed from user's borrowed list.");
        } else {
            System.out.println("User did not borrow this book.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed books by " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", 2020);
        Book book2 = new Book("Data Structures", "Jane Smith", 2018);

        User user1 = new User("Alice", "123 Main St");
        User user2 = new User("Bob", "456 Oak St");

        user1.borrowBook(book1);
        user2.borrowBook(book2);

        user1.displayBorrowedBooks();
        user2.displayBorrowedBooks();

        user1.returnBook(book1);
        user2.returnBook(book2);

        user1.displayBorrowedBooks();
        user2.displayBorrowedBooks();
    }
}
