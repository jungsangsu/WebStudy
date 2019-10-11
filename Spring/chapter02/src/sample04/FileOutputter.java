package sample04;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath, fileName;


	public void setFilePath(String filePath) {
		System.out.println("setFilePath 메소드");
		this.filePath = filePath;
	}

	public void setFileName(String fileName) {
		System.out.println("setFileName 메소드");
		this.fileName = fileName;
	}
	
	
	@Override
	public void output(String message) {
		//파일로 출력
		System.out.println("output메소드");
		try {
			FileWriter fileWriter = new FileWriter(filePath+fileName);
			fileWriter.write(message);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
