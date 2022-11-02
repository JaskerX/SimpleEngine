package de.jaskerx.engine.simple.objects.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import de.jaskerx.engine.simple.objects.Entity;

public class Text extends Entity {

	String text;
	Color color;
	
	
	public Text(int width, int height, Color color) {
		super(width, height);
		this.color = color;
	}

	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.drawString(text, (getWidth() - g2d.getFontMetrics().stringWidth(text)) / 2, getPosY());
	}

	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
