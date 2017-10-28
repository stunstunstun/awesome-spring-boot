package com.stunstun.spring;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class QueueTests {

    @Test
    public void twoStackQueue() {
        Queue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertThat(queue.dequeue()).isEqualTo(1);
        assertThat(queue.contains(2)).isTrue();
        assertThat(queue.size()).isEqualTo(1);
        assertThat(queue.isEmpty()).isFalse();
    }

    @Test
    public void twoStackQueueByMultiThreads() {
        Queue<Integer> queue = new TwoStackQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(100);

        IntStream.range(0, 10000).forEach(i -> executor.submit(() -> {
            queue.enqueue(i);
            queue.dequeue();
        }));

        ConcurrentUtils.stop(executor);
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    public void arrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>(10);
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        assertThat(queue.size()).isEqualTo(10);
        assertThat(queue.dequeue()).isEqualTo(5);
        assertThat(queue.size()).isEqualTo(9);
    }

    @Test
    public void arrayQueueByMultiThreads() {
        Queue<Integer> queue = new ArrayQueue<>(10);
        ExecutorService executor = Executors.newFixedThreadPool(100);

        IntStream.range(0, 10000).forEach(i -> executor.submit(() -> {
            queue.enqueue(i);
            queue.dequeue();
        }));

        ConcurrentUtils.stop(executor);
        assertThat(queue.isEmpty()).isTrue();
    }
}
