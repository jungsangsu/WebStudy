package member.service;

import member.bean.MemberDTO;

public interface MemberService {
	public MemberDTO login(String id, String pwd);
}
