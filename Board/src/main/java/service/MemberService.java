package service;

import dto.Member;

public interface MemberService {
//서비스에는 CRUD와 관련되게 쓰지 않는다. 정확하게 무슨 기능을 하는지를 작성할것
	
	Member login(String id,String password) throws Exception;
	void join(Member member) throws Exception;
}
