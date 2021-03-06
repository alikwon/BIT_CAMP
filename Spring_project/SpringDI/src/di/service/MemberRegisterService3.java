package di.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import di.dao.Dao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;

public class MemberRegisterService3 {

	//어노테이션 사용 --> byType
	@Autowired
	private Dao dao;

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
