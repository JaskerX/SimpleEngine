package de.jaskerx.engine.simple.objects;


import java.awt.Graphics2D;



public abstract class Entity {
	
	private int width;
	private int height;
	private int posX;
	private int posY;
	private int[] numAttributes;
	private String[] textAttributes;
	
	
	public Entity(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}
	
	
	public abstract void draw(Graphics2D g2d);
	

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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int[] getNumAttributes() {
		return numAttributes;
	}

	public void setNumAttributes(int... numAttributes) {
		this.numAttributes = numAttributes;
	}

	public String[] getTextAttributes() {
		return textAttributes;
	}

	public void setTextAttributes(String[] textAttributes) {
		this.textAttributes = textAttributes;
	}

}
