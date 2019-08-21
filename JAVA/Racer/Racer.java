package Racer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Racer extends Canvas implements Runnable{

	private int x = 0;
	static int rank = 1;
	String name = null;
	public Racer(String name) {
		x = (int)(Math.random()*10);
		this.name = name;
//		this.setBackground(new Color((int)(Math.random()*256),0,0));
	}
	
	public void paint(Graphics g) {

		Image img = Toolkit.getDefaultToolkit()
				.getImage("C:\\eclipse\\WorkSpace\\Day20190723\\src\\kr\\co\\bit\\horse.gif");
		g.drawImage(img, x, 0, 50,this.getSize().height,this);
	}

	@Override
	public void run() {
		for (int i = 0; i < 600; i+=(int)(Math.random()*10)) {
			x = i;
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println(rank +"µî : "+this.name);
		rank++;
	}
	
	
}
