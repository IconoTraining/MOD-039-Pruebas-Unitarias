package basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWordTest {

	@Test
	void test() {
		HelloWorld myClass = new HelloWorld();	
		int result = myClass.sum(4, 7);
		
		assertEquals(11, result);
	}

}
