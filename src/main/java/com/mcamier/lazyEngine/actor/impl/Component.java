package com.mcamier.lazyEngine.actor.impl;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.actor.IComponent;
import com.mcamier.lazyEngine.interfaces.IGameObject;
import com.mcamier.lazyEngine.interfaces.IUpdatable;

public abstract class Component implements IComponent, IGameObject, IUpdatable {
	
	private IActor actor;
	
	
	public Component(IActor aActor) {
		this.actor = aActor;
	}
	
	public IActor getActor() {
		return this.actor;
	}
	
	public abstract ComponentTypeEnum getType();
}
