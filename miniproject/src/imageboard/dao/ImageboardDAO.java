package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import imageboard.bean.ImageboardDTO;
import member.dao.MemberDAO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static ImageboardDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}

	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int imageboardWrite(ImageboardDTO imageboardDTO) {

		int su = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		su = sqlSession.insert("imageboardSQL.imageboardWrite",imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}

	public int getTotalA() {
		int totalA = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("imageboardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}

	public List<ImageboardDTO> boardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.imageboardList", map);
		sqlSession.close();

		return list;
	}

	public ImageboardDTO getImageboard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ImageboardDTO temp = sqlSession.selectOne("imageboardSQL.getImageboard",seq);
		sqlSession.close();
		return temp;
	}

	public void boardDelete(List<String> list) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			sqlSession.delete("imageboardSQL.imageboardDelete",temp);
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
}
