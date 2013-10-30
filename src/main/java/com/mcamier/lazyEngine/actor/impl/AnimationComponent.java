package com.mcamier.lazyEngine.actor.impl;

import com.mcamier.lazyEngine.actor.IActor;

public class AnimationComponent extends SpriteComponent {

	private long elapsedTime;
	private int currentFrame;
	private int frameHeight;
	private int frameWidth;
	private int frameCount;
	private float frameDuration;
	private boolean loop;
	private boolean active;
	
	public AnimationComponent(final IActor aActor) {
		super(aActor);
		elapsedTime = 0;
		currentFrame = 0;
		active = true;
	}

	public void update(long deltaTime) {
		if(active) {
			elapsedTime += deltaTime;
			if(elapsedTime >= frameDuration) {
				currentFrame++;
				
				if(currentFrame >= frameCount) {
					currentFrame = 0;
				}
				
				if(!loop) {
					active = false;
				}
			}
		}
	}
	
	public final int getFrameHeight() {
		return frameHeight;
	}

	public final void setFrameHeight(final int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public final int getFrameWidth() {
		return frameWidth;
	}

	public final void setFrameWidth(final int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public final int getFrameCount() {
		return frameCount;
	}

	public final void setFrameCount(final int frameCount) {
		this.frameCount = frameCount;
	}

	public final float getFrameDuration() {
		return frameDuration;
	}

	public final void setFrameDuration(final float frameDuration) {
		this.frameDuration = frameDuration;
	}

	public final boolean isLoop() {
		return loop;
	}

	public final void setLoop(final boolean loop) {
		this.loop = loop;
	}
}
