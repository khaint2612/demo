package edu.poly.spring.controllers;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.spring.models.Author;
import edu.poly.spring.models.Book;
import edu.poly.spring.models.Category;
import edu.poly.spring.models.PublishingCompany;
import edu.poly.spring.models.Reader;
import edu.poly.spring.services.AuthorService;
import edu.poly.spring.services.BookService;
import edu.poly.spring.services.CategoryService;
import edu.poly.spring.services.PublishingCompanyService;


@Controller
@RequestMapping("/backend/book")
public class BookControl {
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private PublishingCompanyService publishingCompanyService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		Book book = new Book();
		List<Category> category = (List<Category>) categoryService.findAll();
		List<Author> author = (List<Author>) authorService.findAll();
		List<PublishingCompany> publishingCompany = (List<PublishingCompany>) publishingCompanyService.findAll();
		model.addAttribute("book",book);
		model.addAttribute("category",category);
		model.addAttribute("author",author);
		model.addAttribute("publishingCompany",publishingCompany);
		return "backend/book/add";
	}
	
	@PostMapping("/save")
	public String save(ModelMap model, Book book) {
		
		bookService.save(book);
		model.addAttribute(book);
		return list(model);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Book> opt = bookService.findById(id);
		if(opt.isPresent()) {
			model.addAttribute("book",opt.get());
		}else {
			return list(model);
		}
		return "backend/book/edit";
	}
	
	@PostMapping("/update")
	public String update(Book book,ModelMap model) {
		bookService.save(book);
		model.addAttribute(book);
		return "backend/book/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name = "id")String id) {
		bookService.deleteById(id);
		return list(model);
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Book> book = (List<Book>) bookService.findAll();
		List<Category> categories = (List<Category>) categoryService.findAll();
		List<Author> author = (List<Author>) authorService.findAll();
		model.addAttribute("books",book);
		model.addAttribute("category",categories);
		model.addAttribute("author",author);
		return "backend/book/list";
	}
	
	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		List<Book> list = bookService.findByNameLikeOrderByName(name);
		model.addAttribute("books", list);
		return "backend/book/list";
	}
	
	@ModelAttribute(name = "category")
	List<Category> getCategories(){
		return bookService.findAllCategory();
	}
	@ModelAttribute(name = "author")
	List<Author> getAuthors(){
		return bookService.findAllAuthor ();
	}
	@ModelAttribute(name = "publishingCompany")
	List<PublishingCompany> getCompanies(){
		return bookService.findAllPublishingCompany();
	}
}
