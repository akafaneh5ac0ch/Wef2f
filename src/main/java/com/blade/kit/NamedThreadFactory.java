package com.blade.kit;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.LongAdder;

public class NamedThreadFactory implements ThreadFactory {

    private final String prefix;
    private final LongAdder threadNumber = new LongAdder();

    public NamedThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        threadNumber.add(1);
        if (threadNumber.intValue() < 10) {
            return new Thread(runnable, prefix + "thread-0" + threadNumber.intValue());
        }
        return new Thread(runnable, prefix + "thread-" + threadNumber.intValue());
    }
}