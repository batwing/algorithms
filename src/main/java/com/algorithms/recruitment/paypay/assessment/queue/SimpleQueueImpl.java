package com.algorithms.recruitment.paypay.assessment.queue;

public class SimpleQueueImpl<T> implements Queue<T> {

    public static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    @Override
    public Queue<T> enQueue(T data) {
        QueueNode<T> newNode = new QueueNode<T>(data);
        if (last != null) {
            last.next = newNode;
        }

        last = newNode;
        if (first == null) {
            first = last;
        }
        return this;
    }

    @Override
    public Queue<T> deQueue() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        first = first.next;
        if (first == null) {
            last = null;
        }

        return this;
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
