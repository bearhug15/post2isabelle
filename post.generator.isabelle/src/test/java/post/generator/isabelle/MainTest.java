package post.generator.isabelle;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	
	@Test
	public void ModelCoppingTest() {
		String[] args = {"-s","D:\\eclipse\\eclipse-workspace\\HandDryer.post","-o","D:\\eclipse\\eclipse-workspace"};
		Main.main(args);
		
		assertTrue(true);
	}
	
}
