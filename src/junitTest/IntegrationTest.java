package junitTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystems;
import gradeSystem.Main;

public class IntegrationTest {
	Main main;
	GradeSystems gradeSystems;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		main = new Main();
		gradeSystems = new GradeSystems();
		//System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
		main = null;
		gradeSystems = null;
		//System.setOut(null);
	}

	@Test
	public void integrationTest1() {		
		String input = "Q";
		//String output = ""
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
	    //System.setOut(new PrintStream(outContent));
		Main.main(null);
		
		
	}

}
