package com.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class CasIncrement {
    private final AtomicInteger value = new AtomicInteger();
    private final LongAdder adder = new LongAdder();

    public void increment() {
        while (true) {
            int current = value.get();
            int next = current + 1;
            if (value.compareAndSet(current, next)) {
                break;
            }
        }
    }
}
