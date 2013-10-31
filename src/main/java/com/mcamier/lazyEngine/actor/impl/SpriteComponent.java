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

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int deltaTime) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		this.sprite = null;
	}
}
