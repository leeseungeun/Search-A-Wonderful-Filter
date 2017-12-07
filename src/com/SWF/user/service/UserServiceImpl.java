package com.SWF.user.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SWF.user.dao.UserDAO;
import com.SWF.user.dto.AttendenceDTO;
import com.SWF.user.dto.UserDTO;
import com.SWF.utils.MailApp;
import com.SWF.utils.RandomNumberGenerator;

@Service
public class UserServiceImpl implements UserService{
	
	Logger logger = LoggerFactory.getLogger(UserDAO.class);
	@Inject
	private UserDAO uDao;
	
	@Override
	public List<String> getSidoList() throws Exception {
		
		return uDao.selectSido();
	
	}
	
	@Override
	public List<String> getGugunList(String sido) throws Exception {
		
		return uDao.selectGugun(sido);
	
	}
	
	@Override
	public List<String> getDongList(String gugun) throws Exception {

		return uDao.selectDong(gugun);
	
	}
	
	@Override
	public String sendValidationMail(String email) throws Exception {
		if(uDao.selectUser(email)!=null){
			
			return "0";
		
		}
		
		String title = "Search Wonderful Filter 회원 가입 인증 번호입니다.";
		
		String givenAuthNum = RandomNumberGenerator.generateRandomNum();
		
		StringBuilder content = new StringBuilder("귀하의 인증 번호는 ");
		content.append(givenAuthNum);
		content.append("입니다.");
		
		new MailApp(email,title,content.toString());
		
		return givenAuthNum;
	}
	
	@Override
	public void join(UserDTO uDto) throws Exception {
		
		uDao.insertUser(uDto);
		
	}
	
	@Override
	public int findPW(String email, String umsg) throws Exception {
	
		UserDTO uDto = uDao.selectUser(email);
		
		if(uDto!=null){
			
			if(uDto.getUmsg().equals(umsg)){
				
				String tmppw = RandomNumberGenerator.generateRandomNum();
				uDao.updateTmpPW(email,tmppw);
				
				String title = "Search Wonderful Filter 임시 비밀번호입니다.";
				
				StringBuilder content = new StringBuilder("귀하의 임시 비밀번호는 ");
				content.append(tmppw);
				content.append("입니다.");
				
				new MailApp(email,title,content.toString());

				return 1;
			}
			
			return 0;
			
		} else{
			
			return -1;
		
		}
	
	}
	
	@Transactional
	@Override
	public void Attendence(String email) throws Exception{
		
		AttendenceDTO aDto = uDao.selectMaxLogindt(email);
		int loginseq = 0;
		int upoint = 0;
		
		if(aDto != null) {
			
			loginseq = aDto.getLoginseq();
			
			Date lastLogin = aDto.getLogindt();
			Calendar maxLogindt = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
			maxLogindt.setTime(lastLogin);
			
			Calendar today00 = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
			today00.set(Calendar.HOUR_OF_DAY, 0);
			today00.set(Calendar.MINUTE, 0);
			today00.set(Calendar.SECOND, 0);
			today00.set(Calendar.MILLISECOND, 0);
			
			Calendar yesterday24 = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
			yesterday24.add(Calendar.DAY_OF_MONTH, -1);
			yesterday24.set(Calendar.HOUR_OF_DAY, 23);
			yesterday24.set(Calendar.MINUTE, 59);
			yesterday24.set(Calendar.SECOND, 59);
			yesterday24.set(Calendar.MILLISECOND, 999);
			
			Calendar twoDaysBefore24 = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
			twoDaysBefore24.add(Calendar.DAY_OF_MONTH, -2);
			twoDaysBefore24.set(Calendar.HOUR_OF_DAY, 23);
			twoDaysBefore24.set(Calendar.MINUTE, 59);
			twoDaysBefore24.set(Calendar.SECOND, 59);
			twoDaysBefore24.set(Calendar.MILLISECOND, 999);
			
			if(maxLogindt.before(yesterday24)){
				upoint = 5;
				
				if(maxLogindt.after(twoDaysBefore24) && maxLogindt.before(today00)){
					loginseq = aDto.getLoginseq()+1;
					if(aDto.getLoginseq()!= 0 && aDto.getLoginseq()%6 == 0){
						upoint = 20;
					}
				
				}
			}
		}
		
		AttendenceDTO newADto = new AttendenceDTO();
		newADto.setEmail(email);
		newADto.setLoginseq(loginseq);
		uDao.insertLoginInfo(newADto);
		uDao.updatePoint(email, upoint);
		
		
	}
	
	@Override
	public UserDTO login(String email, String upw) throws Exception {
		
		UserDTO uDto = uDao.selectUser(email);
		
		if(uDto != null){

			if(!(uDto.getUpw().equals(upw))){
				
				uDto=null;
			
			}
		}
		return uDto;
	
	}
	
	@Override
	public void saveLoginStatus(String email, String sessionid, Date sessionlimit) throws Exception {
		
		uDao.updateSessionInfo(email, sessionid, sessionlimit);
		
	}
	
	@Override
	public UserDTO checkLoginStatus(String sessionid) throws Exception {

		return uDao.selectWithSessionId(sessionid);
	
	}
	
	@Override
	public UserDTO getMyPage(String email) throws Exception {
		
		return uDao.selectUser(email);
	
	}
	
	@Override
	public int modifyMyInfo(UserDTO uDto, String modifyConfirm, Boolean isPwChange) throws Exception {
		
		String upw = uDao.selectUser(uDto.getEmail()).getUpw();
		
		if(modifyConfirm.equals(upw)){
			uDao.updateUser(isPwChange, uDto);
			return 1;
		} else{
			return 0;
		}
		
	}
}
