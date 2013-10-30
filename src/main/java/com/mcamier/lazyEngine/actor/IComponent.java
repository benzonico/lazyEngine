package com.mcamier.lazyEngine.actor;


public interface IComponent {

	IActor getActor();
	ComponentTypeEnum getType();
	void update();
	void destroy();
	
}
