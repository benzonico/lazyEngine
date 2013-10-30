package com.mcamier.lazyEngine.actor.impl;

import org.newdawn.slick.opengl.Texture;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.Drawable;
import com.mcamier.lazyEngine.actor.IActor;

public class SpriteComponent extends Component implements Drawable{

	private Texture sprite;
	
	public SpriteComponent(IActor aActor) {
		super(aActor);
	}

	@Override
	public ComponentTypeEnum getType() {
		return ComponentTypeEnum.RENDER;
	}

	public void draw(long deltaTime) {}

	public final Texture getSprite() {
		return sprite;
	}

	public final void setSprite(final Texture sprite) {
		this.sprite = sprite;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
