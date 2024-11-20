package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RegisterBean;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterBean, Integer>{
	// 不需要自定義方法，JpaRepository 已經提供了基本的 CRUD 操作	
}