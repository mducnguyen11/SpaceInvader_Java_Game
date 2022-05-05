package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Rocket {
	  public int x,y,width,height;
	  private Image image;

		public int getX() {
			return x;
		}
	    
		public boolean checkRt() {
			return y >= 500;
		}
		public void move() {
			 y+= 3;
		}
		public Rocket() {
			super();
			this.width = 10;
			this.height = 50;
			this.x = (int)Math.floor(Math.random()*470);
			this.y = 20;
			try {
				this.image = ImageIO.read(new File("./src/img/rocket.png"));
				
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

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
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
