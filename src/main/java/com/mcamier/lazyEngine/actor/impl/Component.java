package com.mcamier.lazyEngine.actor.impl;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.actor.IComponent;

public abstract class Component implements IComponent {
	
	private IActor actor;
	
	
	public Component(IActor aActor) {
		this.actor = aActor;
	}
	
	public IActor getActor() {
		return this.actor;
	}
	
	public abstract ComponentTypeEnum getType();
	public abstract void update();
	public abstract void destroy();
}
