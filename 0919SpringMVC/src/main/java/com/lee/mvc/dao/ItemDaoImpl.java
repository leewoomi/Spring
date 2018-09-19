package com.lee.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lee.mvc.domain.Item;
@Repository
public class ItemDaoImpl implements ItemDao {

	//MyBatis 실행 객체를 주입 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Item> listItem() {
	
		return sqlSession.selectList("item.listitem");
	}

	public Item getItem(int itemid) {
		
		return sqlSession.selectOne("item.getitem",itemid);
	}

}
