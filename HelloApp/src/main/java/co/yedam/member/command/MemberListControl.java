package co.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceMybatis;

public class MemberListControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 0207 8교시
		MemberService service = new MemberServiceMybatis();
		req.setAttribute("memberList", service.memberList());
		
		
			try {
				req.getRequestDispatcher("WEB-INF/member/memberList.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
