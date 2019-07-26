package NotePad;

import java.awt.event.InputEvent;

import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class MenuPane extends JMenuBar {
	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;

	public MenuPane(){
		fileM = new JMenu("파일");
		editM = new JMenu("편집");
		viewM = new JMenu("보기");

		newM = new JMenuItem("새로만들기");
		openM = new JMenuItem("열기"); 
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("종료"); 
		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");

		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);

		editM.add(cutM);
		editM.add(copyM);
		editM.add(pasteM);

		add(fileM);
		add(editM);
		add(viewM);

		//단축키
		cutM.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.ALT_MASK));
		copyM.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.ALT_MASK));
		pasteM.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.ALT_MASK));
	}
	
	public JMenuItem getNewM(){
		return newM;
	}
	public JMenuItem getOpenM(){
		return openM;
	}
	public JMenuItem getSaveM(){
		return saveM;
	}
	public JMenuItem getExitM(){
		return exitM;
	}
	public JMenuItem getCutM(){
		return cutM;
	}
	public JMenuItem getCopyM(){
		return copyM;
	}
	public JMenuItem getPasteM(){
		return pasteM;
	}
}
