package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import service.Service;

public class MemberEditFormServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/member/memberEditForm.jsp";
	}

}
