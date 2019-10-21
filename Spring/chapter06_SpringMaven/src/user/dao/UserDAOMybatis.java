package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Repository("userDAO")
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public List<UserDTO> getList() {
		return sqlSession.selectList("userSQL.getList");
	}

	@Override
	public UserDTO checkID(String id) {
		try {
			return sqlSession.selectOne("userSQL.checkID", id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void modify(UserDTO userDTO) {
		sqlSession.update("userSQL.modify", userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}

	@Override
	public List<UserDTO> search(Map<String, String> map) {
		return sqlSession.selectList("userSQL.search", map);
	}
	
	
}













