package com.mcamier.lazyEngine.actor.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;
import com.mcamier.lazyEngine.interfaces.IGameObject;

public class Actor implements IActor, IGameObject {
	
	private Map<ComponentTypeEnum, Component> components = new HashMap<ComponentTypeEnum, Component>();

	public Actor() 
	{
		TransformComponent transform = new TransformComponent(this);
		this.putComponent(transform);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(ComponentTypeEnum type) {
		return (T)(this.components.get(type));
	}
	
	public void putComponent(Component component) {
		this.components.put(component.getType(), component);
	}

	@Override
	public void initialize() {}

	@Override
	public void update(int deltaTime) {
		Iterator<Entry<ComponentTypeEnum, Component>> componentsIterator = this.components.entrySet().iterator();
		while(componentsIterator.hasNext()) {
			Entry<ComponentTypeEnum, Component> entry = componentsIterator.next();
			entry.getValue().update(deltaTime);
		}
	}

	public void destroy() {
		this.components.clear();
		this.components = null;
	}
}
