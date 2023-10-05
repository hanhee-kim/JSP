package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDaoImpl implements BoardDao{

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertBoard(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board);
		sqlSession.commit();
	}

	@Override
	public List<Board> selectBoardSubject(String subject, Integer row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectBoardWriter(String writer, Integer row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectBoardContent(String content, Integer row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectBoardAll(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardAll", row);
	}

	@Override
	public Integer selectBoardCount() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}

	

}
