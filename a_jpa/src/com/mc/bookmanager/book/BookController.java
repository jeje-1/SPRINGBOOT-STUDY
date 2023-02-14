package com.mc.bookmanager.book;

import com.mc.bookmanager.book.dto.BookDto;
import com.mc.bookmanager.member.dto.MemberDto;

public class BookController {

	public BookDto findBookByTitle(String title) {
		BookDto book = BookService.findBookByTitle(title);
		return book;
		
	}

}
