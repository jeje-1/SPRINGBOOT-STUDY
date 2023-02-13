package com.mc.bookmanager.member;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
   
	@Id
   private String userId;
   private String password;
   private String email;
   private String grade;
   private String tell;
   private Boolean isLeave;
   private LocalDateTime regDate;
   private LocalDateTime rentableDate;
   
   
}