package com.algorithms.recruitment.paypay.assessment.queue;

public interface Stack<T> {
    Stack<T> push(T t);
    T peek();
    boolean isEmpty();
    Stack<T> getTail();
}
