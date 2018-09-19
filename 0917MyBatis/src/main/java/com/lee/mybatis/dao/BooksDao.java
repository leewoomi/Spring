package com.lee.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lee.mybatis.domain.BooksVO;

//자동으로 bean을 생성해주는 어노테이션 
@Repository
public class BooksDao {

	// 동일한 자료형의 bean이 있으면 자동으로 주입받는 어노테이션
	//@Autowired
	private SqlSession sqlSession;

	// Books 테이블의 전체 데이터를 가져오는 메소드

	public List<BooksVO> booklist() {
		return sqlSession.selectList("books.booklist");
	}

	// Books 테이블의 code를 가지고
	// 하나의 데이터를 찾아오는 메소드

	public BooksVO selectbook(String code) {
		// 하나를 찾아오는 메소드 호출
		// 없으면 null을 리턴
		// 2개 이상이면 예외를 발생시킴.
		return sqlSession.selectOne("books.selectbook", code);

	}

	// Books 테이블에 데이터를 삽입하는 메소드
	public int insertbooks(BooksVO vo) {
		return sqlSession.insert("books.insertbooks", vo);
	}

	// Books 테이블에 데이터를 삽입하는 메소드
	public int insertproc(BooksVO vo) {
		return sqlSession.insert("books.insertproc", vo);
	}
	
	
}
