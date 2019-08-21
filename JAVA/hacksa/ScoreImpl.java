package hacksa;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ScoreImpl implements Score{

	private ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();
	
	@Override
	public void input(String id, String name, String kor, String eng, String math) {
		ScoreDTO sDTO = new ScoreDTO();
		sDTO.setId(Integer.parseInt(id));
		sDTO.setName(name);
		sDTO.setKor(Integer.parseInt(kor));
		sDTO.setEng(Integer.parseInt(eng));
		sDTO.setMath(Integer.parseInt(math));
		
		sDTO.setSumScore(sDTO.getKor()+sDTO.getEng()+sDTO.getMath());
		sDTO.setAvgScore(sDTO.getSumScore()/3);
		
		list.add(sDTO);
	}

	@Override
	public ArrayList<ScoreDTO> returnTolist() {
		return list;
	}

	@Override
	public ScoreDTO search(int id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId()==id)
			{
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean conditionID(int id) {
		
		boolean con = false;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id)
			{
				con = true;
			}
		}
		return con;
	}

	
}
