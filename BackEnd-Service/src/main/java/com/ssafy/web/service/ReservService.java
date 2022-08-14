package com.ssafy.web.service;

import java.util.List;

import com.ssafy.web.model.response.ParentReservResponse;
import com.ssafy.web.model.response.TheraReservResponse;
import com.ssafy.web.request.ReservRequest;

public interface ReservService {

	// 보호자 -> 상담사 상담 예약
	void reservRegist(ReservRequest reservInfo);

	// 보호자 -> 예약한 상담 리스트 가져오기 
	List<ParentReservResponse> getReservByParent(String parentId);
	
	// 상담사 -> 예약된 상담 리스트 가져오기
	List<TheraReservResponse> getReservByThera(String theraId);
}
