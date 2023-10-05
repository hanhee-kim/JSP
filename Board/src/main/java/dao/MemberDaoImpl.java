package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Member;
import util.MybatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao{

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public Member selectMember(String id) throws Exception {
		return sqlSession.selectOne("mapper.member.selectMember", id);
		
	}

	@Override
	public void insertMember(Member member) throws Exception {
		System.out.println("daoImpl실행");
		sqlSession.insert("mapper.member.insertMember",member);
		sqlSession.commit(); //insert , delete ,update시 커밋을 해주어야함
	}
	

}
