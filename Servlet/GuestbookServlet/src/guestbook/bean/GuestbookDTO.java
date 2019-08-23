package guestbook.bean;

import lombok.Data;

@Data
public class GuestbookDTO {
	private String name;
	private String email;
	private String homepage;
	private String title;
	private String context;
	private String date;




	public GuestbookDTO() {

	}
	

}
