
import java.util.Random;
import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			return a + b;
		}
	}

	public int randomNumberSquared() {
		int number = getRandomInt();

		return number * number;
	}

	@VisibleForTesting
	int getRandomInt() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(10) + 1;
	}
}
