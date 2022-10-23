package advanced;

import java.util.Random;

public class MotionDetector {
	private final Random random = new Random();

	public boolean detect() {
		return random.nextBoolean();
	}
}
