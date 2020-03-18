package spring;

public class ChangePasswordService {

	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) throws WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);
		if(member == null) 
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) { // 의존하는 MemberDao를 전달 받는다. 즉 세터를 통해서 의존 객체를 주입받는다.
		this.memberDao = memberDao;
	}
}
