package com.mc.mvc.module.epl;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mc.mvc.module.epl.dto.EplRankDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class EplService {

   private final EplRepository eplRepository;
   private final RestTemplate restTemplate;
   
   // 배치 만들 때 controller없어도 됨!
   
   // cron표현식
   // 초 분 시 일 월 요일(0~6) 년(스프링에선 사용하지 않음)
   // * : 모든
   // , : 복수 값을 지정
   // / : 시작시간/단위 => 시작시간 부터 지정한 단위마다 실행
   // ? : 정해진 값이 없음
   // L : 마지막 일, 마지막 요일(saturday) 
   // W : 가장 가까운 주중(m-f)
   // - : 범위 (10-12 : 10시,11시,12시)
   // # : 월 기준 몇번째 주의 무슨 요일 2#7 - 두번째주 토요일
   
   // 0 0 3 * * * => 매일 새벽 3시 0분 0초에 배치를 실행
   // 0 0 ,6 22 * ? => 매일 22일 새벽 3시, 아침 6시에 배치를 실행
   // 0 0/15 * * * * => 매일 15분마다 배치를 실행, 1시 15분, 1시 30분, 1시 45분 ...
   
   @SuppressWarnings("unchecked")
   @Scheduled(cron="0/10 * * * * *")
   @Transactional
   public void saveEplRank() {
      
      String url = "https://sports.daum.net/prx/hermes/api/team/rank.json?leagueCode=epl&seasonKey=20222023&page=1&pageSize=100";
      
      ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
      
      ObjectMapper mapper = new ObjectMapper();
      
      try {
    	  JsonNode root = mapper.readTree(response.getBody());
    	  
    	  for(JsonNode jsonNode : root.at("/list")) {
    		  EplRankDto dto = new EplRankDto();
    		  
    		    dto.setTeam(jsonNode.at("/nameMain").asText());   
	            dto.setDraw(jsonNode.at("/rank/draw").asInt());
	            dto.setGoalsAgainst(jsonNode.at("/rank/ga").asInt());
	            dto.setGoalsFor(jsonNode.at("/rank/gf").asInt());
	            dto.setGoalsDifference(jsonNode.at("/rank/gd").asInt());
	            dto.setLose(jsonNode.at("/rank/loss").asInt());
	            dto.setMatchCnt(jsonNode.at("/rank/game").asInt());
	            dto.setPoint(jsonNode.at("/rank/pts").asInt());
	            dto.setWin(jsonNode.at("/rank/win").asInt());
	            
	            EplRank entity = EplRank.createEplRank(dto);
	            eplRepository.save(entity);
    	  }
    	  
    	  
         
//         Map<String,Object> data = mapper.readValue(response.getBody(),Map.class);
//         List<Map<String,  Object>> list = (List<Map<String,  Object>>) data.get("list");
//         
//         for (Map<String, Object> temp : list) {
//            
//            EplRankDto dto = new EplRankDto();
//            
//            String name = (String) temp.get("name");
//            LinkedHashMap<String, Integer> rank = (LinkedHashMap<String, Integer>) temp.get("rank");
//            dto.setTeam(name);   
//            dto.setDraw(rank.get("draw"));
//            dto.setGoalsAgainst(rank.get("ga"));
//            dto.setGoalsFor(rank.get("gf"));
//            dto.setLose(rank.get("loss"));
//            dto.setMatchCnt(rank.get("game"));
//            dto.setPoint(rank.get("pts"));
//            dto.setWin(rank.get("win"));
//            
//            EplRank entity = EplRank.createEplRank(dto);
//            eplRepository.save(entity);
//            
//            
//         }
         
      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      
      
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}