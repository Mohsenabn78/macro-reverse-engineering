package com.koushikdutta.async;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class AsyncSemaphore {

    /* renamed from: a  reason: collision with root package name */
    Semaphore f34663a = new Semaphore(0);

    public void acquire() throws InterruptedException {
        ThreadQueue a4 = ThreadQueue.a(Thread.currentThread());
        AsyncSemaphore asyncSemaphore = a4.waiter;
        a4.waiter = this;
        Semaphore semaphore = a4.queueSemaphore;
        try {
            if (this.f34663a.tryAcquire()) {
                return;
            }
            while (true) {
                Runnable remove = a4.remove();
                if (remove == null) {
                    semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                    if (this.f34663a.tryAcquire()) {
                        return;
                    }
                } else {
                    remove.run();
                }
            }
        } finally {
            a4.waiter = asyncSemaphore;
        }
    }

    public void release() {
        this.f34663a.release();
        ThreadQueue.b(this);
    }

    public boolean tryAcquire(long j4, TimeUnit timeUnit) throws InterruptedException {
        long convert = TimeUnit.MILLISECONDS.convert(j4, timeUnit);
        ThreadQueue a4 = ThreadQueue.a(Thread.currentThread());
        AsyncSemaphore asyncSemaphore = a4.waiter;
        a4.waiter = this;
        Semaphore semaphore = a4.queueSemaphore;
        try {
            if (this.f34663a.tryAcquire()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable remove = a4.remove();
                if (remove == null) {
                    if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), convert, TimeUnit.MILLISECONDS)) {
                        return false;
                    }
                    if (this.f34663a.tryAcquire()) {
                        return true;
                    }
                    if (System.currentTimeMillis() - currentTimeMillis >= convert) {
                        return false;
                    }
                } else {
                    remove.run();
                }
            }
        } finally {
            a4.waiter = asyncSemaphore;
        }
    }
}
