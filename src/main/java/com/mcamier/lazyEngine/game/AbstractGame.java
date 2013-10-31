package com.mcamier.lazyEngine.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.mcamier.lazyEngine.interfaces.*;

/**
 * Hello world!
 * 
 */
public abstract class AbstractGame implements IDrawable, IGameObject {
	
	private long lastFPS;
	private long lastFrame;
	private int fps;
	
	public AbstractGame() {
	}

	public final void run() {
		lastFPS = getTime(); // set lastFPS to current Time
		this.createDisplay();
		
		this.initialize();
		
		while (!Display.isCloseRequested()) {
			this.updateFPS();
			this.update(getDelta());
			this.draw(getDelta());
			Display.update();
			Display.sync(60);
		}

		Display.destroy();
		this.destroy();
	}

	private final void createDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setVSyncEnabled(false);
			Display.setFullscreen(false);
			Display.setResizable(false);
			
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0; // reset the FPS counter
			lastFPS += 1000; // add one second
		}
		fps++;
	}

	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	private int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}
}
