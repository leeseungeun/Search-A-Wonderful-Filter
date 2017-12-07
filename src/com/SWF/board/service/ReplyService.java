package com.SWF.board.service;

import java.util.List;

import com.SWF.board.dto.Page;
import com.SWF.board.dto.ReplyDTO;

public interface ReplyService {
	
	public int replyCnt(Integer bno) throws Exception;
	public List<ReplyDTO> list(Integer bno, Page page) throws Exception;
	
	public void writeReply(Integer bno, ReplyDTO rDto) throws Exception;
	
	public void removeReply(Integer bno, Integer rno) throws Exception;
}
