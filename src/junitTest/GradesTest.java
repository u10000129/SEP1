package junitTest;
import gradeSystem.Grades;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesTest {	
	Grades grade;

	@Before
	public void setUp() throws Exception {
		grade = new Grades("sdd","123",40,52,60,80,93);
	}

	@After
	public void tearDown() throws Exception {
		grade = null;
	}
	/**
	 * Unit test
	 * test method calculateTotalGradeTest()
	 * 
	 * case 1: lab1 0.2  lab2 0.2  lab3 0.2  midTerm 0.2  finalExam 0.2
	 * case 2: lab1 0.1  lab2 0.1  lab3 0.1  midTerm 0.3  finalExam 0.4
	 */
	@Test
	public void calculateTotalGradeTest1() {
		float weights[] = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
		assertEquals(65, grade.calculateTotalGrade(weights));
	}
	
	@Test
	public void calculateTotalGradeTest2() {
		float weights[] = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
		assertEquals(76, grade.calculateTotalGrade(weights));
	}

}
