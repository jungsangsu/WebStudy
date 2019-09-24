package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

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
		boolean exist = false;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close();
		
		return result;
	}

	public List<ZipcodeDTO> getZipcodeList(ZipcodeDTO zipcodeDTO) {
		List<ZipcodeDTO> list = null;
		if(zipcodeDTO.getSido().length() > 0 || zipcodeDTO.getSigungu().length() > 0 || zipcodeDTO.getRoadname().length() > 0) {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			list= sqlSession.selectList("memberSQL.getZipList",zipcodeDTO); 
			sqlSession.close();
		}
		return list;
	}

}
