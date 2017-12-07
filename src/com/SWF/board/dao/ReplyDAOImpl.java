package com.SWF.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.SWF.board.dto.Page;
import com.SWF.board.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.SWF.mapper.ReplyMapper";
	
	@Override
	public int selectReplycnt(Integer bno) throws Exception {

		return session.selectOne(namespace+".selectReplycnt",bno);
	
	}
	
	@Override
	public List<ReplyDTO> selectReply(Integer bno, Page page) throws Exception {

		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("bno", bno);
		paramMap.put("page",page);
		
		return session.selectList(namespace+".selectList",paramMap);
	
	}
	
	@Override
	public void insertReply(Integer bno, ReplyDTO rDto) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", bno);
		paramMap.put("rDto", rDto);
		
		session.insert(namespace+".insertReply",paramMap);
		
	}
	
	@Override
	public void deleteReply(Integer bno, Integer rno) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", bno);
		paramMap.put("rno", rno);
		
		session.update(namespace+".deleteReply",paramMap);
		
	}

}
