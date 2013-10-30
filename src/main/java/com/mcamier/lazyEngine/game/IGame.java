package com.mcamier.lazyEngine.game;

public interface IGame {

	public void run();
	
	public void initialization();
	public void update(int deltaTimeMillis);
	public void draw(int deltaTimeMillis);
	
}
