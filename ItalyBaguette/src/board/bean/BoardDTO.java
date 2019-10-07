package board.bean;
import lombok.Data;

@Data
public class BoardDTO {
	private int seq;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	
	private int ref; //그룹
	private int lev; //레벨 라인
	private int step; //글순서
	private int pseq; //원글번호
	private int reply; //댓글수
	
	private int hit; //조회수
	
	private String logtime;
	
}
