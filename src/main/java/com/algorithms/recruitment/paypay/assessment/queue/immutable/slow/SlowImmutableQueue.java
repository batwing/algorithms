package com.algorithms.recruitment.paypay.assessment.queue.immutable.slow;

import com.algorithms.recruitment.paypay.assessment.queue.NoSuchElementException;
import com.algorithms.recruitment.paypay.assessment.queue.Queue;

public class SlowImmutableQueue<T> implements Queue<T> {

    public static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public SlowImmutableQueue() {
    }

    private SlowImmutableQueue(QueueNode<T> first, QueueNode<T> last) {
        this.first = first;
        this.last = last;
    }

    private SlowImmutableQueue<T> getDeepCopy(){
        if (first == null) {
            return this;
        }

        QueueNode<T> newFirst = new QueueNode<T>(first.data);
        QueueNode<T> newNode = newFirst;
        QueueNode<T> oldNode = first.next;

        while (oldNode != null){
            newNode.next = new QueueNode<T>(oldNode.data);
            oldNode = oldNode.next;
        }
        QueueNode<T> newLast = newNode.next;
        return new SlowImmutableQueue<T>(newFirst, newLast);
    }

    @Override
    public Queue<T> enQueue(T data) {
        SlowImmutableQueue<T> newQueue = getDeepCopy();
        QueueNode<T> newNode = new QueueNode<T>(data);
        if (newQueue.last != null) {
            newQueue.last.next = newNode;
        }

        newQueue.last = newNode;
        if (newQueue.first == null) {
            newQueue.first = newQueue.last;
        }
        return newQueue;
    }

    @Override
    public Queue<T> deQueue() {

        if (first == null) {
            throw new NoSuchElementException();
        }

        SlowImmutableQueue<T> newQueue = getDeepCopy();
        newQueue.first = newQueue.first.next;
        if (newQueue.first == null) {
            newQueue.last = null;
        }

        return newQueue;
    }

    @Override
    public T head() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
