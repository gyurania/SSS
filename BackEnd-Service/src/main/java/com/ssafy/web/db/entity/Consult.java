package com.ssafy.web.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="consult")
public class Consult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="consult_no")
	private int consultNo;

	@Column(name = "started_time", columnDefinition = "DATE", nullable = false)
	Date startedTime;
	
	@Column(name = "closed_time", columnDefinition = "DATE")
	Date closedTime;
	
	@Column(name = "thera_id", columnDefinition = "CHAR(13)", nullable = false)
	String theraId;
	
	@Column(name = "child_id", columnDefinition = "CHAR(13)", nullable = false)
	String childId;
	
	@Column(name = "parent_id", columnDefinition = "CHAR(13)", nullable = false)
	String parentId;
	
	@Column(name = "memo", columnDefinition = "TEXT")
	String memo;
	
	@Column(name = "record", columnDefinition = "VARCHAR(255)")
	String record;

}
