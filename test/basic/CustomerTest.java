package basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerTest {

	@ParameterizedTest
	@ValueSource(ints = {15,40,50,0,1})
	void test_positiveAge(int age) {
		Customer c = new Customer();
		
		c.setAge(age);
		
		assertEquals(age, c.getAge());	
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {-1, -10})
	void test_ageNegative(int age) {
		Customer c = new Customer();
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> c.setAge(-1));
		assertEquals("No puede ser un número negativo", exception.getMessage());
	}
}







