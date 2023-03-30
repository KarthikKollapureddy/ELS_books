package com.example.book.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.dao.ItemRepository;
import com.example.book.model.Items;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Items addBook(Items book) {
		// TODO Auto-generated method stub
		return itemRepository.save(book);
	}

	@Override
	public List<Items> getFavBooks(String userName) {
		// TODO Auto-generated method stub
		return itemRepository.findByUserName(userName);
	}

	@Override
	public void deleteFavbook(int id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
		
	}

	



}
