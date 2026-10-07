package org.example.library;

import org.example.library.model.Book;
import org.example.library.model.Member;
import org.example.library.model.Transaction;
import org.example.library.service.BookService;
import org.example.library.service.MemberService;
import org.example.library.service.NotificationService;
import org.example.library.service.TransactionService;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);

    private static final BookService bookService = new BookService();
    private static final MemberService memberService = new MemberService();
    private static final TransactionService transactionService =
            new TransactionService();
    private static final NotificationService notificationService =
            new NotificationService();

    // Librarian login credentials
    private static final String LIBRARIAN_USERNAME = "admin";
    private static final String LIBRARIAN_PASSWORD = "admin123";

    public static void main(String[] args) {

        addSampleData();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("      ONLINE LIBRARY MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Librarian Login");
            System.out.println("2. Member Login");
            System.out.println("3. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    librarianLogin();
                    break;

                case 2:
                    memberLogin();
                    break;

                case 3:
                    System.out.println(
                            "\nThank you for using the Library Management System!"
                    );
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    // =========================================================
    // SAMPLE DATA
    // =========================================================

    private static void addSampleData() {

        bookService.addBook(
                new Book(
                        1,
                        "Clean Code",
                        "Robert Martin",
                        "9780132350884",
                        "Programming"
                )
        );

        bookService.addBook(
                new Book(
                        2,
                        "Java Programming",
                        "James Gosling",
                        "9780134685991",
                        "Programming"
                )
        );

        bookService.addBook(
                new Book(
                        3,
                        "The Alchemist",
                        "Paulo Coelho",
                        "9780061122415",
                        "Fiction"
                )
        );

        memberService.addMember(
                new Member(
                        1,
                        "Priyanshu",
                        "priyanshu@gmail.com",
                        "MEM001",
                        "member123"
                )
        );

        memberService.addMember(
                new Member(
                        2,
                        "Rahul",
                        "rahul@gmail.com",
                        "MEM002",
                        "rahul123"
                )
        );
    }

    // =========================================================
    // LIBRARIAN LOGIN
    // =========================================================

    private static void librarianLogin() {

        System.out.println("\n========== LIBRARIAN LOGIN ==========");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(LIBRARIAN_USERNAME)
                && password.equals(LIBRARIAN_PASSWORD)) {

            System.out.println("\nLogin successful!");

            librarianDashboard();

        } else {

            System.out.println("\nInvalid username or password.");
        }
    }

    // =========================================================
    // MEMBER LOGIN
    // =========================================================

    private static void memberLogin() {

        System.out.println("\n============ MEMBER LOGIN ============");

        System.out.print("Membership ID: ");
        String membershipId = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Member member =
                memberService.findByMembershipId(membershipId);

        if (member != null
                && member.getPassword().equals(password)) {

            System.out.println(
                    "\nLogin successful! Welcome, "
                            + member.getName() + "!"
            );

            memberDashboard(member);

        } else {

            System.out.println("\nInvalid Membership ID or password.");
        }
    }

    // =========================================================
    // LIBRARIAN DASHBOARD
    // =========================================================

    private static void librarianDashboard() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("        LIBRARIAN DASHBOARD");
            System.out.println("========================================");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Transaction Management");
            System.out.println("4. Notification Management");
            System.out.println("5. Inventory Reports");
            System.out.println("6. Logout");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    bookManagement();
                    break;

                case 2:
                    memberManagement();
                    break;

                case 3:
                    transactionManagement();
                    break;

                case 4:
                    notificationManagement();
                    break;

                case 5:
                    inventoryReport();
                    break;

                case 6:
                    System.out.println("\nLogged out successfully.");
                    return;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    // =========================================================
    // BOOK MANAGEMENT
    // =========================================================

    private static void bookManagement() {

        while (true) {

            System.out.println("\n========== BOOK MANAGEMENT ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Edit Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBooks();
                    break;

                case 4:
                    editBook();
                    break;

                case 5:
                    deleteBook();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {

        System.out.println("\n---------- ADD BOOK ----------");

        int id = readInt("Enter Book ID: ");

        if (bookService.findBookById(id) != null) {
            System.out.println("Book ID already exists.");
            return;
        }

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        bookService.addBook(
                new Book(id, title, author, isbn, genre)
        );

        System.out.println("\nBook added successfully!");
    }

    private static void viewBooks() {

        System.out.println("\n---------- ALL BOOKS ----------");

        List<Book> books = bookService.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            displayBook(book);
        }
    }

    private static void searchBooks() {

        System.out.println("\n---------- SEARCH BOOK ----------");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Genre");

        int choice = readInt("Enter your choice: ");

        System.out.print("Enter search text: ");
        String text = scanner.nextLine();

        List<Book> results;

        switch (choice) {

            case 1:
                results = bookService.searchByTitle(text);
                break;

            case 2:
                results = bookService.searchByAuthor(text);
                break;

            case 3:
                results = bookService.searchByGenre(text);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("\nNo books found.");
            return;
        }

        for (Book book : results) {
            displayBook(book);
        }
    }

    private static void editBook() {

        int id = readInt("Enter Book ID to edit: ");

        Book book = bookService.findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new author: ");
        String author = scanner.nextLine();

        System.out.print("Enter new ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter new genre: ");
        String genre = scanner.nextLine();

        if (bookService.updateBook(
                id, title, author, isbn, genre)) {

            System.out.println("\nBook updated successfully!");
        }
    }

    private static void deleteBook() {

        int id = readInt("Enter Book ID to delete: ");

        if (bookService.deleteBook(id)) {
            System.out.println("\nBook deleted successfully!");
        } else {
            System.out.println("\nBook not found.");
        }
    }

    private static void displayBook(Book book) {

        System.out.println("----------------------------------------");
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Status: "
                + (book.isAvailable() ? "Available" : "Borrowed"));
    }

    // =========================================================
    // MEMBER MANAGEMENT
    // =========================================================

    private static void memberManagement() {

        while (true) {

            System.out.println("\n========== MEMBER MANAGEMENT ==========");
            System.out.println("1. Add Member");
            System.out.println("2. View All Members");
            System.out.println("3. Edit Member");
            System.out.println("4. Delete Member");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addMember();
                    break;

                case 2:
                    viewMembers();
                    break;

                case 3:
                    editMember();
                    break;

                case 4:
                    deleteMember();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addMember() {

        System.out.println("\n---------- ADD MEMBER ----------");

        int id = readInt("Enter Member ID: ");

        if (memberService.findMemberById(id) != null) {
            System.out.println("Member ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter membership ID: ");
        String membershipId = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        memberService.addMember(
                new Member(
                        id,
                        name,
                        email,
                        membershipId,
                        password
                )
        );

        System.out.println("\nMember added successfully!");
    }

    private static void viewMembers() {

        System.out.println("\n---------- ALL MEMBERS ----------");

        for (Member member : memberService.getAllMembers()) {

            System.out.println("----------------------------------------");
            System.out.println("ID: " + member.getId());
            System.out.println("Name: " + member.getName());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Membership ID: "
                    + member.getMembershipId());
        }
    }

    private static void editMember() {

        int id = readInt("Enter Member ID to edit: ");

        Member member = memberService.findMemberById(id);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        System.out.print("Enter new membership ID: ");
        String membershipId = scanner.nextLine();

        System.out.print("Enter new password: ");
        String password = scanner.nextLine();

        if (memberService.updateMember(
                id, name, email, membershipId)) {

            member.setPassword(password);

            System.out.println("\nMember updated successfully!");
        }
    }

    private static void deleteMember() {

        int id = readInt("Enter Member ID to delete: ");

        if (memberService.deleteMember(id)) {
            System.out.println("\nMember deleted successfully!");
        } else {
            System.out.println("\nMember not found.");
        }
    }

    // =========================================================
    // TRANSACTION MANAGEMENT
    // =========================================================

    private static void transactionManagement() {

        while (true) {

            System.out.println("\n======= TRANSACTION MANAGEMENT =======");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Transactions");
            System.out.println("4. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    borrowBook();
                    break;

                case 2:
                    returnBook();
                    break;

                case 3:
                    viewTransactions();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void borrowBook() {

        int bookId = readInt("Enter Book ID: ");
        int memberId = readInt("Enter Member ID: ");

        Book book = bookService.findBookById(bookId);
        Member member = memberService.findMemberById(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (transactionService.borrowBook(book, memberId)) {

            System.out.println("\nBook borrowed successfully!");

            notificationService.sendNotification(
                    member,
                    "You borrowed: " + book.getTitle()
            );

        } else {

            System.out.println("\nBook is currently unavailable.");
        }
    }

    private static void returnBook() {

        int bookId = readInt("Enter Book ID: ");
        int memberId = readInt("Enter Member ID: ");

        Book book = bookService.findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (transactionService.returnBook(book, memberId)) {
            System.out.println("\nBook returned successfully!");
        } else {
            System.out.println("\nReturn transaction not found.");
        }
    }

    private static void viewTransactions() {

        System.out.println("\n---------- TRANSACTIONS ----------");

        List<Transaction> transactions =
                transactionService.getAllTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {

            System.out.println("----------------------------------------");
            System.out.println("Transaction ID: "
                    + transaction.getId());
            System.out.println("Book ID: "
                    + transaction.getBookId());
            System.out.println("Member ID: "
                    + transaction.getMemberId());
            System.out.println("Borrow Date: "
                    + transaction.getBorrowDate());
            System.out.println("Return Date: "
                    + (transaction.getReturnDate() == null
                    ? "Not Returned"
                    : transaction.getReturnDate()));
        }
    }

    // =========================================================
    // NOTIFICATIONS
    // =========================================================

    private static void notificationManagement() {

        while (true) {

            System.out.println("\n======= NOTIFICATION MANAGEMENT =======");
            System.out.println("1. Send Notification");
            System.out.println("2. View Notifications");
            System.out.println("3. Send Due-Date Notification");
            System.out.println("4. Send New-Arrival Notification");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    sendNotification();
                    break;

                case 2:
                    viewNotifications();
                    break;

                case 3:
                    sendDueDateNotification();
                    break;

                case 4:
                    sendNewArrivalNotification();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void sendNotification() {

        int memberId = readInt("Enter Member ID: ");

        Member member = memberService.findMemberById(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        notificationService.sendNotification(member, message);

        System.out.println("\nNotification sent successfully!");
    }

    private static void viewNotifications() {

        System.out.println("\n---------- NOTIFICATIONS ----------");

        List<String> notifications =
                notificationService.getAllNotifications();

        if (notifications.isEmpty()) {
            System.out.println("No notifications.");
            return;
        }

        for (String notification : notifications) {
            System.out.println("- " + notification);
        }
    }

    private static void sendDueDateNotification() {

        int memberId = readInt("Enter Member ID: ");

        Member member = memberService.findMemberById(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        notificationService.sendDueDateNotification(
                member, dueDate
        );

        System.out.println("\nDue-date notification sent!");
    }

    private static void sendNewArrivalNotification() {

        int memberId = readInt("Enter Member ID: ");

        Member member = memberService.findMemberById(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        notificationService.sendNewArrivalNotification(
                member, title
        );

        System.out.println("\nNew-arrival notification sent!");
    }

    // =========================================================
    // INVENTORY REPORT
    // =========================================================

    private static void inventoryReport() {

        List<Book> books = bookService.getAllBooks();

        int available = 0;
        int borrowed = 0;

        for (Book book : books) {

            if (book.isAvailable()) {
                available++;
            } else {
                borrowed++;
            }
        }

        System.out.println("\n========== INVENTORY REPORT ==========");
        System.out.println("Total Books       : " + books.size());
        System.out.println("Available Books   : " + available);
        System.out.println("Borrowed Books    : " + borrowed);
        System.out.println("Total Members     : "
                + memberService.getAllMembers().size());
        System.out.println("Total Transactions: "
                + transactionService.getAllTransactions().size());
    }

    // =========================================================
    // MEMBER DASHBOARD
    // =========================================================

    private static void memberDashboard(Member member) {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("          MEMBER DASHBOARD");
            System.out.println("========================================");
            System.out.println("Welcome, " + member.getName());
            System.out.println("1. Book Search");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Borrowing History");
            System.out.println("5. Profile Information");
            System.out.println("6. Notification Alerts");
            System.out.println("7. Logout");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    searchBooks();
                    break;

                case 2:
                    memberBorrowBook(member);
                    break;

                case 3:
                    memberReturnBook(member);
                    break;

                case 4:
                    borrowingHistory(member);
                    break;

                case 5:
                    showProfile(member);
                    break;

                case 6:
                    memberNotifications(member);
                    break;

                case 7:
                    System.out.println("\nLogged out successfully.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void memberBorrowBook(Member member) {

        int bookId = readInt("Enter Book ID: ");

        Book book = bookService.findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (transactionService.borrowBook(
                book, member.getId())) {

            System.out.println("\nBook borrowed successfully!");

            notificationService.sendNotification(
                    member,
                    "You borrowed: " + book.getTitle()
            );

        } else {

            System.out.println(
                    "\nBook is currently unavailable."
            );
        }
    }

    private static void memberReturnBook(Member member) {

        int bookId = readInt("Enter Book ID: ");

        Book book = bookService.findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (transactionService.returnBook(
                book, member.getId())) {

            System.out.println("\nBook returned successfully!");

        } else {

            System.out.println(
                    "\nReturn transaction not found."
            );
        }
    }

    private static void borrowingHistory(Member member) {

        System.out.println("\n========== BORROWING HISTORY ==========");

        List<Transaction> history =
                transactionService.getMemberHistory(
                        member.getId()
                );

        if (history.isEmpty()) {
            System.out.println("No borrowing history.");
            return;
        }

        for (Transaction transaction : history) {

            System.out.println("----------------------------------------");
            System.out.println("Transaction ID: "
                    + transaction.getId());
            System.out.println("Book ID: "
                    + transaction.getBookId());
            System.out.println("Borrow Date: "
                    + transaction.getBorrowDate());
            System.out.println("Return Date: "
                    + (transaction.getReturnDate() == null
                    ? "Not Returned"
                    : transaction.getReturnDate()));
        }
    }

    private static void showProfile(Member member) {

        System.out.println("\n========== PROFILE INFORMATION ==========");
        System.out.println("Member ID: " + member.getId());
        System.out.println("Name: " + member.getName());
        System.out.println("Email: " + member.getEmail());
        System.out.println("Membership ID: "
                + member.getMembershipId());
        System.out.println("Password: ********");
    }

    private static void memberNotifications(Member member) {

        System.out.println("\n========== NOTIFICATION ALERTS ==========");

        List<String> notifications =
                notificationService.getAllNotifications();

        boolean found = false;

        for (String notification : notifications) {

            if (notification.contains(member.getName())
                    || notification.contains(member.getEmail())) {

                System.out.println("- " + notification);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No notifications available.");
        }
    }

    // =========================================================
    // INPUT HELPER
    // =========================================================

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}