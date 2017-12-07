package com.SWF.user.dao;

import java.util.Date;
import java.util.List;

import com.SWF.user.dto.AttendenceDTO;
import com.SWF.user.dto.UserDTO;

public interface UserDAO {

	public List<String> selectSido() throws Exception;
	public List<String> selectGugun(String sido) throws Exception;
	public List<String> selectDong(String gugun) throws Exception;
	
	public UserDTO selectUser(String email) throws Exception;
	
	public void insertUser(UserDTO uDto) throws Exception;
	public void updateUser(Boolean isPwChange, UserDTO uDto) throws Exception;
	
	public void updateTmpPW(String email, String tmppw) throws Exception;
	
	public void updateSessionInfo(String email, String sessionid, Date sessionlimit) throws Exception;
	public UserDTO selectWithSessionId(String sessionid) throws Exception;
	
	public void updatePoint(String email, int upoint) throws Exception;
	public void updatePointMinus(String email, int upoint) throws Exception;
	
	public AttendenceDTO selectMaxLogindt(String email) throws Exception;
	public void insertLoginInfo(AttendenceDTO aDto) throws Exception;
	
}
