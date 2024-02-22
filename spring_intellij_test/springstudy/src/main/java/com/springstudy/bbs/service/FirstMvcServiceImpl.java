package com.springstudy.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.bbs.dao.FirstMvcDao;

@Service
public class FirstMvcServiceImpl implements FirstMvcService {
	
	@Autowired
	private FirstMvcDao firstMvcDao;
	
	public void setFirstMvcDao(FirstMvcDao firstMvcDao) {
		this.firstMvcDao = firstMvcDao;
	}
	
	@Override
	public String getMessage(int no, String id) {
		return firstMvcDao.getMessage(no, id);
	}
}
