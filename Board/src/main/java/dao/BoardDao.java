package dao;

import java.util.List;

import dto.Board;

public interface BoardDao {
	void insertBoard(Board board) throws Exception;
	List<Board> selectBoardSubject(String subject,Integer row) throws Exception;
	List<Board> selectBoardWriter(String writer,Integer row) throws Exception;
	List<Board> selectBoardContent(String content,Integer row) throws Exception;
	List<Board> selectBoardAll(Integer row)throws Exception;
	Integer selectBoardCount() throws Exception;
	
}
