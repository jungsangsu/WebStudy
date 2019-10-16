package user.dao;

import java.util.HashMap;
import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {
	public void userWrite(UserDTO userDTO);

	public List<UserDTO> getuserList();

	public UserDTO getUser(String id);

	public void userUpdate(HashMap<String, String> map);

	public void deleteUser(String id);

	public List<UserDTO> getListUsingName(String name);

	public List<UserDTO> getListUsingID(String id);
}
