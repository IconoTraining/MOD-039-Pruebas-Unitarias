package basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DNITest {
	
//	@Test
//	void test() {
//		DNI myClass = new DNI();
//		char result1 = myClass.calcularLetra(12345678);
//		char result2 = myClass.calcularLetra(11111121);
//		
//		assertEquals('Z',result1);
//		assertEquals('M',result2);
//	}

	@ParameterizedTest
	@CsvSource({
        "15454423, X",
        "15454424, B",
        "24391541, H",
        "43253425, Q",
        "24391544, K",
        "70878790, N",
        "39696838, B",
        "23,       T",
        "10101010, P",
        "10101020, H",
        "12345678, Z",
        "11111116, T",
        "11111117, R",
        "11111118, W",
        "11111119, A",
        "11111120, G",
        "11111121, M",
        "11111122, Y",
        "11111123, F",
        "11111124, P",
        "11111125, D",
        "11111126, X",
        "11111127, B",
        "11111128, N",
        "11111129, J",
        "11111130, Z",
        "11111131, S",
        "11111132, Q",
        "11111133, V",
        "11111134, H",
        "11111135, L",
        "11111136, C",
        "11111137, K",
        "11111138, E"
	})
	void test_letra(int dni, char expectedChar) {
		DNI myClass = new DNI();
		
		char result = myClass.calcularLetra(dni);
		
		assertEquals(expectedChar, result);
	}

}
