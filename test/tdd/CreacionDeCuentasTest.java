package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CreacionDeCuentasTest {
	
	private Cuenta c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c = new Cuenta(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void alCrearUnaCuenta_ElSaldoDeberiaSer0() {
		assertEquals(0, c.getSaldo());
	}
	
	//Al ingresar 100 en cuenta vacía, el saldo es 100
	@ParameterizedTest
	@ValueSource(doubles = {100, 3000, 100.45, 6000})
	void unIngresoSumaLaCantidadIngrasadaAlSaldo(double cantidad) {
		c.ingresar(cantidad);
		assertEquals(cantidad, c.getSaldo());
	}
	
	//Al ingresar 3000 en cuenta con 100 el saldo es 3100
	@Test
	void unIngresoConSaldoPrevio_SumaLaCantidadIngrasadaAlSaldo() {
		// Setup (Arrange)
		c.ingresar(100);
		
		// Act
		c.ingresar(3000);
		
		// Assert
		assertEquals(3100, c.getSaldo());
	}
	
	// Al ingresar -100 en cuenta vacía, el saldo sigue siendo 0
	@Test
	void ingresoNegativo_deberíaCancelarElIngreso() {
		// Setup (Arrange)
		
		// Act
		c.ingresar(-100);
		
		// Assert
		assertEquals(3100, c.getSaldo());
	}
	
	
	//Si ingreso 100.457 en una cuenta vacía, el saldo es de 0
	@Test
	void ingresoMasDe3decimales_deberíaCancelarElIngreso() {
		// Setup (Arrange)
		
		// Act
		c.ingresar(100.457);
		
		// Assert
		assertEquals(0, c.getSaldo());
	}
	
	@Test
	void ingresoMasDe6000_deberíaCancelarElIngreso() {
		// Setup (Arrange)
		
		// Act
		c.ingresar(6000.01);
		
		// Assert
		assertEquals(0, c.getSaldo());
	}
	
	//Al ingresar 7000 en una cuenta con 2350€, debería tener 2350
	@Test
	void bug157() {
		// Setup (Arrange)
		c.ingresar(2350);
		
		// Act
		c.ingresar(7000);
		
		// Assert
		assertEquals(2350, c.getSaldo());
	}
	
}
