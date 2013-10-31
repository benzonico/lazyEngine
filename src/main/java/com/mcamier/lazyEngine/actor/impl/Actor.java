package com.mcamier.lazyEngine.actor.impl;

import java.util.HashMap;
import java.util.Map;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.actor.IComponent;
import com.mcamier.lazyEngine.interfaces.IGameObject;
import com.mcamier.lazyEngine.interfaces.IUpdatable;

public class Actor implements IActor, IGameObject, IUpdatable {
	
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

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int deltaTime) {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
