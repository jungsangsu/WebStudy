package member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;

@Repository("memberDAO")
@Transactional
public class MemberDAOmybatis implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDTO Select(MemberDTO memberDTO) {
		return sqlSession.selectOne("memberSQL.select", memberDTO);
	}

}
