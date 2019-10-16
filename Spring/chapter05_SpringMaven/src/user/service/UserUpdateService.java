package user.service;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력 : ");
		String id = input.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디가 없습니다");
		}else {
			System.out.println(userDTO.toString());
			System.out.print("수정할 이름 입력 :");
			String name = input.next();
			System.out.print("수정할 비밀번호 입력 :");
			String pwd = input.next();
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("name",name);
			map.put("pwd",pwd);
			
			userDAO.userUpdate(map);
			
			System.out.println("데이터를 수정하였습니다.");
		
		}
		
	
	}

}
