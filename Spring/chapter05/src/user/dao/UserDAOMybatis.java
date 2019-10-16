package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional
@Repository("userDAO")
public class UserDAOMybatis implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void userWrite(UserDTO userDTO) {
		sqlSession.insert("userSQL.userWrite", userDTO);
	}

	@Override
	public List<UserDTO> getuserList() {
		try {
			return sqlSession.selectList("userSQL.getuserList");
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UserDTO getUser(String id) {
		try {
			return sqlSession.selectOne("userSQL.getUser", id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void userUpdate(HashMap<String, String> map) {
		sqlSession.update("userSQL.userUpdate", map);
	}

	@Override
	public void deleteUser(String id) {
		sqlSession.delete("userSQL.deleteUser", id);
	}

	@Override
	public List<UserDTO> getListUsingName(String name) {
		try {
			return sqlSession.selectList("userSQL.getListUsingName", name);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserDTO> getListUsingID(String id) {
		try {
			return sqlSession.selectList("userSQL.getListUsingID", id);
		} catch (Exception e) {
			return null;
		}
	
	}

	
	
	
}
