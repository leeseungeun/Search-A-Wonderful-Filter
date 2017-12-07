package com.SWF.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SWF.board.dao.BoardDAO;
import com.SWF.board.dto.BoardDTO;
import com.SWF.board.dto.MapDTO;
import com.SWF.board.dto.Page;
import com.SWF.user.dao.UserDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bDao;
	
	@Inject
	private UserDAO uDao;
	
	@Override
	public int getBno() throws Exception {

		return bDao.selectBno();
	
	}
	
	@Override
	public int cout4list(Page page) throws Exception {

		return bDao.selectRecordCount(page);
	
	}
	
	@Override
	public List<BoardDTO> list(Page page) throws Exception {

		return bDao.selectList(page);
	
	}
	
	@Transactional
	@Override
	public void writeBoard(BoardDTO bDto, MapDTO mDto) throws Exception {

		bDao.insertBoard(bDto);
		bDao.insertMap(mDto);
		uDao.updatePoint(bDto.getBwriter(), 10);
	}
	
	@Transactional
	@Override
	public Map<String, Object> readBoard(int bno) throws Exception {
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("bDto", bDao.selectBoard(bno));
		result.put("mDto", bDao.selectMap(bno));
		
		bDao.updateViewcnt(bno);
		
		return result;
	}
	
	@Transactional
	@Override
	public void modifyBoard(BoardDTO bDto, MapDTO mDto) throws Exception {
		
		bDao.updateBoard(bDto);
		bDao.updateMap(mDto);
		
		bDao.adjustViewcnt(bDto.getBno());
		
	}
	
	@Override
	public void removeBoard(int bno) throws Exception {

		bDao.updateHiddenStatus(bno);
		
	}
	
}
