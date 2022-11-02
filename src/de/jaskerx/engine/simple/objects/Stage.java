package de.jaskerx.engine.simple.objects;

import java.awt.Color;

public class Stage {

	private int width;
	private int height;
	private String title;
	private Entity[][] entities;
	private Color color;
	private CustomCode code;
	boolean wait = false;
	
	
	public Stage(int width, int height, String title, CustomCode code, Entity[]... entities) {
		setWidth(width);
		setHeight(height);
		setTitle(title);
		setCode(code);
		setEntities(entities);
	}
	

	public void setEntities(int index, Entity[] entity) {
		entities[index] = entity;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Entity[][] getEntities() {
		return entities;
	}

	public void setEntities(Entity[]... entities) {
		this.entities = entities;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public CustomCode getCode() {
		return code;
	}

	public void setCode(CustomCode code) {
		this.code = code;
	}
	
	public boolean doWait() {
		return wait;
	}
	
	public void setWait(boolean wait) {
		this.wait = wait;
	}
	
}
