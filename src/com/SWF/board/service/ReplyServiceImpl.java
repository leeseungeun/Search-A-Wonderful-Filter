package com.SWF.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SWF.board.dao.BoardDAO;
import com.SWF.board.dao.ReplyDAO;
import com.SWF.board.dto.Page;
import com.SWF.board.dto.ReplyDTO;
import com.SWF.user.dao.UserDAO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO rDao;
	
	@Inject
	private BoardDAO bDao;
	
	@Inject
	private UserDAO uDao;
	
	@Override
	public int replyCnt(Integer bno) throws Exception {
	
		return rDao.selectReplycnt(bno);
	
	}
	
	@Override
	public List<ReplyDTO> list(Integer bno, Page page) throws Exception {
		
		return rDao.selectReply(bno, page);
	
	}
	
	@Transactional
	@Override
	public void writeReply(Integer bno, ReplyDTO rDto) throws Exception {
		
		rDao.insertReply(bno, rDto);
		bDao.updateReplycnt(bno);
		uDao.updatePoint(rDto.getRwriter(), 3);
	}
	
	@Transactional
	@Override
	public void removeReply(Integer bno, Integer rno) throws Exception {
		
		rDao.deleteReply(bno, rno);
		bDao.deleteReplycnt(bno);
		
	}
	
}
