package co.yedam.member.mapper;

import java.util.List;

import co.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO login(MemberVO member);
	public int addMember(MemberVO member); //등록
	public List<MemberVO> memberList(); //회원전체목록
}

