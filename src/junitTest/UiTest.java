package junitTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.UI;

public class UiTest {
	
	protected UI ui;
	
	/**
	 * test method checkCommand()
	 */
	@Before
	public void setUp() throws Exception {
		ui = new UI();
	}
	
	@Test
	public void test1() {
		assertEquals(false, ui.checkCommand("E"));
	}
	
	@Test
	public void test2() {
		assertEquals(true, ui.checkCommand("G"));
	}
	
	@Test
	public void test3() {
		assertEquals(true, ui.checkCommand("R"));
	}
	
	@Test
	public void test4() {
		assertEquals(true, ui.checkCommand("A"));
	}
	
	@Test
	public void test5() {
		assertEquals(true, ui.checkCommand("W"));
	}
	
	/** 
	 * test method checkID()
	 */
	
	@Test
	public void test6() {
		assertEquals(true, ui.checkID("955002056"));
	}
	
	@Test
	public void test7() {
		assertEquals(false, ui.checkID("5820323144"));
	}
}
