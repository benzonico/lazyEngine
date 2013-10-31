package com.mcamier.lazyEngine.interfaces;

public interface IGameObject {
	void initialize();
	void update(int deltaTime);
	void destroy();
}
