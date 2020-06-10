import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class DivisionTest {
	Division division = new Division();
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void divid() throws Exception {
		
		assertThat(division.divid(10,5),equalTo(2));
		assertThat(division.divid(1,2),equalTo(0));
		assertThat(division.divid(1,0),equalTo(null));
	}
	
}