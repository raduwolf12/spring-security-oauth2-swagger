package com.example;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.example.utils.GetterSetterVerifier;
import com.example.utils.ObjectUtilities;

/**
 * The Class EntityTest.
 */
public class EntityTest {

	/**
	 * Test entity.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testEntity() throws ClassNotFoundException, IOException {
		Set<Class<?>> o = ObjectUtilities.findAllClassesByPackage("com.example.model.entity");

		for (Class<?> class1 : o) {
			GetterSetterVerifier.forClass(class1).verify();
		}
	}

}
