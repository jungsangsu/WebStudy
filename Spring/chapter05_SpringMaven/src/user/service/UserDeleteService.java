package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("삭제할 ID를 입력하세요");
		String id = input.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("삭제할 ID가 없습니다.");
		}else {
			userDAO.deleteUser(id);
			System.out.println("데이터가 삭제되었습니다.");
		}
	}

}
