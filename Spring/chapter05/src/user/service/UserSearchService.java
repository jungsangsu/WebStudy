package user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserSearchService implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");

		int number = input.nextInt();

		if (number == 1) {
			System.out.print("검색을 원하는 이름 입력 :");
			String name = input.next();
			list = userDAO.getListUsingName(name);
			for (UserDTO userDTO : list) {
				System.out.println(userDTO.toString());
			}
			
		} else if (number == 2) {
			System.out.print("검색을 원하는 아이디 입력 :");
			String id = input.next();
			list = userDAO.getListUsingID(id);
			for (UserDTO userDTO : list) {
				System.out.println(userDTO.toString());
			}
		} else {
			System.out.println("잘못입력했습니다.");
		}
	}

}
