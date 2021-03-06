package com.choa.freeboard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.RowMaker;

@Repository
public class FreeBoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "freeBoardMapper.";	
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {		
		return sqlSession.selectList(NAMESPACE+"list", rowMaker);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {		
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", num);
	}

	@Override
	public int boardCount(RowMaker rowMaker) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count", rowMaker);
	}

	@Override
	public void boardHit(int num) throws Exception {
		sqlSession.update(NAMESPACE+"hit", num);
	}
	
	public int boardReply(FreeBoardDTO freeBoardDTO){
		FreeBoardDTO pDTO = sqlSession.selectOne(NAMESPACE+"view", freeBoardDTO.getNum());
		sqlSession.update(NAMESPACE+"replyUpdate", pDTO);
		freeBoardDTO.setRef(pDTO.getRef());
		freeBoardDTO.setStep(pDTO.getStep()+1);
		freeBoardDTO.setDepth(pDTO.getDepth()+1);
		return sqlSession.insert(NAMESPACE+ "reply", freeBoardDTO);
	}
}
