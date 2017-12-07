package com.SWF.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.SWF.board.dto.BoardDTO;
import com.SWF.board.dto.MapDTO;
import com.SWF.board.dto.Page;

@Service
public interface BoardService {

	public int getBno() throws Exception;
	
	public int cout4list(Page page) throws Exception;
	public List<BoardDTO> list(Page page) throws Exception;
	
	public void writeBoard(BoardDTO bDto, MapDTO mDto) throws Exception;
	
	public Map<String, Object> readBoard(int bno) throws Exception;
	
	public void modifyBoard(BoardDTO bDto, MapDTO mDto) throws Exception;
	
	public void removeBoard(int bno) throws Exception;
}
