/*
 * Marcus Alexio Galang Prado
 * Course: Advanced Java Programming
 * Date: 04/10/2026
 * 
 * This class handles simple calculations, hence the class name, Calculator. It handles arithmetic operations, exponent and square root
 */

package calculator;

/*
 * Calculator used for calculating basic arithmetic operations and including power and square root
 * Returns the correct output of these operations and throw errors if the inputed values are incorrect
 */
public class Calculator {
	
	/*
	 * Compute addition operations
	 * 
	 * @param double a
	 * @param double b
	 * @return the result of adding both values
	 */
	public double add(double a, double b) {
		return a + b;
	}
 
	/*
	 * Compute subtraction operations
	 * 
	 * @param double a
	 * @param double b
	 * @return the result of subtracting both values
	 */
	public double subtract(double a, double b) {
		return a - b;
	}
 
	/*
	 * Compute multiplication operations
	 * 
	 * @param double a
	 * @param double b
	 * @return the result of multiplying both values
	 */
	public double multiply(double a, double b) {
		return a * b;
	}
 
	/*
	 * Compute division operations
	 * 
	 * @param double a
	 * @param double b
	 * @return the result of dividing both values
	 * @throws ArithmeticException if b is equal to 0.0
	 */
	public double divide(double a, double b) {
		if (b == 0.0) {
			throw new ArithmeticException("Can't divide by zero.");
		} else {
			return a / b;
		}
	}

	/*
	 * Compute exponent operations
	 * 
	 * @param double base
	 * @param int exp
	 * @return the result of using the first value as the base and the second value as the exponent
	 * @throws IllegalArgumentException if exp is less than 0
	 */
	public double power(double base, int exp) {
		if (exp < 0) {
			throw new IllegalArgumentException("Can't use an exponent less than 0.");
		} else {
			return Math.pow(base,  exp);
		}
	}
	
	/*
	 * Compute square root operations
	 * 
	 * @param double n
	 * @return the result of squaring a value
	 * @throws IllegalArgumentException if n is less than 0
	 */
	public double sqrt(double n) {
		if (n < 0) {
			throw new IllegalArgumentException("Can't use a number less than zero.");
		} else {
			return Math.sqrt(n);
		}
 	}
}
