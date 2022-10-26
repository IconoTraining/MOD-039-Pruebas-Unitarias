package tdd;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import advanced.BackyardSwitcher;
import advanced.MotionDetector;

class BombillaTDD {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	

	@Test
	void EntreLas18ylas6_conDeteccionDeMovimieno_seDeberiaEncencder() {
		
		// Input directo
		int hour = 21;
		
		// Input indirecto
		Boolean motionDetected = true;
		
		MotionDetector detectorMock = mock(MotionDetector.class);
		when(detectorMock.detect()).thenReturn(motionDetected);
			
		
		LocalDateTime time = LocalDateTime.now().withHour(hour);
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		
		// Act
		SmartHomeService s = new SmartHomeService(detectorMock, switcherMock);
		s.actuateLights(time);
		
		// Assert (si fuera output directo: una query, tendría un return, lo cojo y assert)
		// Assert (dar la orden de encender la bombilla)
		Mockito.verify(switcherMock).turnOn();	
		
	}

}
