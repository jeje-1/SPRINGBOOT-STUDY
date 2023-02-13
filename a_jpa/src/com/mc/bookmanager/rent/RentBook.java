package com.mc.bookmanager.rent;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mc.bookmanager.book.Book;

import lombok.Data;

@Data
@Entity
public class RentBook {
	
	@Id
	@GeneratedValue
   private Long rbIdx;
   private LocalDateTime regDate;
   private String state;
   private LocalDateTime returnDate;
   private int extenstionCnt; // 연장 횟수
   
   @ManyToOne
   @JoinColumn(name="bkIdx")
   private Book book;
   
   @ManyToOne
   @JoinColumn(name="rmIdx")
   private Rent rent;
   
   
   
}