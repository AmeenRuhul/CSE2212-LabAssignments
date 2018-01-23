
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharactersInPlayTest {
	private CharactersInPlay cn;

	@Before
	public void setUp() throws Exception {
		this.cn = new CharactersInPlay();
	}

	@After
	public void tearDown() throws Exception {
		this.cn = null;
	}

	@Test
	public void test() {
		cn.tester();
	}

}
