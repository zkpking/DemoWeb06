package com.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.ISysUserMapper;
import com.core.service.ISysUserService;

@Service("sysUserService")
@Transactional
public class SysUserServiceImpl implements ISysUserService {

	@Resource
	private ISysUserMapper mapper;
	
	public int insert(Object obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return mapper.delete(obj);
	}

	public int update(Object obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	public Object select(Object obj) {
		// TODO Auto-generated method stub
		return mapper.select(obj);
	}

	public int getCount(Object obj) {
		// TODO Auto-generated method stub
		return mapper.getCount(obj);
	}

	public List selectObjList(Object obj) {
		// TODO Auto-generated method stub
		return mapper.selectObjList(obj);
	}
	
}
