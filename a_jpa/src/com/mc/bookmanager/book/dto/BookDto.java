package com.mc.bookmanager.book.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import com.mc.bookmanager.book.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

	private Long bkIdx;
	private String isbn;
	private String category;
	private String title;
	private String author;
	private String info;
	private Integer bookAmt;
	private LocalDateTime regDate;
	private Integer rentCnt;
	
	
	public BookDto(Book entity) {
		this.bkIdx = entity.getBkIdx();
		this.isbn = entity.getIsbn();
		this.category = entity.getCategory();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.info = entity.getInfo();
		this.bookAmt = entity.getBookAmt();
		this.regDate = entity.getRegDate();
		this.rentCnt = entity.getRentCnt();
	}
}
