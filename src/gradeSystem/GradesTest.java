import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesTest {
	Grades grade;

	@Before
	public void setUp() throws Exception {
		grade = new Grades("sdd","123",1,1,1,1,1);
	}

	@After
	public void tearDown() throws Exception {
		grade = null;
	}

	@Test
	public void test() {
		assertEquals(5, grade.calculateTotalGrade());
	}

}
