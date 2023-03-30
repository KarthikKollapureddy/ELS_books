package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.book.config.CustomClientHttpRequestFactory;
//import com.example.book.config.CustomClientHttpRequestFactory;
import com.example.book.model.Book;
import com.example.book.model.Items;
import com.example.book.service.BookService;

@RestController
@RequestMapping("books/api")
@CrossOrigin(origins = "*")
public class BookController {
	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	BookService bookService;
	
	
	@Value("${server.port}")
	int myserverPort;
	
	@GetMapping()
	public ResponseEntity<String> port(){
		return new ResponseEntity<String>("book ms is running on port :"+myserverPort,HttpStatus.OK);
	}
	
	@GetMapping("{query}")
	public ResponseEntity<Book> getBookData(@PathVariable String query){
		RestTemplate restTemplate1 = new RestTemplate(new CustomClientHttpRequestFactory(2000,2000, true));
		return new ResponseEntity<Book>(restTemplate1.getForObject("https://www.googleapis.com/books/v1/volumes?q="+query+"&maxResults=10", Book.class),HttpStatus.OK);
	}
	@GetMapping("{query}/{limit}")
	public ResponseEntity<Book> getBookDataLimit(@PathVariable String query,@PathVariable int limit){
		RestTemplate restTemplate1 = new RestTemplate(new CustomClientHttpRequestFactory(2000,2000, true));
		return new ResponseEntity<Book>(restTemplate1.getForObject("https://www.googleapis.com/books/v1/volumes?q="+query+"&maxResults="+limit, Book.class),HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<Items> addBook(@RequestBody Items book){
		return new ResponseEntity<Items>(bookService.addBook(book),HttpStatus.OK);
	}
	@GetMapping("user/{uname}")
	public ResponseEntity<List<Items>> getbook(@PathVariable String uname){
		return new ResponseEntity<List<Items>>(bookService.getFavBooks(uname),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFav(@PathVariable int id){
		bookService.deleteFavbook(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
//	
	

}
