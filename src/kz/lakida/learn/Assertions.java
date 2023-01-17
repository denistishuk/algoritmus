package kz.lakida.learn;

import java.util.Objects;

public final class Assertions {

    public static void assertEquals(Object o1, Object o2) {
        if (!Objects.equals(o1, o2)) {
            throw new AssertionError(o1 + " must be equal to " + o2 + " but it is not");
        }
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Condition must be true");
        }
    }

    public static void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Condition must be false");
        }
    }
}
