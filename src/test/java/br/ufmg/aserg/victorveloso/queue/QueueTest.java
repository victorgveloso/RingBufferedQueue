package br.ufmg.aserg.victorveloso.queue;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases where Queue is initialized with an array of ints by the static factory method .fromIntArray
 */
class IntQueueTest {
    private Queue<Integer> sut;

    @BeforeEach
    void setUp() {
        sut = new Queue<>(new Integer[]{23, 14, 55, 3, 0, -5});
    }

    @Test
    void testEnqueueOnFull() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class).isThrownBy(() -> {
            sut.enqueue(8);
        });
    }
}