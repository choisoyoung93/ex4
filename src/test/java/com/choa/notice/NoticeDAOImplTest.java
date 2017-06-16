package com.choa.notice;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{
	@Autowired
	private NoticeDAOImpl noticeDAO;
	
	//@Test
	public void test() throws Exception{
		NoticeDAOImpl noticeDAO = new NoticeDAOImpl();
		noticeDAO.boardView(1);		//무조건 Null이 뜬다
										//DAO객체를 만들기 위해서는 DataSource가 필요 (Inject)
										// new NoticeDAO(); 객체 생성하면 Inject x
		 
		
		BoardDTO noticeDTO = noticeDAO.boardView(1);
		System.out.println(noticeDTO.getTitle());
		Assert.assertNotNull(noticeDTO);
	}
	
	@Test
	public void test2() throws Exception{
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker(null, null);
		List<BoardDTO> ar = noticeDAO.boardList(rowMaker);
		Assert.assertNotEquals(0, ar.size());
	}
}
