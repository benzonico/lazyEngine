package com.mcamier.lazyEngine.resource;

import java.io.InputStream;

public interface IResourceCache {
	boolean isCached(String resourceName);
	InputStream getResource(String resourceName);
	void releaseResource(String resourceName);
	void holdResource(String resourceName, byte[] resource);
}