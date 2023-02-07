package co.yedam.member.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceMybatis;
import co.yedam.member.vo.MemberVO;

public class SignOnControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 0207 6교시-2
		//form:multipart/form-data => 처리(MultipartRequest)
		//생성자 매개값: 1)요청정보, 2)저장경로, 3)최대파일사이즈지정, 4)인코딩, 5)리네임정책(같은이름이 있을때)\
		String savePath = req.getServletContext().getRealPath("/images"); //프로젝트 제일 상위 이름 가져올때. getServletContext
		int maxSize = (1024 * 1024 * 10); //kB MB 10MB
		String encoding = "utf-8";
		
		try {
			//파일업로드 서블릿. 0207 7교시
			MultipartRequest multi = 
					new MultipartRequest(req, savePath ,maxSize, encoding, new DefaultFileRenamePolicy());
			
			String id = multi.getParameter("member_id");
			String pw = multi.getParameter("member_pw");
			String nm = multi.getParameter("member_name");
			String ph = multi.getParameter("member_phone");
			String fileName = "";
			
			Enumeration<?> files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement(); //이름만 읽음.
				System.out.println(file);
				fileName = multi.getFilesystemName(file); //중복됐을때 이름이 자동으로 바뀌는데 그 바뀐 것을 읽어줌.
			}
			
			MemberVO member = new MemberVO();
			member.setMemberId(id);
			member.setMemberPw(pw);
			member.setMemberName(nm);
			member.setMemberPhone(ph);
			member.setImage(fileName);
			
			MemberService service = new MemberServiceMybatis();
			//0207 7교시
			if (service.addMember(member)>0) {
				resp.sendRedirect("empList.do");
			} else {
				resp.sendRedirect("errorPage.do");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
