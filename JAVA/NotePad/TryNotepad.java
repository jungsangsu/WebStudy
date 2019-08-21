package NotePad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

class TryNotepad extends JFrame implements ActionListener {
	private JTextArea area;
	private MenuPane menu;
	private File file;

	public TryNotepad(){
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		menu = new MenuPane();
		this.setJMenuBar(menu);

		getContentPane().add("Center", scroll);

		setBounds(300,100,700,500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int result = JOptionPane.showConfirmDialog(TryNotepad.this,
										"저장하시겠습니까?",
										"메모장",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION){
					saveDialog();
					fileWrite();
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION)
					System.exit(0);
			}
		});
	}//생성자

	public void event(){
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.getNewM()){
			area.setText("");
		}else if(e.getSource()==menu.getOpenM()){
			openDialog();
			fileRead();//호출

		}if(e.getSource()==menu.getSaveM()){
			saveDialog();
			fileWrite();

		}else if(e.getSource()==menu.getExitM()){
			int result = JOptionPane.showConfirmDialog(this,
										"저장하시겠습니까?",
										"메모장",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION){
					saveDialog();
					fileWrite();
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION)
					System.exit(0);

		}else if(e.getSource()==menu.getCutM()){
			area.cut();

		}else if(e.getSource()==menu.getCopyM()){
			area.copy();

		}else if(e.getSource()==menu.getPasteM()){
			area.paste();
		}
	}

	public void openDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);
	}
	public void fileRead() {//구현
		if(file==null) return;

		area.setText("");

		String line=null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));

			while( (line=br.readLine()) != null){
				area.append(line+"\n"); 
			}
			br.close();

		}catch(IOException io){ io.printStackTrace(); }
	}

	public void saveDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);
	}
	public void fileWrite(){
		if(file==null) return;

		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String data = area.getText();
			bw.write(data);
			bw.close();
		}catch(IOException io){ io.printStackTrace(); }
	}

	public static void main(String[] args) {
		new TryNotepad().event();
	}
}
