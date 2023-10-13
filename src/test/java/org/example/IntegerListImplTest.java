package org.example;

import exceptions.InvalidIndexException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    IntegerListImpl storage = new IntegerListImpl(100);

    @Test
    void addNull() {
        assertThrows(NullPointerException.class, () -> storage.add(null));
    }

    @Test
    void addElement() {
        var result = storage.add(5);
        assertEquals(result, 5);
        assertEquals(storage.size(), 1);
        assertEquals(storage.get(0), 5);
    }

    @Test
    void testIndexOutOfBound() {
        assertThrows(InvalidIndexException.class, () -> storage.get(101));
    }

    @Test
    void testIndexOf() {
        storage.add(1);
        storage.add(2);
        storage.add(3);
        storage.add(2);

        assertEquals(storage.indexOf(2), 1);
        assertEquals(storage.lastIndexOf(2), 3);

        assertEquals(storage.indexOf(4), -1);
        assertEquals(storage.lastIndexOf(4), -1);
    }

    @Test
    void testToArray() {
        storage.add(1);
        storage.add(2);
        storage.add(3);

        var copy = storage.toArray();
        assertEquals(copy.length, 3);
        assertEquals(copy[0], 1);
        assertEquals(copy[1], 2);
        assertEquals(copy[2], 3);
    }

    @Test
    void testSet() {
        storage.add(1);
        storage.add(2);

        assertThrows(InvalidIndexException.class, () -> storage.set(3, 5));
        assertEquals(storage.set(0, 5), 5);
    }
}