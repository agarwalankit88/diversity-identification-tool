package com.wellsfargo.hackett.diversificationidentitytool.controller;

import com.wellsfargo.hackett.diversificationidentitytool.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/books")
    public String getBooks(Model model) {

        List<Book> books = new ArrayList<>();
        books.add(new Book().setBookName("book1").setBookAuthor("ankit"));
        books.add(new Book().setBookName("book2").setBookAuthor("sai krishna"));
        model.addAttribute("books", books);
        return "book";
    }
}
