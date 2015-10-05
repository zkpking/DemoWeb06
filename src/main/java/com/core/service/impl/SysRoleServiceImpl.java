package com.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.core.service.ISysRoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.dao.ISysRoleMapper;

@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl implements ISysRoleService {

	@Resource
	private ISysRoleMapper mapper;

	@Override
	public int insert(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		return mapper.select(obj);
	}

	@Override
	public int getCount(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectObjList(Object obj) {
		// TODO Auto-generated method stub	
		return mapper.selectObjList(obj);
	}

	
}
