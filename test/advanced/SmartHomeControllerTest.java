package advanced;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class SmartHomeControllerTest {

//	// Mock de tipo espía
//	class BackyardSwitcherMock extends BackyardSwitcher {
//		public boolean turnOnHasBeenCalled = false;
//		public boolean turnOffHasBeenCalled = false;
//		
//		@Override()
//		public void turnOn() {
//			turnOnHasBeenCalled = true;
//		}
//		
//		@Override()
//		public void turnOff() {
//			turnOffHasBeenCalled = true;
//		}
//	}
//	
//	
//	
//	@Test
//	void SiDetectaMovimiento_Y_EsEvening_Entonces_SeDeberíaEncenderLaBombilla() {
//		// Setup
//		boolean motionDetected = true;
//		LocalDateTime time = LocalDateTime.now().withHour(19);
//		
//		BackyardSwitcherMock switcherMock = new BackyardSwitcherMock();
//		
//		// Act
//		SmartHomeController controller = new SmartHomeController(switcherMock);
//		controller.actuateLights(motionDetected, time);
//		
//		// Assert
//		assertTrue(switcherMock.turnOnHasBeenCalled);	
//	}
	
//	@Test
//	void SiDeteagctaMovimiento_Y_EsMorning_Entonces_SeDeberíaAparLaBombilla() {
//		// Setup
//		boolean motionDetected = true;
//		LocalDateTime time = LocalDateTime.now().withHour(10);
//		
//		BackyardSwitcherMock switcherMock = new BackyardSwitcherMock();
//		
//		// Act
//		SmartHomeController controller = new SmartHomeController(switcherMock);
//		controller.actuateLights(motionDetected, time);
//		
//		// Assert
//		assertTrue(switcherMock.turnOffHasBeenCalled);	
//	}
	
//	@Test
//	void SiDetectaMovimiento_Y_EsMorning_Entonces_SeDeberíaApagarLaBombilla() {
//		// Setup
//		boolean motionDetected = false;
//		LocalDateTime time = LocalDateTime.now().withHour(2);
//		
//		BackyardSwitcherMock switcherMock = new BackyardSwitcherMock();
//		
//		// Act
//		SmartHomeController controller = new SmartHomeController(switcherMock);
//		controller.actuateLights(motionDetected, time);
//		
//		// Assert
//		assertFalse(switcherMock.turnOnHasBeenCalled);	
//		assertFalse(switcherMock.turnOffHasBeenCalled);	
//	}
	
	
	
	
	@Test
	void SiDetectaMovimiento_Y_EsEvening_Entonces_SeDeberíaEncenderLaBombilla() {
		// Setup
		boolean motionDetected = true;
		LocalDateTime time = LocalDateTime.now().withHour(19);
		
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		// Act
		SmartHomeController controller = new SmartHomeController(switcherMock);
		controller.actuateLights(motionDetected, time);
		
		// Assert
		Mockito.verify(switcherMock).turnOn();	
	}
	
	@Test
	void SiDetectaMovimiento_Y_EsNight_Entonces_SeDeberíaEncenderLaBombilla() {
		// Setup
		boolean motionDetected = true;
		LocalDateTime time = LocalDateTime.now().withHour(4);
		
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		// Act
		SmartHomeController controller = new SmartHomeController(switcherMock);
		controller.actuateLights(motionDetected, time);
		
		// Assert
		Mockito.verify(switcherMock).turnOn();	
	}
	
	@Test
	void SiDetectaMovimiento_Y_EsMorning_Entonces_SeDeberíaApagarLaBombilla() {
		// Setup
		boolean motionDetected = true;
		LocalDateTime time = LocalDateTime.now().withHour(10);
		
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		// Act
		SmartHomeController controller = new SmartHomeController(switcherMock);
		controller.actuateLights(motionDetected, time);
		
		// Assert
		Mockito.verify(switcherMock).turnOff();	
	}
	
	@Test
	void SiDetectaMovimiento_Y_EsAfternoon_Entonces_SeDeberíaApagarLaBombilla() {
		// Setup
		boolean motionDetected = true;
		LocalDateTime time = LocalDateTime.now().withHour(10);
		
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		// Act
		SmartHomeController controller = new SmartHomeController(switcherMock);
		controller.actuateLights(motionDetected, time);
		
		// Assert
		Mockito.verify(switcherMock).turnOff();	
	}
	
	@Test
	void SiNoDetectaMovimiento_Y_EsMorning_Entonces_SeDeberíaApagarLaBombilla() {
		// Setup
		boolean motionDetected = false;
		LocalDateTime time = LocalDateTime.now().withHour(10);
		
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		// Act
		SmartHomeController controller = new SmartHomeController(switcherMock);
		controller.actuateLights(motionDetected, time);
		
		// Assert
		Mockito.verify(switcherMock).turnOff();	
	}
	
	@Test
	void SiNoDetectaMovimiento_Y_EsAfternoon_Entonces_SeDeberíaApagarLaBombilla() {
		// Setup
		boolean motionDetected = false;
		LocalDateTime time = LocalDateTime.now().withHour(16);
		
		BackyardSwitcher switcherMock = mock(BackyardSwitcher.class);
		
		// Act
		SmartHomeController controller = new SmartHomeController(switcherMock);
		controller.actuateLights(motionDetected, time);
		
		// Assert
		Mockito.verify(switcherMock).turnOff();	
	}
	
	@Test
	void SiEsEvening_Y_PasaMenosDe60SegundosSinDetectarMovimiento_LaBombillaSeQuedaComoEstá() {
		// SetUp - parte 1:
		// Llamo a actuateLights:
		// - Con detección de movimiento
		// - Siendo Evening
		// - para que se encienda la bombilla
		//TimeUtils timeUtils = Mockito.mock(TimeUtils.class);
		SwitcherInterface mockSwitcher = Mockito.mock(BackyardSwitcher.class);
		LocalDateTime time1 = LocalDateTime.now().withHour(19).withMinute(10).withSecond(00);

		SmartHomeController controller = new SmartHomeController(mockSwitcher);
		controller.actuateLights(true, time1);
		Mockito.reset(mockSwitcher);

		// SetUp - parte 2:
		// Setup para llamar a actuateLights:
		// - SIN detección de movimiento
		// - Siendo Evening
		// - Habiendo pasado menos tiempo del necesario (59 segundos)
		// - Para VERIFICAR que NO se actúa sobre la bombilla

		LocalDateTime time2 = LocalDateTime.now().withHour(19).withMinute(10).withSecond(59);
		// Fin del Setup

		// Act
		controller.actuateLights(false, time2);

		// Assert
		Mockito.verify(mockSwitcher, Mockito.never()).turnOn();
		Mockito.verify(mockSwitcher, Mockito.never()).turnOff();
	}
	
	@Test
	void SiPasaElTiempoEstipuladoSinDetectarMovimientoSeApagaLaBombilla() {
		// SetUp - parte 1:
		// Llamo a actuateLights:
		// - Con detección de movimiento
		// - Siendo Evening
		// - para que se encienda la bombilla
		SwitcherInterface mockSwitcher = Mockito.mock(BackyardSwitcher.class);
		LocalDateTime time1 = LocalDateTime.now().withHour(19).withMinute(10).withSecond(00);

		SmartHomeController controller = new SmartHomeController(mockSwitcher);
		controller.actuateLights(true, time1);
		Mockito.reset(mockSwitcher);
		
		// SetUp - parte 2:
		// Setup para llamar a actuateLights:
		// - SIN detección de movimiento
		// - Siendo Evening
		// - Habiendo pasado el tiempo necesario
		// - Para VERIFICAR que se apaga la bombilla
		LocalDateTime time2 = LocalDateTime.now().withHour(19).withMinute(11).withSecond(01);

		// Fin del Setup

		// Act
		controller.actuateLights(false, time2);

		// Assert
		Mockito.verify(mockSwitcher).turnOff();
	}

}



//1- true, evening (19) => encender la bombilla
//2- true, night => encender la bombilla
//3- true, morning => apagar la bombilla
//4- true, afternoon => apagar la bombilla
//
//5- false, evening (19), han pasado menos de 60 segundos (59) => dejarla como está
//6- false, evening, han pasado más de 60 segundos (61) => apagar la bombilla
//7- false, night, han pasado menos de 60 segundos => dejarla como está
//8- false, night, han pasado más de 60 segundos => apagar la bombilla
//9- false, morning => apagar la bombilla
//10- false, afternoon => apagar la bombilla
//
