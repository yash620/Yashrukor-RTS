package units;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import main.Thing;

import buildings.Building;

public class Archer extends Unit {
//	private Image image;
//	static ImageIcon icon=new ImageIcon("resources//images//Archer.gif");
	public static int WIDTH=42;
	public static int HEIGHT=37;
	public Archer(int race, int direction, int x, int y) {
		super(race, ARCHER, direction, x, y);
		Image i = Toolkit.getDefaultToolkit().createImage("resources//images//Archer.gif");
		this.setImage(i);
		VISIONDISTANCE = 900;
		setSize(WIDTH,HEIGHT);
		type = ARCHER;
		setHealth(250);
		movespeed = 3;
		damage = 4;
		range = 400;
		attackspeed = 1;
		setGoldcost(5);
		setWoodcost(15);
		setFoodcost(10);
	}
	@Override
	public void draw(Graphics2D g, int x, int y, int w, int h) {
		super.draw(g, x, y, w, h);
		g.drawImage(image, x, y, w, h, null);
	}
	public void drawGUI(Graphics2D g, int x, int y, int w, int h) {
		super.drawGUI(g, x, y, w, h);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString("Archer", x+40, y+50);
	}
//	@Override
//	public void miniDraw(Graphics2D g, int x, int y, int w, int h) {
//		g.setColor(Color.red);
//		g.fillRect(x,y,w,h);
//	}
	@Override
	public int getDamage() {
		return damage;
	}
	
	

}
