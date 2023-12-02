package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes3.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, C0136a> f16922a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f16923b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0136a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f16924a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f16925b;

        C0136a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<C0136a> f16926a = new ArrayDeque();

        b() {
        }

        C0136a a() {
            C0136a poll;
            synchronized (this.f16926a) {
                poll = this.f16926a.poll();
            }
            if (poll == null) {
                return new C0136a();
            }
            return poll;
        }

        void b(C0136a c0136a) {
            synchronized (this.f16926a) {
                if (this.f16926a.size() < 10) {
                    this.f16926a.offer(c0136a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        C0136a c0136a;
        synchronized (this) {
            c0136a = this.f16922a.get(str);
            if (c0136a == null) {
                c0136a = this.f16923b.a();
                this.f16922a.put(str, c0136a);
            }
            c0136a.f16925b++;
        }
        c0136a.f16924a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        C0136a c0136a;
        synchronized (this) {
            c0136a = (C0136a) Preconditions.checkNotNull(this.f16922a.get(str));
            int i4 = c0136a.f16925b;
            if (i4 >= 1) {
                int i5 = i4 - 1;
                c0136a.f16925b = i5;
                if (i5 == 0) {
                    C0136a remove = this.f16922a.remove(str);
                    if (remove.equals(c0136a)) {
                        this.f16923b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c0136a + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + c0136a.f16925b);
            }
        }
        c0136a.f16924a.unlock();
    }
}
