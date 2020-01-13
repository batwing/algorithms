package com.algorithms.recruitment.paypay.assessment.queue.immutable;

import com.algorithms.recruitment.paypay.assessment.queue.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImmutableQueueTest {

    @Test
    public void deQueueTest() {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue();
        Queue<Integer> previousQueue = null;

        for (int i=1; i<=10; i++){
            previousQueue = queue;
            queue = queue.enQueue(i);
            assertTrue(previousQueue != queue);
        }

        int queueSize = 0;
        while(!queue.isEmpty()){
            previousQueue = queue;
            queue = queue.deQueue();
            queueSize++;
            assertTrue(previousQueue != queue);
        }
        assertEquals(10, queueSize);
    }
}
