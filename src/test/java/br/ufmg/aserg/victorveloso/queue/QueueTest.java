package br.ufmg.aserg.victorveloso.queue;

import static org.assertj.core.api.Assertions.*;

import com.sun.tools.javac.util.List;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void testSize() {
        assertThat(sut.size()).isEqualTo(6);
    }

}