package com.lee.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	//id 중복 체크하는 메소드 
	public String idcheck(String id) {
		return sqlSession.selectOne("login.idcheck",id);
	}
}
