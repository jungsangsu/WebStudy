package hacksa;

import java.util.ArrayList;
import java.util.List;

public interface Score {
	public void input(String id, String name, String kor, String eng, String math);
	public ArrayList<ScoreDTO> returnTolist();
	public ScoreDTO search(int id);
	public boolean conditionID(int id);
	
}
