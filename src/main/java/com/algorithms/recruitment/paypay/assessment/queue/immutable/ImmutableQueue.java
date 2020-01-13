package com.algorithms.recruitment.paypay.assessment.queue.immutable;

import com.algorithms.recruitment.paypay.assessment.queue.Queue;
import com.algorithms.recruitment.paypay.assessment.queue.Stack;

public class ImmutableQueue<T> implements Queue<T> {

    private final Stack<T> backwards;
    private final Stack<T> forwards;

    private ImmutableQueue(Stack<T> forwards, Stack<T> backwards) {
        this.forwards = forwards;
        this.backwards = backwards;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private final static Stack reverseStack(Stack stack) {
        Stack reverseStack = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty()){//traverse throw head
            reverseStack = reverseStack.push(stack.peek());
            stack = stack.getTail();//get the stack without the head
        }

        return reverseStack;
    }

    @SuppressWarnings({ "rawtypes" })
    public final static Queue getEmptyQueue(){
        return EmptyQueue.getInstance();
    }

    public final Queue<T> enQueue(T t){
        return new ImmutableQueue<T>(forwards, backwards.push(t));
    }

    /**
     * Removes the element at the beginning of the immutable queue, and returns the new queue.
     */
    @SuppressWarnings("unchecked")
    public final Queue<T> deQueue() {
        Stack<T> forwardsWithoutHead = forwards.getTail();//the whole stack without the head
        if (!forwardsWithoutHead.isEmpty()){//in most cases
            return new ImmutableQueue<T>(forwardsWithoutHead, backwards);
        }
        else if (backwards.isEmpty()){//both empty
            return ImmutableQueue.getEmptyQueue();
        }
        else {//forwards is empty, but backward is not
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwards), ImmutableStack.getEmptyStack());
        }
    }

    @Override
    public final T head() {
        return forwards.peek();
    }

    public final boolean isEmpty(){
        return false;
    }

    private static final class EmptyQueue<T> implements Queue<T>{

        @SuppressWarnings("rawtypes")
        private final static EmptyQueue emptyQueue = new EmptyQueue();

        @SuppressWarnings("rawtypes")
        public final static EmptyQueue getInstance(){
            return emptyQueue;
        }

        @SuppressWarnings("unchecked")
        public final Queue<T> enQueue(T t){
            return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
        }

        public final Queue<T> deQueue() {
            throw new RuntimeException("Queue is empty.");
        }

        public final T head() {
            throw new RuntimeException("Queue is empty.");
        }

        public final boolean isEmpty(){
            return true;
        }
    }
}
