package com.example.utils;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.reflect.ClassPath;

/**
 * The Class ObjectUtilities.
 * 
 * @author Radu
 */
public class ObjectUtilities {

	/**
	 * Find all classes using google guice.
	 *
	 * @param packageName the package name
	 * @return the sets the
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Set<Class<?>> findAllClassesByPackage(String packageName) throws IOException {
		return ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
				.filter(clazz -> clazz.getPackageName().equalsIgnoreCase(packageName)).map(clazz -> clazz.load())
				.collect(Collectors.toSet());
	}
}
