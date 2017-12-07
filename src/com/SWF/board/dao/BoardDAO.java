package com.SWF.board.dao;

import java.util.List;

import com.SWF.board.dto.BoardDTO;
import com.SWF.board.dto.MapDTO;
import com.SWF.board.dto.Page;

public interface BoardDAO {
	
	public int selectBno() throws Exception;
	
	public int selectRecordCount(Page page) throws Exception;
	public List<BoardDTO> selectList(Page page) throws Exception;
	
	public void insertBoard(BoardDTO bDto) throws Exception;
	
	public BoardDTO selectBoard(int bno) throws Exception;
	public void updateViewcnt(int bno) throws Exception;
	public void adjustViewcnt(int bno) throws Exception;
	
	public void insertMap(MapDTO mDto) throws Exception;
	
	public MapDTO selectMap(int bno) throws Exception;
	
	public void updateReplycnt(int bno) throws Exception;
	public void deleteReplycnt(int bno) throws Exception;
	
	public void updateBoard(BoardDTO dBto) throws Exception;
	public void updateMap(MapDTO mDto) throws Exception;
	
	public void updateHiddenStatus(int bno) throws Exception;
}
