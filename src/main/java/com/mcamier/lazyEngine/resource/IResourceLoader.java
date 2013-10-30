package com.mcamier.lazyEngine.resource;


public interface IResourceLoader {
	void initialize();
	byte[] getResource(String resourceName);
}
