package com.choa.notice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
//import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
//NoticeService noticeService = new NoticeService();
public class NoticeServiceImpl implements BoardService{
	@Autowired
	private NoticeDAOImpl noticeDAO;
	
	/*public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}*/

	
	
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		PageMaker pageMaker = new PageMaker(curPage);
		RowMaker rowMaker = pageMaker.getRowMaker(null, null);
		//int totalCount = noticeDAO.boardCount();	
		//MakePage makePage = pageMaker.getMakePage(totalCount);
		List<BoardDTO> noticeArr = noticeDAO.boardList(rowMaker);
		return noticeArr;
	}
	
	@Override
	public BoardDTO boardView(int num) throws Exception {
		BoardDTO noticeDTO = noticeDAO.boardView(num);		
		noticeDAO.boardHit(num);
		return noticeDTO;
	}
	
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}
	
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}
	
	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
}
