package com.mcamier.lazyEngine.actor;


public interface IActor {
	
	<T extends IComponent> T getComponent(ComponentTypeEnum type);
	void putComponent(IComponent component);
	void update(long deltaTime);
	void destroy();
}
