package hacksa;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ScoreForm extends JFrame implements ActionListener {
	public static ScoreImpl database = new ScoreImpl();
	public File file = null;

	public static final String[] labelName = { "학번", "이름", "국어", "영어", "수학" };
	public static final String[] buttonName = { "입력", "출력", "학번검색", "총점수", "파일저장", "파일열기" };

	private JLabel[] label; // hakL,nameL,KorL,engL,mathL;
	private JTextField[] text;// hakT, nameT,korT,engT,mathT;
	private JTextArea output;
	private JButton button[]; // addB, dispB, searchB, tot_descB, saveB, loadB;

	public ScoreForm() {

		label = new JLabel[5];
		text = new JTextField[5];

		JPanel letfPanel_layer[] = new JPanel[5];
		for (int i = 0; i < labelName.length; i++) {
			letfPanel_layer[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			label[i] = new JLabel(labelName[i]);
			text[i] = new JTextField(30);
			letfPanel_layer[i].add(label[i]);
			letfPanel_layer[i].add(text[i]);
		}

		JPanel leftPanel = new JPanel(new GridLayout(5, 1, 1, 1));
		for (int i = 0; i < letfPanel_layer.length; i++) {
			leftPanel.add(letfPanel_layer[i]);
		}

		JPanel rightPanel = new JPanel(new GridLayout(1, 1));
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		rightPanel.add(scroll);

		JPanel mainPanel = new JPanel(new GridLayout(1, 2, 1, 1));
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);

		JPanel bottonPanel = new JPanel(new GridLayout(1, 6, 3, 3));
		button = new JButton[6];
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(buttonName[i]);
			button[i].setBackground(Color.LIGHT_GRAY);
			bottonPanel.add(button[i]);
		}

		this.setTitle("성적관리");
		getContentPane().add("Center", mainPanel);
		getContentPane().add("South", bottonPanel);

		setBounds(100, 100, 700, 200);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		for (int i = 0; i < button.length; i++) { // 버튼별 액션 등록
			button[i].addActionListener(this);
		}

		this.addWindowListener(new WindowAdapter() { // window 리스너
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0]) // 등록
		{
			if (database.conditionID(Integer.parseInt(text[0].getText()))) // 학번중복검사
			{
				JOptionPane.showMessageDialog(this, "학번중복 등록실패");
			} else {
				database.input(text[0].getText(), text[1].getText(), text[2].getText(), text[3].getText(),
						text[4].getText());
				JOptionPane.showMessageDialog(this, "등록완료");
			}

		} else if (e.getSource() == button[1])// 출력
		{
			output.setText(
					String.format("%5s %5s %4s %4s %4s %4s %5s", "Id", "Name", "Kor", "Eng", "Math", "Sum", "Avg"));
			ArrayList<ScoreDTO> list = database.returnTolist();
			for (int i = 0; i < list.size(); i++) {
				output.append("\n" + list.get(i).toString());
			}
		} else if (e.getSource() == button[2])// 검색
		{
			String inputID = JOptionPane.showInputDialog("검색할 학번을 입력하세요");
			if (inputID != null) {
				if (!database.conditionID(Integer.parseInt(inputID))) // 학번검사
				{
					JOptionPane.showMessageDialog(this, "검색결과 없음");
				} else {
					output.setText(String.format("%5s %5s %4s %4s %4s %4s %5s", "Id", "Name", "Kor", "Eng", "Math",
							"Sum", "Avg"));
					output.append("\n" + database.search(Integer.parseInt(inputID)).toString());
				}
			}

		} else if (e.getSource() == button[3]) // 총점수
		{
			ArrayList<ScoreDTO> list = database.returnTolist();
			Collections.sort(list);
			output.setText(
					String.format("%5s %5s %4s %4s %4s %4s %5s", "Id", "Name", "Kor", "Eng", "Math", "Sum", "Avg"));
			for (int i = 0; i < list.size(); i++) {
				output.append("\n" + list.get(i).toString());
			}
			
		} else if (e.getSource() == button[4]) // 파일저장
		{
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
			}
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				ArrayList<ScoreDTO> list = database.returnTolist();
				for (ScoreDTO scoreDTO : list) {
					oos.writeObject(scoreDTO);
				}
				oos.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == button[5]) // 파일열기
		{
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
			}
			try {
				output.setText("");
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				ScoreDTO temp;
				while ((temp = (ScoreDTO) ois.readObject()) != null) {
					if (!database.conditionID(temp.getId())) // 학번검사
					{
						database.input(String.valueOf(temp.getId()), temp.getName(), String.valueOf(temp.getKor()),
								String.valueOf(temp.getEng()), String.valueOf(temp.getMath()));
					}
					output.append(temp.toString() + "\n");
				}
				ois.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (EOFException e1) {
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ScoreForm();
	}

}
