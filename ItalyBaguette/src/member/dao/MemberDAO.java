package member.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static MemberDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int write(MemberDTO memberDTO) {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.insert("memberSQL.write", memberDTO);
		sqlSession.commit();
		sqlSession.close();

		return su;
	}

	public int update(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("memberSQL.update", memberDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;

	}

	public MemberDTO Select(MemberDTO memberDTO) {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result = sqlSession.selectOne("memberSQL.select", memberDTO);
		sqlSession.close();
		
		return result;
	}

	public MemberDTO isExistID(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close();
		return result;
	}

	public void applySession(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("memberSQL.applysession", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public MemberDTO sessionToDTO(String sessionKey) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result = sqlSession.selectOne("memberSQL.sessionToDTO", sessionKey);
		sqlSession.close();
		
		return result;
		
	}

	public void sessionClear(String sessionKey) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("memberSQL.sessionClear", sessionKey);
		sqlSession.commit();
		sqlSession.close();
	}

}
