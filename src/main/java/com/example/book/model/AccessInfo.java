package com.example.book.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.Data;


@Data
public class AccessInfo {
	private String country;
	@Embedded
	private Pdf pdf;
	private String webReaderLink;
	

}
