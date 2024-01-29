package Lista4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class complexNumberTest {

    @Test
    void testGetModulus() {
        complexNumber z = new complexNumber(3, 4);
        assertEquals(5.0, z.getModulus(), 1e-6);
    }

    @Test
    void testGetArgument() {
        complexNumber z = new complexNumber(1, 1);
        assertEquals(Math.PI / 4, z.getArgument(), 1e-6);
    }

    @Test
    void testGetExponentialForm() {
        complexNumber z = new complexNumber(1, 1);
        assertEquals("sqrt(2.0) * exp(i0.785398)", z.getExponentialForm());
    }

    @Test
    void testPower() {
        complexNumber z = new complexNumber(2, 3);
        complexNumber result = z.power(3);
        assertEquals(-46.0, result.getX(), 1e-6);
        assertEquals(-9.0, result.getY(), 1e-6);
    }

    @Test
    void testAdd() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(1, 4);
        complexNumber result = z1.add(z2);
        assertEquals(3.0, result.getX(), 1e-6);
        assertEquals(7.0, result.getY(), 1e-6);
    }

    @Test
    void testSubtract() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(1, 4);
        complexNumber result = z1.subtract(z2);
        assertEquals(1.0, result.getX(), 1e-6);
        assertEquals(-1.0, result.getY(), 1e-6);
    }

    @Test
    void testMultiply() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(1, 4);
        complexNumber result = z1.multiply(z2);
        assertEquals(-10.0, result.getX(), 1e-6);
        assertEquals(11.0, result.getY(), 1e-6);
    }

    @Test
    void testDivide() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(1, 4);
        complexNumber result = z1.divide(z2);
        assertEquals(0.8, result.getX(), 1e-6);
        assertEquals(-0.6, result.getY(), 1e-6);
    }

    @Test
    void testDivideByZero() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(0, 0);
        assertThrows(ArithmeticException.class, () -> z1.divide(z2));
    }

    @Test
    void testEquals() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(2, 3);
        complexNumber z3 = new complexNumber(4, 5);

        assertTrue(z1.equals(z2));
        assertFalse(z1.equals(z3));
    }

    @Test
    void testHashCode() {
        complexNumber z1 = new complexNumber(2, 3);
        complexNumber z2 = new complexNumber(2, 3);
        complexNumber z3 = new complexNumber(4, 5);

        assertEquals(z1.hashCode(), z2.hashCode());
        assertNotEquals(z1.hashCode(), z3.hashCode());
    }
}