package com.wellsfargo.hackett.diversificationidentitytool.model;

public class Book {

    private String bookName;

    private String bookAuthor;

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Book setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public Book setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }
}
