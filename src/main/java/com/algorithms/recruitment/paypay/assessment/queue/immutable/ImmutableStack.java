package com.algorithms.recruitment.paypay.assessment.queue.immutable;

import com.algorithms.recruitment.paypay.assessment.queue.Stack;

public final class ImmutableStack<T> implements Stack<T> {
    private final T head;
    private final Stack<T> tail;

    public ImmutableStack(T head, Stack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> getTail() {
        return tail;
    }

    @Override
    public T peek() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public final static Stack getEmptyStack(){
        return EmptyStack.getInstance();
    }

    /**** Singleton ****/
    private static final class EmptyStack<T> implements Stack<T> {
        private static final EmptyStack emptyStack = new EmptyStack();

        public final static Stack getInstance(){
            return emptyStack;
        }

        public final Stack<T> push(T t){
            return new ImmutableStack<T>(t, this);
        }

        public final Stack<T> getTail() {
            throw new RuntimeException("Stack is empty.");
        }

        public final T peek() {
            throw new RuntimeException("Stack is empty.");
        }

        public final boolean isEmpty(){
            return true;
        }
    }
}
