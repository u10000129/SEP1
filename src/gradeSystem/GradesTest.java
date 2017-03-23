package gradeSystem;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesTest {
	Grades grade;

	@Before
	public void setUp() throws Exception {
		grade = new Grades("sdd","123",80,80,80,80,80);
	}

	@After
	public void tearDown() throws Exception {
		grade = null;
	}

	@Test
	public void calculateTotalGradeTest() {
		float weights[] = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
		assertEquals(80, grade.calculateTotalGrade(weights));
	}

}
