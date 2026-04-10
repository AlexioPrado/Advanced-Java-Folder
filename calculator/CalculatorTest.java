/*
 * Marcus Alexio Galang Prado
 * Course: Advanced Java Programming
 * Date: 04/10/2026
 * 
 * This class tests the methods of the class Calculator. Tests for edge cases, negative values, and special cases for exponent and square roots
 */

package calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Tests the methods of the Calculator class. 
 * Responsible for the coverage of the Calculator class to make sure its methods are working as it should
 */
@DisplayName("Calculator")
class CalculatorTest {
	
	private Calculator calc;
	
	/*
	 * Sets up calc for every test method
	 */
	@BeforeEach
	void setUp() { 
		 calc = new Calculator(); 
	} 
	
	/*
	 * Tests the add method
	 * @return result of the assert
	 */
	@Test
	@DisplayName("6 + 7 equals 13")
	void addTwoDoubles() {
		assertEquals(13, calc.add(6,7), "Addition failed");
	}
	
	/*
	 * Tests the subtract method
	 * @return result of the assert
	 */
	@Test
	@DisplayName("6 - 7 equals -1")
	void subtractTwoDoubles() {
		assertEquals(-1, calc.subtract(6,7), "Subtraction failed");
	}

	/*
	 * Tests the multiply method
	 * @return result of the assert
	 */
	@Test
	@DisplayName("33.5 x 2 equals 67")
	void multiplyTwoDoubles() {
		assertEquals(67, calc.multiply(33.5,2), "Multiplication failed");
	}

	/*
	 * Tests the divide method
	 * @return result of the assert
	 */
	@Test
	@DisplayName("201 / 3 equals 67")
	void divideTwoDoubles() {
		assertEquals(67, calc.divide(201,3), "Division failed");
	}

	/*
	 * Tests the power method
	 * @return result of the assert
	 */
	@Test
	@DisplayName("21 to the power of 3 equals 9261")
	void powerTwoDoubles() {
		assertEquals(9261, calc.power(21,3), "Power failed");
	}

	/*
	 * Tests the square root method
	 * @return result of the assert
	 */
	@Test
	@DisplayName("Square root of 4489 equals 67")
	void sqrt() {
		assertEquals(67, calc.sqrt(4489), "Square Root failed");
	}
	
	/*
	 * Tests the methods of the Calculator class using edge cases
	 * Responsible for the coverage of these edge cases
	 */
	@Nested
	@DisplayName("Edge Case Testing")
	class EdgeCases {
		
		/*
		 * Test negative values of add method
		 * 
		 * @param double a
		 * @param double b
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"-6, -7, -13","-9, -10, -19","-8, -9, -17"})
		@DisplayName("Addition handling negative values")
		void additionWithCSV(double a, double b, double expected) {
			assertEquals(expected, calc.add(a, b), "Addition Failed");
		}
		
		/*
		 * Test negative values of subtract method
		 * 
		 * @param double a
		 * @param double b
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"-6, -7, 1","-9, -15, 6","-8, -7, -1"})
		@DisplayName("Subtraction handling negative values")
		void subtractionWithCSV(double a, double b, double expected) {
			assertEquals(expected, calc.subtract(a, b), "Subtraction Failed");
		}
		
		/*
		 * Test negative values of multiply method
		 * 
		 * @param double a
		 * @param double b
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"-6, -7, 42","-9, -10, 90","-8, -9, 72"})
		@DisplayName("Multiplication handling negative values")
		void multiplicationWithCSV(double a, double b, double expected) {
			assertEquals(expected, calc.multiply(a, b), "Multiplication Failed");
		}
		
		/*
		 * Test negative values of divide method
		 * 
		 * @param double a
		 * @param double b
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"-6, -2, 3","-9, -3, 3","-8, -4, 2"})
		@DisplayName("Division handling negative values")
		void divisionWithCSV(double a, double b, double expected) {
			assertEquals(expected, calc.divide(a, b), "Division Failed");
		}
		
		/*
		 * Test 0 values of multiply method
		 * 
		 * @param double a
		 * @param double b
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"6, 0, 0","9, 0, 0","8, 0, 0","67, 0, 0"})
		@DisplayName("Multiplication handling zeros")
		void multiplicationWithZero(double a, double b, double expected) {
			assertEquals(expected, calc.multiply(a, b), "Multiplication Failed");
		}
		
		/*
		 * Test inverse values of add method
		 * 
		 * @param double a
		 * @param double b
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"6, -6, 0","7, -7, 0","67, -67, 0","89, -89, 0"})
		@DisplayName("Addition inverse values")
		void additiveInverse(double a, double b, double expected) {
			assertEquals(expected, calc.add(a, b), "Addition Failed");
		}
		
		/*
		 * Test 0 values of power method
		 * 
		 * @param double a
		 * @param double exp
		 * @param double expected
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@CsvSource({"6, 0, 1","9, 0, 1","8, 0, 1","67, 0, 1"})
		@DisplayName("Power with an exponent of zero")
		void powerOfZero(double a, int exp, double expected) {
			assertEquals(expected, calc.power(a, exp), "Power Failed");
		}
		
		/*
		 * Test for square root with value of 0
		 * 
		 * @return the result of the assert
		 */
		@Test
		@DisplayName("Square Root of 0")
		void sqrtOf0() {
			assertEquals(0, calc.sqrt(0), "Square Root Failed");
		}
		
		/*
		 * Test for square root with value of 1
		 * 
		 * @return the result of the assert
		 */
		@Test
		@DisplayName("Square Root of 1")
		void sqrtOf1() {
			assertEquals(1, calc.sqrt(1), "Square Root Failed");
		}
	}
	
	/*
	 * Tests the methods of the Calculator class of which has the ability to throw an exception
	 * Responsible for testing if the methods are throwing at incorrect operations
	 *
	 */
	@Nested
	@DisplayName("Validation Testing")
	class Validation {
		
		/*
		 * Test the divide method when given a 0 to divide
		 * 
		 * @return the result of the assert
		 */
		@Test
		@DisplayName("Dividing a value by 0")
		void throwDivide() {
			ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calc.divide(67, 0));
			assertTrue(ex.getLocalizedMessage().contains("zero"));
		}
		
		/*
		 * Test the sqrt method when given negative values
		 * 
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@ValueSource(doubles = {-1, -0.001, Double.NEGATIVE_INFINITY})
		@DisplayName("Square root with negative values")
		void throwSQRTOfNegativeInteger(double num) {
			assertThrows(IllegalArgumentException.class, () -> calc.sqrt(num));
		}
		
		/*
		 * Test the power method when given negative values
		 * 
		 * @return the result of the assert
		 */
		@ParameterizedTest
		@ValueSource(ints = {-1, -5, -100})
		@DisplayName("Power with negative values")
		void throwPower(int num) {
			assertThrows(IllegalArgumentException.class, () -> calc.power(2, num));
		}
		
		/*
		 * Test multiple basic arithmetic operations in order to catch an error
		 * 
		 * @return the result of the assert
		 */
		@Test
		@DisplayName("Verify sequence of operations give correct results")
		void assertCOnsecutive() {
			assertAll ("calculator sequence",
				() -> assertEquals(21, calc.add(10, 11), "Addition Failed"),
				() -> assertEquals(35, calc.divide(70, 2), "Division Failed"),
				() -> assertEquals(24, calc.multiply(6, 4), "Multiplication Failed")
			);
		}
	}
}


 
