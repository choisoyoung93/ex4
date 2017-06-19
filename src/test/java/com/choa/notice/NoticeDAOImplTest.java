package com.choa.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{
	
	@Autowired
	private NoticeDAOImpl dao;
	
	@Test
	public void connectionTest() throws Exception{
		//Assert.assertNotNull(sqlSession);
		
		/*BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(64);
		boardDTO.setWriter("choa");
		boardDTO.setTitle("dd");
		boardDTO.setContents("dkjf");
		int result = dao.boardUpdate(boardDTO);
		System.out.println("writer: "+boardDTO.getWriter() + ", title: "+ boardDTO.getTitle());*/
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker(null, null);
		List<BoardDTO> ar = dao.boardList(rowMaker);
		System.out.println("size: "+ ar.size());
		assertNotEquals(1, ar.size());
	}
}
