import java.util.*;

class Book {
    String title, author;
    boolean isIssued = false;
    String issuedTo = null;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Member {
    String name, memberId;

    Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    void issueBook(String title, Member member) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isIssued) {
                book.isIssued = true;
                book.issuedTo = member.name;
                System.out.println("Issued '" + title + "' to " + member.name);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isIssued) {
                System.out.println("Book '" + title + "' returned by " + book.issuedTo);
                book.isIssued = false;
                book.issuedTo = null;
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Member m1 = new Member("Siyabonga", "M001");
        lib.addBook(new Book("Java Basics", "John Doe"));

        lib.issueBook("Java Basics", m1);
        lib.returnBook("Java Basics");
    }
}
