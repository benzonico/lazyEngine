package com.mcamier.lazyEngine.actor.impl;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.actor.IComponent;
import com.mcamier.lazyEngine.interfaces.IGameObject;

public abstract class Component implements IComponent, IGameObject {
	
	private IActor actor;
	
	
	public Component(IActor aActor) {
		this.actor = aActor;
	}
	
	public IActor getActor() {
		return this.actor;
	} 
	
	public abstract ComponentTypeEnum getType();

	@Override
	public void destroy() {
		this.actor = null;
	}
}
