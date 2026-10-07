package org.example.library.service;

import org.example.library.model.Book;
import org.example.library.model.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    // Borrow a book
    public boolean borrowBook(Book book, int memberId) {

        if (book == null || !book.isAvailable()) {
            return false;
        }

        int transactionId = transactions.size() + 1;

        Transaction transaction = new Transaction(
                transactionId,
                book.getId(),
                memberId,
                LocalDate.now()
        );

        transactions.add(transaction);
        book.setAvailable(false);

        return true;
    }

    // Return a book
    public boolean returnBook(Book book, int memberId) {

        if (book == null || book.isAvailable()) {
            return false;
        }

        for (Transaction transaction : transactions) {

            if (transaction.getBookId() == book.getId()
                    && transaction.getMemberId() == memberId
                    && transaction.getReturnDate() == null) {

                transaction.setReturnDate(LocalDate.now());
                book.setAvailable(true);

                return true;
            }
        }

        return false;
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    // Get borrowing history of a member
    public List<Transaction> getMemberHistory(int memberId) {

        List<Transaction> history = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getMemberId() == memberId) {
                history.add(transaction);
            }
        }

        return history;
    }
}