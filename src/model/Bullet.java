package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Bullet {
    private int x,y,width,height;
    private Image image;

	public int getX() {
		return x;
	}
    
	public boolean checkBullet() {
		return y <= 5;
	}
	public void move() {
		 y-= 5;
	}
	public Bullet(int x) {
		super();
		this.width = 20;
		this.height = 35;
		this.y = 465;
		this.x = x;
		try {
			this.image = ImageIO.read(new File("./src/img/bullet.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
