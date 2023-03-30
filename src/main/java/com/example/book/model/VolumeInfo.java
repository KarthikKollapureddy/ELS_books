package com.example.book.model;

import java.sql.Clob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.Data;


@Data
public class VolumeInfo {
	private String title;
	private String subtitle;
//	@Embedded
	private String[] authors;
//	@Column(columnDefinition = "TEXT",length = 100000)
	private String description;
	private String publishedDate;
	private String language;
	private int pageCount;
	@Embedded
	private ImageLinks imageLinks;
	private String previewLink;
	private String infoLink;
	private String canonicalVolumeLink;
	
	

}
