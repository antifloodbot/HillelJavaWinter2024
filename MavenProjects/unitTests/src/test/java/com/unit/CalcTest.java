package com.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    @Tag("calc")
    @DisplayName("adding")
    void add() {
        assertEquals(4, new Calc().add(2,2));
    }

    @Test
    @Tag("calc")
    @DisplayName("dividing")
    void div() {
        assertEquals(1, new Calc().div(2,2));
    }

    @Test
    @Tag("calc")
    @DisplayName("dividing by zero")
    void divByZero() {
        assertThrows(ArithmeticException.class, () -> new Calc().div(2,0));
    }

    @Test
    @Tag("calc")
    @DisplayName("substraction")
    void sub() {
        assertEquals(4, new Calc().sub(6,2));
    }
}