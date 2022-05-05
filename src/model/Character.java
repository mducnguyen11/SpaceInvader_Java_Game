package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Character {
        private int x,y,width,height;
        private Image image;
        
    	public Character() {
			super();
			this.x = 220;
			this.y = 450;
			this.height = 50;
			this.width=50;		
			try {
				this.image = ImageIO.read(new File("./src/img/xx.jpg"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			this.image = new ImageIcon("D:\\\\JavaWorkSpace\\\\SpaceInvaderGame\\\\src\\\\img\\\\xx.jpg").getImage();
//			
		}
		public int getX() {
			return x;
		}
        public Image getImage() {
        	return this.image;
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
        public void moveLeft() {
      	  if(this.getX() >= 15 ) {
    		 this.setX(this.getX() - 15);
    	  }

        }
        public void moveRight() {
        	if(this.getX() <= 455) {
      		  this.setX(this.getX() + 15);
      	}
        }
		public void setY(int y) {
			this.y = y;
		}

	
        
}
