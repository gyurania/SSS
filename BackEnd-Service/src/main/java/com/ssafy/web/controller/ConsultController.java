package com.ssafy.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.web.model.response.ConsultInfo;

@RestController
@RequestMapping("/consult")
public class ConsultController {
	
	//부모의 전체 아동에 대한 모든 상담 내역 조회 
	@GetMapping("/{parent_id}")
	public List<ConsultInfo> ParentConsult(@PathVariable("parent_id") String parent_id){
		List<ConsultInfo> pconsult = new ArrayList<ConsultInfo>();
	
		return pconsult; 
	}
	
	//상담사의 모든 상담 내역 조회 
		@GetMapping("/{thera_id}")
		public List<ConsultInfo> TheraConsult(@PathVariable("thera_id") String thera_id){
			List<ConsultInfo> tconsult = new ArrayList<ConsultInfo>();
		
			return tconsult; 
		}
}
