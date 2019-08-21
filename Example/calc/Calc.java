package calc;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class Calc extends Frame implements WindowListener, ActionListener {

	static final String[] stringArray = { "BackSpace", "C", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-",
			".", "0", "=", "+" };

	private Button[] buttonArray;
	private Panel[] panelArray;
	private Label[] textF;

	private StringBuffer stb;
	private String resultString;

	private boolean pointCon;

	public Calc() {
		pointCon = false;

		/*
		 * index 변수
		 */
		int index_botton = 0;
		int index_text = 0;

		/*
		 * 결과 변수
		 */
		stb = new StringBuffer("");
		resultString = "0";

		/*
		 * layout 선언
		 */
		textF = new Label[2];

		buttonArray = new Button[18];
		for (int i = 0; i < buttonArray.length; i++) {
			buttonArray[i] = new Button(stringArray[i]);
		}
		panelArray = new Panel[7];
		Panel mainPanel = new Panel();
		mainPanel.setLayout(new GridLayout(7, 1, 10, 10));

		/*
		 * layout 구현
		 */
		for (int i = 0; i < panelArray.length; i++) {
			if (i < 2) {
				panelArray[i] = new Panel();
				panelArray[i].setLayout(new GridLayout(1, 1, 10, 10));
				textF[index_text] = new Label();
				textF[index_text].setAlignment(Label.RIGHT);
				textF[index_text].setFont(new Font("Serif", Font.BOLD, 25));
				textF[index_text].setBackground(new Color(173, 240, 252));
				panelArray[i].add(textF[i]);
				mainPanel.add(panelArray[i]);
				index_text++;
			} else if (i == 2) {
				panelArray[i] = new Panel();
				for (int j = 0; j < 2; j++) {
					panelArray[i].setLayout(new GridLayout(1, 2, 10, 10));
					panelArray[i].add(buttonArray[index_botton]);
					index_botton++;
				}
				mainPanel.add(panelArray[i]);
			} else {
				panelArray[i] = new Panel();
				for (int j = 0; j < 4; j++) {
					panelArray[i].setLayout(new GridLayout(1, 4, 10, 10));
					panelArray[i].add(buttonArray[index_botton]);
					index_botton++;
				}
				mainPanel.add(panelArray[i]);
			}
		}

		this.add("North", new Panel());
		this.add("South", new Panel());
		this.add("East", new Panel());
		this.add("West", new Panel());
		this.add("Center", mainPanel);

		this.setBounds(100, 200, 500, 500);
		this.setBackground(Color.lightGray);
		this.setVisible(true);

		/*
		 * 핸들러 선언
		 */
		for (Button button : buttonArray)
			button.addActionListener(this);
		this.addWindowListener(this);

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void paint(Graphics g) {
		textF[0].setText(stb.toString());
		textF[1].setText(resultString);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonArray[0]) {
			if (stb.length() > 0) {
				stb.deleteCharAt(stb.length() - 1);
				repaint();
			}
		} else if (e.getSource() == buttonArray[1]) {
			stb = new StringBuffer("");
			resultString = "0";
			repaint();
		} else if (e.getSource() == buttonArray[2]) {
			stb.append("7");
			repaint();
		} else if (e.getSource() == buttonArray[3]) {
			stb.append("8");
			repaint();
		} else if (e.getSource() == buttonArray[4]) {
			stb.append("9");
			repaint();
		} else if (e.getSource() == buttonArray[5]) {
			stb.append("/");
			repaint();
		} else if (e.getSource() == buttonArray[6]) {
			stb.append("4");
			repaint();
		} else if (e.getSource() == buttonArray[7]) {
			stb.append("5");
			repaint();
		} else if (e.getSource() == buttonArray[8]) {
			stb.append("6");
			repaint();
		} else if (e.getSource() == buttonArray[9]) {
			stb.append("*");
			repaint();
		} else if (e.getSource() == buttonArray[10]) {
			stb.append("1");
			repaint();
		} else if (e.getSource() == buttonArray[11]) {
			stb.append("2");
			repaint();
		} else if (e.getSource() == buttonArray[12]) {
			stb.append("3");
			repaint();
		} else if (e.getSource() == buttonArray[13]) {
			stb.append("-");
			repaint();
		} else if (e.getSource() == buttonArray[14]) {

			if (stb.length() != 0) // 맨앞에 .을 못넣음
			{
				stb.append(".");
			}

			repaint();
		} else if (e.getSource() == buttonArray[15]) {

			if (stb.length() == 0) // 시작
			{
				stb.append("0");
			} else {
				stb.append("0");
			}
			repaint();
		} else if (e.getSource() == buttonArray[16]) {
			stb.append("=");
			resultString = String.valueOf(new DecimalFormat("#.###").format(calculator(stb.toString())));
			stb.delete(0, stb.length());
			repaint();
		} else if (e.getSource() == buttonArray[17]) {
			stb.append("+");
			repaint();
		}
	}

	public double calculator(String str) {

		double num1 = 0.0;
		int startIndex = 0;
		boolean con = true;

		List<Double> num = new LinkedList<Double>();
		List<Character> oper = new LinkedList<Character>();

		List<Double> afterNum = new LinkedList<Double>();
		List<Character> afterOper = new LinkedList<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '-' || str.charAt(i) == '+'
					|| str.charAt(i) == '=') {
				num.add(Double.parseDouble(str.substring(startIndex, i)));
				oper.add(str.charAt(i));
				startIndex = i + 1;
			}
		}

		for (int i = 0; i < oper.size(); i++) {
			if (oper.get(i) == '*' || oper.get(i) == '/') {
				if (con) {
					afterNum.add(num.get(i));
					afterNum.add(num.get(i + 1));
					con = false;
				} else {
					afterNum.add(num.get(i));
				}
				afterOper.add(oper.get(i));
			}
		}

		for (int i = 0; i < oper.size(); i++) {
			if (oper.get(i) == '+' || oper.get(i) == '-') {
				if (con) {
					afterNum.add(num.get(i));
					afterNum.add(num.get(i + 1));
					con = false;
				} else {
					afterNum.add(num.get(i));
				}
				afterOper.add(oper.get(i));
			}
		}

		num1 = afterNum.get(0);

		for (int i = 0; i < afterOper.size(); i++) {
			if (afterOper.get(i) == '+') {
				num1 += afterNum.get(i + 1);
			} else if (afterOper.get(i) == '-') {
				num1 -= afterNum.get(i + 1);
			} else if (afterOper.get(i) == '*') {
				num1 *= afterNum.get(i + 1);
			} else if (afterOper.get(i) == '/') {
				num1 /= afterNum.get(i + 1);
			}
		}

		return num1;
	}

	public static void main(String[] args) {

		Calc c = new Calc();

	}

}
