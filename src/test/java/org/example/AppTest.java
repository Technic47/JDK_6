package org.example;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.example.App.check;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest extends AbstractTest {
    @BeforeAll
    static void init() {
        System.out.println("!!!");
        numberOfPlays = 1000;
    }

    @Test
    public void checkGame() {
        int[] results = check(numberOfPlays);

        assertEquals(numberOfPlays, results[0] + results[1]);
        assertTrue(results[0] > results[1]);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 100000, 500000})
    public void checkWrongParam(int value) {
        assertNotNull(check(value));
    }

    @Test
    public void checkGameWrongArguments(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> check(-1));
        assertEquals(exception.getMessage(), "Wrong argument!!!");
    }
}
