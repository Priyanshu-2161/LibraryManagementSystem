package org.example.library.service;

import org.example.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final List<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Search books by title
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    // Search books by author
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    // Search books by genre
    public List<Book> searchByGenre(String genre) {
        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    // Edit an existing book
    public boolean updateBook(int id, String title, String author,
                              String isbn, String genre) {

        Book book = findBookById(id);

        if (book == null) {
            return false;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setGenre(genre);

        return true;
    }

    // Delete a book
    public boolean deleteBook(int id) {
        Book book = findBookById(id);

        if (book == null) {
            return false;
        }

        books.remove(book);
        return true;
    }
}