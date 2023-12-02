package com.hippo.quickjs.android;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;

/* compiled from: NativeCleaner.java */
/* loaded from: classes6.dex */
abstract class j<T> {

    /* renamed from: a  reason: collision with root package name */
    private Set<b<T>> f34090a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private ReferenceQueue<T> f34091b = new ReferenceQueue<>();

    /* compiled from: NativeCleaner.java */
    /* loaded from: classes6.dex */
    private static class b<T> extends PhantomReference<T> {

        /* renamed from: a  reason: collision with root package name */
        private long f34092a;

        private b(T t3, long j4, ReferenceQueue<? super T> referenceQueue) {
            super(t3, referenceQueue);
            this.f34092a = j4;
        }
    }

    public void a() {
        while (true) {
            b bVar = (b) this.f34091b.poll();
            if (bVar != null) {
                if (this.f34090a.contains(bVar)) {
                    c(bVar.f34092a);
                    this.f34090a.remove(bVar);
                }
            } else {
                return;
            }
        }
    }

    public void b() {
        for (b<T> bVar : this.f34090a) {
            c(((b) bVar).f34092a);
        }
        this.f34090a.clear();
    }

    public abstract void c(long j4);

    public void d(T t3, long j4) {
        this.f34090a.add(new b<>(t3, j4, this.f34091b));
    }
}
