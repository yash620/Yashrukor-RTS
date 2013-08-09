package buildings;
import main.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Quarry extends Building{
	private int stone=0;//amount of wood the quarry currently has.
	private int stic=0;
//	private Image image;
	private boolean makingresources=false;
	public Quarry(int race, int x, int y){
		super(3, 1500, 70, race, 50, 0, 20, 0, x, y);
		image=new ImageIcon("Images/Quarry.png").getImage();
	}
//	@Override
//	public void draw(Graphics2D g, int x, int y, int w, int h) {
//		g.drawImage(image, x, y, w, h, null);
//	}
//	@Override
//	public void miniDraw(Graphics2D g, int x, int y, int w, int h) {
//		g.setColor(Color.lightGray);
//		g.fillRect(x, y, w, h);
//	}
	public int collectResources(){
		int ret=stone;
		stone=0;
		return ret;
	}
	public void makeUnit() {
	}
	@Override
	public void tic() {
		if(constructed){
			stic++;
		}
		if(stic>10){
			stone+=5;
			stic=0;
		}
	}
	public void drawGUI(Graphics2D g, int x, int y, int w, int h) {
		super.drawGUI(g, x, y, w, h);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString("Quarry", x+40, y+50);
	}
	@Override
	public void setDifficulty(int diff) {
	}
}