package com.SWF.board.dao;

import java.util.List;

import com.SWF.board.dto.Page;
import com.SWF.board.dto.ReplyDTO;

public interface ReplyDAO {
	
	public int selectReplycnt(Integer bno) throws Exception;
	public List<ReplyDTO> selectReply(Integer bno, Page page) throws Exception;
	
	public void insertReply(Integer bno, ReplyDTO rDto) throws Exception;
	
	public void deleteReply(Integer bno, Integer rno) throws Exception;
}
