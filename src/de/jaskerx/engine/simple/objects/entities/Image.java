package de.jaskerx.engine.simple.objects.entities;

import java.awt.Graphics2D;

import de.jaskerx.engine.simple.objects.Entity;

public class Image extends Entity {

	private java.awt.Image img;
	
	
	public Image(int width, int height) {
		super(width, height);
	}

	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(img, getPosX(), getPosY(), getWidth(), getHeight(), null);
	}

	
	public java.awt.Image getImage() {
		return img;
	}

	public void setImage(java.awt.Image img) {
		this.img = img;
	}

}
