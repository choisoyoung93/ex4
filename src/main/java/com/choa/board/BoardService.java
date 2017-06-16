package com.choa.board;

import java.util.List;

public interface BoardService {
	//List
	public List<BoardDTO> boardList(int curPage) throws Exception;
	
	//View
	public BoardDTO boardView(int num) throws Exception;
	
	//Write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	//Update
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	//Delete
	public int boardDelete(int num) throws Exception;
}
