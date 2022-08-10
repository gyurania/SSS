package com.ssafy.web.model.response;

import lombok.Getter;
import lombok.Setter;

/**치료사 정보 응답할 때 */
@Getter
@Setter
public class TherapistResponse {

	//아이디
	String id;
	//이름
	String name;
	//이메일
	String email;
	//전화번호
	String phone;
	//주소
	String address;
	//프로필주소
	String profile_url;
	//자기소개
	String thera_intro;
}