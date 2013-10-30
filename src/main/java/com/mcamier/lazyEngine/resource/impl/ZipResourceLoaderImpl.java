package com.mcamier.lazyEngine.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

import com.mcamier.lazyEngine.resource.IResourceLoader;

public final class ZipResourceLoaderImpl implements IResourceLoader {

	private String zipFilePath;
	
	private Set<String> resourcesAvailable = new HashSet<String>();

	
	public ZipResourceLoaderImpl(String aPathToZipFile) {
		this.zipFilePath = aPathToZipFile;
	}

	
	public void initialize() {
		ZipFile zipFile = tryToReturnZipFromPath(zipFilePath);
		Enumeration<? extends ZipEntry> zipFileContent = zipFile.entries();

		resetResourcesAvailable();

		while (zipFileContent.hasMoreElements()) {
			ZipEntry entry = zipFileContent.nextElement();
			resourcesAvailable.add(entry.getName());
		}
		try {
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getResource(String resourceName) {
		ZipFile zf = tryToReturnZipFromPath(zipFilePath);
		ZipEntry entry = zf.getEntry(resourceName);
		byte[] file = null;
		try {
			file = IOUtils.toByteArray(zf.getInputStream(entry));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return file;
	}
	
	private ZipFile tryToReturnZipFromPath(final String pathToZipFile) {
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(pathToZipFile);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return zipFile;
	}
	
	private void resetResourcesAvailable() {
		resourcesAvailable = new HashSet<String>();
	}
}
