package com.unit.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {

    @Test
    void add() {
        Collection col = new Collection();
        assertEquals(0, col.size());
        String str = "element";
        assertTrue(col.add(str));
        assertEquals(1, col.size());
        assertEquals(str, col.get(0));
        assertTrue(col.contain(str));
    }

    @Test
    void testAdd_valid() {
        Collection col = new Collection();
        assertEquals(0, col.size());
        String str = "element";
        assertTrue(col.add(str));
        assertEquals(1, col.size());
        assertEquals(str, col.get(0));
        assertTrue(col.contain(str));
    }

    @Test
    void testAdd_invalid_index_less_zero() {
        Collection col = new Collection();
        assertEquals(0, col.size());
        String str = "element";
        assertFalse(col.add(-1, str));
        assertEquals(0, col.size());
    }

    @Test
    void testAdd_invalid_index_more_than_zero() {
        Collection col = new Collection();
        assertEquals(0, col.size());
        String str = "element";
        assertFalse(col.add(1, str));
        assertEquals(0, col.size());
    }

    @Test
    void get_valid() {
        Collection col = new Collection();
        String str = "element";
        assertTrue(col.add(str));
        assertEquals(str, col.get(0));
    }

    @Test
    void get_invalid_exextion_negative_index() {
        Collection col = new Collection();
        assertThrows(IndexOutOfBoundsException.class, () -> col.get(-1));
    }

    @Test
    void get_invalid_exextion_out_of_bound_index() {
        Collection col = new Collection();
        assertThrows(IndexOutOfBoundsException.class, () -> col.get(0));
    }

    @Test
    void testEquals() {
        Collection col = new Collection();
        col.add("one");
        col.add("two");

        Collection col1 = new Collection();
        col1.add("one");
        col1.add("two");

        assertTrue(col.equals(col1));
    }

    @Test
    void testEquals_null() {
        Collection col = new Collection();
        col.add("one");
        col.add("two");

        assertFalse(col.equals(null));
    }

    @Test
    void testEquals_type() {
        Collection col = new Collection();
        col.add("one");
        col.add("two");

        assertFalse(col.equals(new ArrayList<>()));
    }

    @Test
    void testEquals_diff_size() {
        Collection col = new Collection();
        col.add("one");
        col.add("two");

        Collection col1 = new Collection();
        col1.add("one");

        assertFalse(col.equals(col1));

    }
}