package advanced;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;



class TimeUtilsTest {
	
	
	// Inyección de dependencia en el constructor + mock
//	class TimeServiceManipulated_WithHour0 extends TimeService {
//		@Override()
//		public LocalDateTime getTime() {
//			LocalDateTime time = LocalDateTime.now().withHour(0);
//			return time;
//		}
//	}
//	
//	@Test
//	void test_At_0_Should_Return_Night() {
//		
//		TimeService timeService = new TimeServiceManipulated_WithHour0();
//		TimeUtils t = new TimeUtils(timeService);
//		
//		String result = t.getTimeOfDay();
//		
//		assertEquals("Night", result);
//	}
//	
	
	
	
	
	
	// Técnica de patrón costura
//	class TimeUtilsManipulated_WithHour11 extends TimeUtils {
//		@Override()
//		protected LocalDateTime getTime() {
//			LocalDateTime time = LocalDateTime.now().withHour(11);
//			return time;
//		}
//	}
//	
//	@Test
//	void test_At_11_Should_Return_Morning() {
//		
//		TimeUtils t = new TimeUtilsManipulated_WithHour11();
//		
//		String result = t.getTimeOfDay();
//		
//		assertEquals("Morning", result);
//	}
//	
//	class TimeUtilsManipulated_WithHour17 extends TimeUtils {
//		@Override()
//		protected LocalDateTime getTime() {
//			LocalDateTime time = LocalDateTime.now().withHour(17);
//			return time;
//		}
//	}
//	
//	@Test
//	void test_At_17_Should_Return_Afternoon() {
//		
//		TimeUtils t = new TimeUtilsManipulated_WithHour17();
//		
//		String result = t.getTimeOfDay();
//		
//		assertEquals("Afternoon", result);
//	}
//	
//	class TimeUtilsManipulated_WithHour23 extends TimeUtils {
//		@Override()
//		protected LocalDateTime getTime() {
//			LocalDateTime time = LocalDateTime.now().withHour(23);
//			return time;
//		}
//	}
//	
//	@Test
//	void test_At_17_Should_Return_Evening() {
//		
//		TimeUtils t = new TimeUtilsManipulated_WithHour23();
//		
//		String result = t.getTimeOfDay();
//		
//		assertEquals("Evening", result);
//	}


	@Test
	void test_At_0_Should_Return_Night() {
		
		TimeUtils t = new TimeUtils();
		LocalDateTime time = LocalDateTime.now().withHour(0);
		
		String result = t.getTimeOfDay(time);
		
		assertEquals("Night", result);
	}	
	
	@Test
	void test_At_5_Should_Return_Night() {
		
		TimeUtils t = new TimeUtils();
		LocalDateTime time = LocalDateTime.now().withHour(5);
		
		String result = t.getTimeOfDay(time);
		
		assertEquals("Night", result);
		
	}
	
	
	@Test
	void test_At_6_Should_Return_Morning() {
		
		TimeUtils t = new TimeUtils();
		LocalDateTime time = LocalDateTime.now().withHour(6);
		
		String result = t.getTimeOfDay(time);
		
		assertEquals("Morning", result);
		
	}
	
	@Test
	void test_At_17_Should_Return_Afternoon() {
		
		TimeUtils t = new TimeUtils();
		LocalDateTime time = LocalDateTime.now().withHour(17);
		
		String result = t.getTimeOfDay(time);
		
		assertEquals("Afternoon", result);
		
	}
	
	@Test
	void test_At_19_Should_Return_Evening() {
		
		TimeUtils t = new TimeUtils();
		LocalDateTime time = LocalDateTime.now().withHour(19);
		
		String result = t.getTimeOfDay(time);
		
		assertEquals("Evening", result);
		
	}

}
