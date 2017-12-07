package com.SWF.user.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.SWF.user.dto.AttendenceDTO;
import com.SWF.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.SWF.mapper.UserMapper";
	
	@Override
	public List<String> selectSido() throws Exception {

		return session.selectList(namespace+".selectSido");
	
	}
	
	@Override
	public List<String> selectGugun(String sido) throws Exception {
	
		return session.selectList(namespace+".selectGugun",sido);
	
	}
	
	@Override
	public List<String> selectDong(String gugun) throws Exception {

		return session.selectList(namespace+".selectDong",gugun);
	
	}
	
	@Override
	public AttendenceDTO selectMaxLogindt(String email) throws Exception {

		return session.selectOne(namespace+".selectMaxLogindt",email);
	
	}
	
	@Override
	public void insertLoginInfo(AttendenceDTO aDto) throws Exception {
		
		session.insert(namespace+".insertLoginInfo",aDto);
		
	}
	
	@Override
	public UserDTO selectUser(String email) throws Exception {

		return session.selectOne(namespace+".selectUser",email);
	
	}
	
	@Override
	public void insertUser(UserDTO uDto) throws Exception {
		
		session.insert(namespace+".insertUser",uDto);
		
	}
	
	@Override
	public void updateUser(Boolean isPwChange, UserDTO uDto) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isPwChange", isPwChange);
		paramMap.put("uDto", uDto);
		
		session.update(namespace+".updateUser",paramMap);
		
	}
	
	@Override
	public void updateTmpPW(String email, String tmppw) throws Exception {

		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("tmppw", tmppw);
		
		session.update(namespace+".updateTmpPW",paramMap);
		
	}
	
	@Override
	public void updatePoint(String email, int upoint) throws Exception {
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("upoint", upoint);
		
		session.update(namespace+".updatePoint",paramMap);
	}

	@Override
	public void updatePointMinus(String email, int upoint) throws Exception {
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("upoint", upoint);
		
		session.update(namespace+".updatePointMinus",paramMap);
	}
	
	@Override
	public void updateSessionInfo(String email, String sessionid, Date sessionlimit) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("sessionid", sessionid);
		paramMap.put("sessionlimit", sessionlimit);
		
		session.update(namespace+".updateSessionInfo", paramMap);
		
	}
	
	@Override
	public UserDTO selectWithSessionId(String sessionid) throws Exception {

		return session.selectOne(namespace+".selectWithSessionId",sessionid);
	
	}
}
