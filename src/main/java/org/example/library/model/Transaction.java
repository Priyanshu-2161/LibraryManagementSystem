package org.example.library.model;

import java.time.LocalDate;

public class Transaction {

    private int id;
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Transaction(int id, int bookId, int memberId, LocalDate borrowDate) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}