package com.mcamier.lazyEngine.actor.impl;

import org.newdawn.slick.opengl.Texture;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.interfaces.IDrawable;

public class SpriteComponent extends Component implements IDrawable {

	private Texture sprite;
	
	public SpriteComponent(IActor aActor) {
		super(aActor);
	}

	@Override
	public ComponentTypeEnum getType() {
		return ComponentTypeEnum.RENDER;
	}

	public void draw(int deltaTime) {}

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
