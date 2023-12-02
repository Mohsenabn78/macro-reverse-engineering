package com.koushikdutta.async;

import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

/* loaded from: classes6.dex */
public class ThreadQueue extends LinkedList<Runnable> {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<Thread, ThreadQueue> f34825a = new WeakHashMap<>();
    Semaphore queueSemaphore = new Semaphore(0);
    AsyncSemaphore waiter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadQueue a(Thread thread) {
        ThreadQueue threadQueue;
        WeakHashMap<Thread, ThreadQueue> weakHashMap = f34825a;
        synchronized (weakHashMap) {
            threadQueue = weakHashMap.get(thread);
            if (threadQueue == null) {
                threadQueue = new ThreadQueue();
                weakHashMap.put(thread, threadQueue);
            }
        }
        return threadQueue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(AsyncSemaphore asyncSemaphore) {
        WeakHashMap<Thread, ThreadQueue> weakHashMap = f34825a;
        synchronized (weakHashMap) {
            for (ThreadQueue threadQueue : weakHashMap.values()) {
                if (threadQueue.waiter == asyncSemaphore) {
                    threadQueue.queueSemaphore.release();
                }
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Runnable runnable) {
        boolean add;
        synchronized (this) {
            add = super.add((ThreadQueue) runnable);
        }
        return add;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this) {
            remove = super.remove(obj);
        }
        return remove;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Runnable remove() {
        synchronized (this) {
            if (isEmpty()) {
                return null;
            }
            return (Runnable) super.remove();
        }
    }
}
