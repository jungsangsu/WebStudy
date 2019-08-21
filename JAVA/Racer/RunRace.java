package Racer;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunRace extends Frame implements ActionListener{
	private int count;
	private String[] argArray;
	private Button btn;
	private Racer[] ra;

	public RunRace(String[] str) {
		this.count = Integer.parseInt(str[0]);
		this.argArray = str;

		ra = new Racer[count];
		for (int i = 0; i < count; i++) {
			ra[i] = new Racer(argArray[i+1]);
		}
		Panel panel1 = new Panel();
		panel1.setLayout(new GridLayout(count, 1, 1, 1));
		for (Racer racer : ra)
			panel1.add(racer);
		this.add(panel1);

		btn = new Button("출발");
		Panel panel2 = new Panel();
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(btn);
		this.add("South", panel2);

		this.setBounds(300, 300, 600, 600);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		
		btn.addActionListener(this);
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage : java RunRace count name " + args.length);
			System.exit(0);
		}

		if (Integer.parseInt(args[0]) != (args.length - 1)) {
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다");
			System.exit(0);
		}

		RunRace rr = new RunRace(args);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false);
		
		
		Thread[] t = new Thread[count];
		for (int i = 0; i < count; i++) {
			t[i] = new Thread(ra[i]);
			t[i].start();
		}
	}

}
