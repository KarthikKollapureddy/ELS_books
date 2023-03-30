package com.example.book.model;

//import java.util.List;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "book_info")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int book_id;
	
	private String userName;

	@Embedded
	private VolumeInfo volumeInfo;
	@Embedded
	private AccessInfo accessInfo;
	

}
