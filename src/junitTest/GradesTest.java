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
