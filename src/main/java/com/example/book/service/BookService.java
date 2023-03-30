package com.example.book.service;


import java.util.List;

import org.springframework.stereotype.Service;

//import com.example.book.model.Book;
import com.example.book.model.Items;

@Service
public interface BookService {
	
		Items addBook(Items book);
//	Book addBook(Book book);
		
		List<Items> getFavBooks(String userName);
		
		void deleteFavbook(int id);

}
