package com.lee.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lee.mybatis.domain.BooksVO;

public interface BooksInterface {
	@Select("select * from books")
	public List<BooksVO> listbooks();
	
	@Select("select * from books where code=#{code}")
	public BooksVO selectbook(String code);
	
	
	
}
