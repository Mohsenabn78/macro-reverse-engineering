package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
class DelegatingScheduledFuture<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledFuture<?> f29260a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface Completer<T> {
        void a(Throwable th);

        void set(T t3);
    }

    /* loaded from: classes5.dex */
    interface Resolver<T> {
        ScheduledFuture<?> a(Completer<T> completer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegatingScheduledFuture(Resolver<V> resolver) {
        this.f29260a = resolver.a(new Completer<V>() { // from class: com.google.firebase.concurrent.DelegatingScheduledFuture.1
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Completer
            public void a(Throwable th) {
                DelegatingScheduledFuture.this.setException(th);
            }

            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Completer
            public void set(V v3) {
                DelegatingScheduledFuture.this.set(v3);
            }
        });
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    protected void afterDone() {
        this.f29260a.cancel(wasInterrupted());
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(Delayed delayed) {
        return this.f29260a.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f29260a.getDelay(timeUnit);
    }
}
