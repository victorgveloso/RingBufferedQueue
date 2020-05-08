package br.ufmg.aserg.victorveloso.queue;

import java.util.Arrays;

/**
 * A queue implementation based on ring buffer and cursors. Hence, less "memory hungry" and less flexible.
 * @param <T> The type of queue's elements
 */
public class Queue<T> {
    private T[] elements;
    private int start;
    private int end;

    public Queue(final T[] elements) {
        start = 0;
        this.elements = Arrays.copyOf(elements, elements.length + 1);
        end = elements.length - 1;
    }

    /**
     * Get queue's current size
     * @return The number of elements in queue
     */
    public int size() {
        return Math.floorMod((end - start), elements.length);
    }

    /**
     * Push new element to the end of queue
     * @param o New element
     */
    public void enqueue(T o) {
        if (start == next(end)) { // Is it full?
                throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
        elements[end] = o;
        end = next(end);
    }

    /**
     * Pops the first element from queue
     * @return First element
     */
    public T dequeue() {
        if (start == end) { // Is it empty?
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        T detached = elements[start];
        start = next(start);
        return detached;
    }
    /**
     * Handle cyclic nature of Ring Buffer
     * @param index An elements's cursor
     * @return The next position on elements (a Ring Buffer)
     */
    private int next(int index) {
        return (index + 1) % elements.length;
    }
}
