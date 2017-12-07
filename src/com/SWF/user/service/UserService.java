package com.SWF.user.service;

import java.util.Date;
import java.util.List;

import com.SWF.user.dto.UserDTO;

public interface UserService {
	
	public List<String> getSidoList() throws Exception;
	public List<String> getGugunList(String sido) throws Exception;
	public List<String> getDongList(String gugun) throws Exception;
	
	public String sendValidationMail(String email) throws Exception; 
	
	public void join(UserDTO uDto) throws Exception;
	
	public int findPW(String email, String umsg) throws Exception;
	
	public UserDTO login(String email, String upw) throws Exception;
	
	public void saveLoginStatus(String email, String sessionid, Date sessionlimit) throws Exception;
	public UserDTO checkLoginStatus(String sessionid) throws Exception;
	
	public UserDTO getMyPage(String email) throws Exception;
	public int modifyMyInfo(UserDTO uDto, String modifyConfirm, Boolean isPwChange) throws Exception;
	public void Attendence(String email) throws Exception;
}
