package units;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import main.Thing;

import buildings.Building;

public class Knight extends Unit {
	private Image image;
	static ImageIcon icon=new ImageIcon("resources//images//Knight.gif");
	public static int WIDTH=60;
	public static int HEIGHT=60;
	public Knight(int race, int direction, int x, int y) {
		super(race, KNIGHT, direction, x, y);
		Image i = Toolkit.getDefaultToolkit().createImage("resources//images//Knight.gif");
		this.setImage(i);
		setSize(WIDTH,HEIGHT);
		type = KNIGHT;
		setHealth(500);
		movespeed = 7;
		damage = 7;
		range = 50;
		attackspeed = 1;
		setGoldcost(20);
		setWoodcost(20);
		setFoodcost(20);
//		image=icon.getImage();
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
		g.drawString("Knight", x+40, y+50);
	}
	@Override
	public int getDamage() {
		return damage;
	}

}
