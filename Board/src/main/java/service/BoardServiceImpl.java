package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BoardDao;
import dao.BoardDaoImpl;
import dto.Board;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;

	// 기본생성자호출시 boardDao객체 생성
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}

	// 게시글 작성(insert)
	@Override
	public void boardWrite(Board board) throws Exception {
		boardDao.insertBoard(board);
		System.out.println("Service의 boardWrite호출");
	}

	// Page
	@Override
	public Map<String, Object> boardListByPage(Integer page) throws Exception {
		PageInfo pageInfo = new PageInfo();
		// 전체 데이터 개수를 알아오는 쿼리문이 필요.
		Integer boardCount = boardDao.selectBoardCount();
		Integer maxPage = (int) Math.ceil((double) boardCount / 10);
		// ceil은 소수점 무조건 올림 ,
		// page가 모두 10의 배수는 아니기때문에 하나를 double로 만들어주고 10으로 나눴을때 소숫점아래가 남아있도록 만든다.
		int startPage = (page - 1) / 10 * 10 + 1;
//		(page-1)/10*10 : 만약 15페이지면 10페이지로 만들어줌 
//		+1 :  현재 페이지가 뭐든간에 ( 1,11,21,31,41 ...)
		int endPage = startPage + 10 - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);

		int row = (page - 1) * 10 + 1; // 특정 페이지의 시작 행(순번?)
		List<Board> boardList = boardDao.selectBoardAll(row - 1);

		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", pageInfo);
		map.put("boardList", boardList);
		return map;
	}

}
