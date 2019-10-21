package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public List<UserDTO> getList();

	public UserDTO getUser(String id);

	public void modify(UserDTO userDTO);

	public void delete(String id);

	public UserDTO checkID(String id);

	public List<UserDTO> search(String key, String content);
	
}
