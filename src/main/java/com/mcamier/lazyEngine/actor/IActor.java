package com.mcamier.lazyEngine.actor;

import com.mcamier.lazyEngine.actor.impl.Component;


public interface IActor {
	
	<T extends Component> T getComponent(ComponentTypeEnum type);
	void putComponent(Component component);
}
