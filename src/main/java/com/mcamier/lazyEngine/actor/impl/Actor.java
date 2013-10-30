package com.mcamier.lazyEngine.actor.impl;

import java.util.HashMap;
import java.util.Map;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.actor.IComponent;

public class Actor implements IActor {
	
	private Map<ComponentTypeEnum, IComponent> components = new HashMap<ComponentTypeEnum, IComponent>();

	public Actor() 
	{
		TransformComponent transform = new TransformComponent(this);
		this.putComponent(transform);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IComponent> T getComponent(ComponentTypeEnum type) {
		return (T)(this.components.get(type));
	}
	
	public void putComponent(IComponent component) {
		this.components.put(component.getType(), component);
	}

	public void update(long deltaTime) {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
}
