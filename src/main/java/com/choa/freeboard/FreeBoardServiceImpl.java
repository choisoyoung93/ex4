package com.choa.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
//import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
public class FreeBoardServiceImpl implements BoardService{
	@Autowired
	private FreeBoardDAOImpl freeBoardDAO;
	
	
	
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		PageMaker pageMaker = new PageMaker(curPage);
		RowMaker rowMaker = pageMaker.getRowMaker(null, null);
		//int totalCount = freeBoardDAO.freeBoardCount();	
		//MakePage makePage = pageMaker.getMakePage(totalCount);
		List<BoardDTO> freeBoardArr = freeBoardDAO.boardList(rowMaker);
		return freeBoardArr;
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		BoardDTO freeBoardDTO = freeBoardDAO.boardView(num);
		freeBoardDAO.boardHit(num);
		return freeBoardDTO;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return freeBoardDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return freeBoardDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return freeBoardDAO.boardDelete(num);
	}
}
