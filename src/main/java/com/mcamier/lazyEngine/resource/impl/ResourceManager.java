package com.mcamier.lazyEngine.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

import org.apache.commons.io.IOUtils;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.mcamier.lazyEngine.resource.IResourceCache;
import com.mcamier.lazyEngine.resource.IResourceLoader;

public class ResourceManager {
	
	private static volatile ResourceManager instance = null;
	private static IResourceLoader resourceLoader = null;
	private static IResourceCache cache = null;
	
	private ResourceManager() {
		super();
		cache = new ResourceCacheImpl();
	}
	
	
	public final static ResourceManager getInstance() {
		if(resourceLoader == null) {
			Logger.getGlobal().log(Level.SEVERE, "ResourceManager must be initialized");
		} else {
			if( ResourceManager.instance == null ) {
				ResourceManager.instance = new ResourceManager();
			}
			return ResourceManager.instance;
		}
		return null;
	}
	
	
	public static void setResourceLoader(IResourceLoader aResourceLoader) {
		resourceLoader = aResourceLoader;
		resourceLoader.initialize();
	}
	
	public Texture getTexture(String resourceName) {
		Texture loadedTexture = null;
		try {
			loadedTexture = TextureLoader.getTexture("PNG", getResource(resourceName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return loadedTexture;
	}
	
	private InputStream getResource(String resourceName) {
		if(!cache.isCached(resourceName)) {
			System.out.println("Cache resource");
			cache.holdResource(resourceName, resourceLoader.getResource(resourceName));
		}

		System.out.println("Get cached resource");
		return cache.getResource(resourceName);
	}
}
