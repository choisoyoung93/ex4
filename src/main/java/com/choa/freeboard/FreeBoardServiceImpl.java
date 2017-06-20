package com.choa.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.RowMaker;

@Service
public class FreeBoardServiceImpl implements BoardService{
	@Autowired
	private FreeBoardDAOImpl freeBoardDAO;
	
	
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		List<BoardDTO> freeBoardArr = freeBoardDAO.boardList(rowMaker);
		return freeBoardArr;
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		freeBoardDAO.boardHit(num);
		BoardDTO freeBoardDTO = freeBoardDAO.boardView(num);
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
	
	@Override
	public int boardCount(RowMaker rowMaker) throws Exception {
		return freeBoardDAO.boardCount(rowMaker);
	}
	
	public int boardReply(FreeBoardDTO freeBoardDTO) throws Exception {
		return freeBoardDAO.boardReply(freeBoardDTO);
	}
}
