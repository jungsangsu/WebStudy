package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
@Service //데이터를 받고 가공하는 것은 서비스로 해주는게 좋음!
public class UserInsertService implements UserService {

	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		
		//데이터
		System.out.print("이름 입력 : ");
		String name = input.next();
		System.out.print("아이디 입력 : ");
		String id = input.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = input.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		System.out.println(userDTO.toString());
		
		userDAO.userWrite(userDTO);
		
	}

}
