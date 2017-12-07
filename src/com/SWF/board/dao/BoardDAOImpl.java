package com.SWF.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.SWF.board.dto.BoardDTO;
import com.SWF.board.dto.MapDTO;
import com.SWF.board.dto.Page;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private String namespace ="com.SWF.mapper.BoardMapper";
	
	@Override
	public int selectBno() throws Exception {
		
		return session.selectOne(namespace+".selectBno");
	
	}
	
	@Override
	public int selectRecordCount(Page page) throws Exception {

		return session.selectOne(namespace+".selectRecordCount",page);
	
	}
	
	@Override
	public List<BoardDTO> selectList(Page page) throws Exception {

		return session.selectList(namespace+".selectList",page);
	
	}
	
	@Override
	public BoardDTO selectBoard(int bno) throws Exception {

		return session.selectOne(namespace+".selectBoard",bno);
	
	}
	
	@Override
	public void updateViewcnt(int bno) throws Exception {

		session.update(namespace+".updateViewcnt",bno);
		
	}
	
	@Override
	public void adjustViewcnt(int bno) throws Exception {

		session.update(namespace+".adjustViewcnt",bno);
		
	}
	
	@Override
	public MapDTO selectMap(int bno) throws Exception {

		return session.selectOne(namespace+".selectMap",bno);
	
	}
	
	@Override
	public void insertBoard(BoardDTO bDto) throws Exception {

		session.insert(namespace+".insertBoard",bDto);
		
	}
	
	@Override
	public void insertMap(MapDTO mDto) throws Exception {

		session.insert(namespace+".insertMap",mDto);
		
	}

	@Override
	public void updateReplycnt(int bno) throws Exception {

		session.update(namespace+".updateReplycnt",bno);
		
	}
	
	@Override
	public void deleteReplycnt(int bno) throws Exception {

		session.update(namespace+".deleteReplycnt",bno);
		
	}
	
	@Override
	public void updateBoard(BoardDTO dBto) throws Exception {
		
		session.update(namespace+".updateBoard",dBto);
		
	}
	
	@Override
	public void updateMap(MapDTO mDto) throws Exception {

		session.update(namespace+".updateMap",mDto);
		
	}
	
	@Override
	public void updateHiddenStatus(int bno) throws Exception {

		session.update(namespace+".updateHiddenStatus",bno);
		
	}
}
