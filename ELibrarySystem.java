import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

public class ELibrarySystem {
    private static List<Book> library = new ArrayList<>();

    public static void addBook(String title, String author, String isbn) {
        library.add(new Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    public static void viewBooks() {
        if (library.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in Library:");
            for (Book book : library) {
                System.out.println(book);
            }
        }
    }

    public static void searchBook(String keyword) {
        System.out.println("Search Results:");
        for (Book book : library) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getIsbn().contains(keyword)) {
                System.out.println(book);
            }
        }
    }

    public static void deleteBook(String isbn) {
        Iterator<Book> iterator = library.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nE-Library System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    addBook(title, author, isbn);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    searchBook(keyword);
                    break;
                case 4:
                    System.out.print("Enter ISBN to delete: ");
                    String deleteIsbn = scanner.nextLine();
                    deleteBook(deleteIsbn);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
