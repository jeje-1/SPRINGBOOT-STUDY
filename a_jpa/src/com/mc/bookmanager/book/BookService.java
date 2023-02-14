package com.mc.bookmanager.book;

import java.util.List;

import javax.persistence.EntityManager;

import com.mc.bookmanager.book.dto.BookDto;
import com.mc.bookmanager.jpa.EntityTemplate;
import com.mc.bookmanager.member.Member;
import com.mc.bookmanager.member.dto.MemberDto;

public class BookService {
	
	private BookRepository bookRepository = new BookRepository();

	public static BookDto findBookByTitle(String title) {
		EntityManager em = EntityTemplate.getEntityManager();
		Book book = null;
		
		try {
			book = em.find(Book.class, title);
		} finally {
			//EntityManager 종료
			//EntityManager를 종료하면 Entity들은 더이상 EntityManager의 관리대상이 아니게된다. == 준영속상태로 변경된다.
			// close : EntityManger 종료
			// clear : EntityManager 초기화, EntityManager가 관리하고 있던 모든 Entity들을 준영속 상태로 변경
			// detach : 특정 Entity를 준영속 상태로 변경할 때 사용
			em.close();
		}
		
		return new BookDto(book);
	}

	public List<BookDto> findAllBooks() {
		
		List<Member> books = null;
		EntityManager em = EntityTemplate.getEntityManager();
		
		try {
			books = bookRepository.findAllBooks(em);
		} finally {
			em.close();
		}
		
		return MemberDto.toDtoList(books);
	}

}
