package com.ssafy.web.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="parent")
public class Parent {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int parent_no;
	
//	@Column(name="user_id")
//	String user_id;
	@Column(name="name", columnDefinition = "VARCHAR(20)", nullable=false)
	String name;
	@Column(name="email", columnDefinition = "VARCHAR(50)", nullable=false)
	String email;
	@Column(name="phone", columnDefinition = "VARCHAR(20)", nullable=false)
	String phone;
	@Column(name="address", columnDefinition = "VARCHAR(80)", nullable=false)
	String address;
	
	public Parent() {}
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="parent_id", referencedColumnName = "user_id")
	private User user;

	
}