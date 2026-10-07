# Online Library Management System

## 1. Project Overview

The Online Library Management System is a Java-based application developed to manage library books, members, borrowing and returning transactions, notifications, and inventory information.

The system provides two main user roles:

- Librarian
- Member

The application provides role-based login and different features according to the user's role.

---

## 2. Requirements

### Librarian Requirements

The librarian can:

- Add new books.
- View all books.
- Edit book information.
- Delete books.
- Manage library members.
- Create new members.
- Edit member information.
- Delete members.
- Manage borrowing and returning transactions.
- Track book ID, member ID, borrow date, and return date.
- Send notifications to members.
- Send due-date notifications.
- Send new-arrival notifications.
- View inventory reports.

### Book Information

Each book contains:

- Book ID
- Title
- Author
- ISBN
- Genre
- Availability status

### Member Information

Each member contains:

- Member ID
- Name
- Email
- Membership ID
- Password

### Member Requirements

Members can:

- Log in securely using their membership ID and password.
- Search books by title.
- Search books by author.
- Search books by genre.
- Borrow available books.
- Return borrowed books.
- View borrowing history.
- View profile information.
- Manage profile information.
- Receive notifications.

---

## 3. Main Features

### Librarian Module

- Librarian login
- Book Management
- Member Management
- Transaction Management
- Notification Management
- Inventory Reports

### Member Module

- Member login
- Book Search
- Borrow Book
- Return Book
- Borrowing History
- Profile Management
- Notification Alerts

---

## 4. Technologies Used

- Java
- Maven
- IntelliJ IDEA
- Git
- GitHub

---

## 5. Project Structure

```text
LibraryManagementSystem
│
├── src
│   └── main
│       └── java
│           └── org.example.library
│               │
│               ├── model
│               │   ├── Book.java
│               │   ├── Member.java
│               │   └── Transaction.java
│               │
│               ├── service
│               │   ├── BookService.java
│               │   ├── MemberService.java
│               │   ├── TransactionService.java
│               │   └── NotificationService.java
│               │
│               └── LibraryManagementSystem.java
│
├── pom.xml
├── .gitignore
└── README.md

So it should look like:

```

## 6. Requirements to Run the Project
The following software is required:
Java JDK 17 or later
IntelliJ IDEA
Maven
Git
## 7. How to Run the Project
Clone or download the project from the GitHub repository.
Open the project in IntelliJ IDEA.
Allow IntelliJ IDEA to load the Maven project.
Open:
LibraryManagementSystem.java
Locate the main() method.
Click the green Run button.
Select the required login option from the console.
Enter the appropriate login credentials.
## 8. Login Credentials
Librarian Login
Username: admin
Password: admin123
Member Login 1
Membership ID: MEM001
Password: member123
Member Login 2
Membership ID: MEM002
Password: rahul123
## 9. Librarian Dashboard
After successful librarian login, the librarian can access:
Book Management
Member Management
Transaction Management
Notification Management
Inventory Reports
Logout
## 10. Member Dashboard
After successful member login, the member can access:
Book Search
Borrow Book
Return Book
Borrowing History
Profile Management
Notifications
Logout
## 11. Book Management
The librarian can:
Add a book.
View all books.
Edit book details.
Delete a book.
Search books by title, author, or genre.
The system also tracks whether a book is currently available or borrowed.
## 12. Member Management
The librarian can:
Create members.
View members.
Edit member information.
Delete members.
Member information includes name, email, membership ID, and password.
## 13. Transaction Management
The system supports:
Borrowing books.
Returning books.
Tracking book ID.
Tracking member ID.
Recording borrow date.
Recording return date.
Viewing borrowing history.
## 14. Notification Management
The librarian can send notifications to members.
The system supports:
General notifications.
Due-date reminders.
New book arrival notifications.
## 15. Inventory Reports
The librarian can view library inventory information, including:
Total number of books.
Available books.
Borrowed books.
## 16. GitHub Repository
The project source code is available at:
https://github.com/Priyanshu-2161/LibraryManagementSystem⁠�
The repository is public and contains the complete project source code.
## 17. Code Organization
The project follows a modular structure.
Model Package
Contains classes representing library data:
Book
Member
Transaction
Service Package
Contains business logic for:
Book management
Member management
Transactions
Notifications
Main Application
LibraryManagementSystem.java provides the console-based user interface and connects the different services.
## 18. Important Note
The current application stores data in memory while the program is running.
Therefore, data added during one execution will not be permanently stored after the application is closed.
This project is intended as a demonstration of an Online Library Management System using Java, object-oriented programming, modular services, and role-based access.
## 19. Submission Requirements
The project submission includes:
GitHub repository
Source code
README documentation
Project setup and run instructions
Project features and requirements
Modular and commented code
Presentation with relevant project screenshots and visuals
## 20. Author
Priyanshu

Online Library Management System
