package com.mc.bookmanager.book;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
   
	@Id //기본
	@GeneratedValue // JPA의 정책에 따른 식별자 자동생성
   private Integer bkIdx;
   private String isbn;
   private String category;
   private String title;
   private String author;
   private String info;
   
 
   private Integer bookAmt;
   private LocalDateTime regDate;
   private Integer rentCnt;
   
}