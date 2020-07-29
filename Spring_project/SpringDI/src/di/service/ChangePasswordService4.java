package di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import di.dao.Dao;
import di.domain.Member;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;

//컴포넌트 사용시 클래스 이름으로 들어가므로 이름을 지정해주긔
@Component("memberPwsvc")
public class ChangePasswordService4 {
	
	//어노테이션 사용 --> byType
	@Autowired
	private Dao dao;

	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = dao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		dao.update(member);
	}

}
