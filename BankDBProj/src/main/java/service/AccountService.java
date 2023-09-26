package service;

import java.util.List;

import dao.AccountDao;
import dto.Account;

public class AccountService {

	private AccountDao dao = new AccountDao();
	
	public void makeAccount(Account acc) throws Exception {
		Account sacc = dao.selectAccount(acc.getId());
		if(sacc != null) throw new Exception("계좌번호가 중복됩니다.");
		dao.insertAccount(acc);
	}
	
	public Account searchForId(String id) throws Exception {
		Account acc = dao.selectAccount(id);
		if(acc == null) throw new Exception("계좌번호가 틀립니다.");
		return acc;
	}
	
	public List<Account> allAccountInfo() throws Exception{
		List<Account> accs = dao.selectAllAccount();
		if(accs == null) throw new Exception("개설된 계좌가 없습니다.");
		return accs;
	}
	public int deposit(String id,Integer money) throws Exception {
		int cnt = 0;
		Account acc = dao.selectAccount(id);
		
		
		return cnt;
	}
	
}
