package com.mc.bookmanager.rent;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ColumnDefault;
import com.mc.bookmanager.book.Book;

import lombok.Data;

@Data
@Entity
public class RentBook {

	@Id
	@GeneratedValue
	private Long rbIdx;
	
	@Column(columnDefinition = "timestamp default now()")
	private LocalDateTime regDate;
	private String state;
	
	@Column(columnDefinition = "timestamp")
	private LocalDateTime returnDate;
	
	@ColumnDefault("0")
	private Integer extenstionCnt; // 연장 횟수
	
	@ManyToOne
	@JoinColumn(name="bkIdx")
	private Book book;
	
	@ManyToOne()
	@JoinColumn(name="rmIdx")
	private Rent rent;
	
}