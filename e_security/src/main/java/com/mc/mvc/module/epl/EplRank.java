package com.mc.mvc.module.epl;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.mc.mvc.module.epl.dto.EplRankDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DynamicInsert
@DynamicUpdate
@Builder @AllArgsConstructor @NoArgsConstructor @Getter
public class EplRank {
	
	@Id
	@GeneratedValue
	private Long eplIdx;
	private String team;
	private Integer matchCnt;
	private Integer win;
	private Integer draw;
	private Integer lose;
	private Integer goalsDifference;
	private Integer goalsFor;
	private Integer goalsAgainst;
	private Integer point;
	
	@Builder.Default
	private LocalDateTime regDate = LocalDateTime.now();
	
	public static EplRank createEplRank(EplRankDto dto) {
	      return EplRank.builder()
	            .goalsAgainst(dto.getGoalsAgainst())
	            .goalsFor(dto.getGoalsFor())
	            .team(dto.getTeam())
	            .matchCnt(dto.getMatchCnt())
	            .win(dto.getWin())
	            .lose(dto.getLose())
	            .goalsDifference(dto.getGoalsDifference())
	            .point(dto.getPoint())
	            .draw(dto.getDraw())
	            .build();
	            
	   }

}
