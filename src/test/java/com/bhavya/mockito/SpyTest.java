package com.bhavya.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Yanamala");
		listSpy.add("Bhavya");

		verify(listSpy).add("Yanamala");
		verify(listSpy).add("Bhavya");

		assertEquals(2, listSpy.size());
		assertEquals("Yanamala", listSpy.get(0));
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Yanamala");
		listSpy.add("Bhavya");

		stub(listSpy.size()).toReturn(-1);

		assertEquals(-1, listSpy.size());
		assertEquals("Yanamala", listSpy.get(0));

		// @Spy Annotation
	}

}