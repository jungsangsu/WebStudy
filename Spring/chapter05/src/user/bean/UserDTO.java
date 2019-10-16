package user.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserDTO {
	private String name;
	private String id;
	private String pwd;
}
