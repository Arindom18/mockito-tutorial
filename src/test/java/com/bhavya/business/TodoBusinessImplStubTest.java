package com.bhavya.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bhavya.data.api.TodoService;
import com.bhavya.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Bhavya");
		assertEquals(2, todos.size());
	}
}
