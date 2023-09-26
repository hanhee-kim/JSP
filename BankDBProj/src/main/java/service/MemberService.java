package service;

import dao.MemberDao;
import dto.Member;

public class MemberService { 	//실제 서비스를 구현하는 곳
	private MemberDao dao = new MemberDao();
	
	public void join(Member member) {
		dao.insertMember(member);
	}

	public Member login(String id,String password) throws Exception{
		Member member = dao.selectMember(id);
		if(member==null) throw new Exception("ID가 틀립니다.");
		if(!member.getPassword().equals(password)) throw new Exception("Password가 틀립니다.");
		member.setPassword(null);
		return member;
		
		
	}
}
