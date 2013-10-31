package com.mcamier.lazyEngine.resource.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.mcamier.lazyEngine.resource.IResourceCache;

public class ResourceCacheImpl implements IResourceCache {

	private static Map<String, byte[]> cache = new HashMap<String, byte[]>();
	
	public boolean isCached(String resourceName) {
		return (cache.containsKey(resourceName));
	}

	public void releaseResource(String resourceName) {
		cache.remove(resourceName);
	}

	public void holdResource(String resourceName, byte[] resource) {
		cache.put(resourceName, resource);
	}

	public InputStream getResource(String resourceName) {
		return new ByteArrayInputStream(cache.get(resourceName));
	}
}