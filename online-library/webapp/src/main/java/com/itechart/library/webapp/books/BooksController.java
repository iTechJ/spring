package com.itechart.library.webapp.books;

import com.itechart.library.core.book.Book;
import com.itechart.library.core.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findBooks() {
        ModelAndView modelAndView = new ModelAndView("books");
        Iterable<Book> books = bookService.findAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
