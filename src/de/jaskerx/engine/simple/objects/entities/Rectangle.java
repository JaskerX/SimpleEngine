package de.jaskerx.engine.simple.objects.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import de.jaskerx.engine.simple.objects.Entity;

public class Rectangle extends Entity {

	private Color color;
	
	
	public Rectangle(int width, int height) {
		super(width, height);
	}

	
	@Override
	public void draw(Graphics2D g2d) {
		if(color != null) g2d.setColor(color);
		g2d.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
	}


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
