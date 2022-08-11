package com.ssafy.web.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.web.db.entity.Consult;

public interface ConsultRepository extends JpaRepository<Consult, Integer> {

}
