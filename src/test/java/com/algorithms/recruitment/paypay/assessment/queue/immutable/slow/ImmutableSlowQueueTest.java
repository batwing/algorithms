package com.algorithms.recruitment.paypay.assessment.queue.immutable.slow;

import com.algorithms.recruitment.paypay.assessment.queue.Queue;
import com.algorithms.recruitment.paypay.assessment.queue.immutable.ImmutableQueue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImmutableSlowQueueTest {

    @Test
    public void deQueueTest() {
        Queue<Integer> queue = new SlowImmutableQueue();
        Queue<Integer> previousQueue = null;

        for (int i=1; i<=10; i++){
            queue = queue.enQueue(i);
            assertTrue(previousQueue != queue);
            previousQueue = queue;
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
