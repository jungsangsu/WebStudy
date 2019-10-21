package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public List<UserDTO> getList() {
		return userDAO.getList();
	}

	@Override
	public UserDTO getUser(String id) {
		if(userDAO.checkID(id)!=null) {
			return userDAO.checkID(id);
		}else {
			return null;
		}
		
	}

	@Override
	public void modify(UserDTO userDTO) {
		userDAO.modify(userDTO);
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
	}

	@Override
	public UserDTO checkID(String id) {
		return userDAO.checkID(id);
	}

	@Override
	public List<UserDTO> search(String key, String content) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("key",key );
		map.put("content",content);
		return userDAO.search(map);
	}
	
	
	

	
}








