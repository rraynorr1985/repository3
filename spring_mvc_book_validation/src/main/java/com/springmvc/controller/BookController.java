package com.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Book;
import com.springmvc.service.BookService;

@Controller
public class BookController {
	@Autowired BookService bookService;
	
	@RequestMapping("/")
	public String home(@ModelAttribute("book") Book book, Model model) {
		List<Book> books = bookService.listAll();
		model.addAttribute("books", books);
		return "home";
	}
	
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult br, Model model) {
		if (br.hasErrors()) {
			List<Book> books = bookService.listAll();
			model.addAttribute("books", books);
			return "home";
		}
		bookService.addBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam int id) {
		bookService.removeBook(id);
		return "redirect:/";
	}

}
