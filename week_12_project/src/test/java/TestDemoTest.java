import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#arguementsForAddPositive")
	void assetThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	void assetThatRandomNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);

	}

	static Stream<Arguments> arguementsForAddPositive() {
		return Stream.of(
				Arguments.of(1, 2, 3, false),
				Arguments.of(1, -2, 0, true),
				Arguments.of(-1, 2, 0, true),
				Arguments.of(-1, -2, 0, true));
	}

}
