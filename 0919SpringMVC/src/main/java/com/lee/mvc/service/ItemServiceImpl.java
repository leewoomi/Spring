package com.lee.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mvc.dao.ItemDao;
import com.lee.mvc.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	//파라미터가 없는 경우 Dao 메소드의 결과를 바로 리턴 
	public List<Item> listItem() {
	
		return itemDao.listItem();
	}
	
	@Override
	public Item getItem(int itemid) {
		return itemDao.getItem(itemid);
	}

}
