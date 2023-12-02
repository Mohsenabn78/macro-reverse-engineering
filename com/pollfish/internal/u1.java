package com.pollfish.internal;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class u1<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f37260a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<a<T>> f37261b;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(@Nullable T t3);
    }

    public u1() {
        this.f37261b = new ConcurrentLinkedQueue<>();
    }

    @Nullable
    public final T a() {
        return this.f37260a;
    }

    public final void b(@NotNull a<T> aVar) {
        synchronized (this) {
            this.f37261b.add(aVar);
        }
    }

    public final void c(@NotNull a<T> aVar) {
        synchronized (this) {
            this.f37261b.remove(aVar);
        }
    }

    public final void a(@Nullable T t3) {
        synchronized (this) {
            this.f37260a = t3;
            Iterator<a<T>> it = this.f37261b.iterator();
            while (it.hasNext()) {
                it.next().a(this.f37260a);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public u1(T t3) {
        this();
        a((u1<T>) t3);
    }

    public final void b() {
        synchronized (this) {
            this.f37261b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean a(@NotNull a<T> aVar) {
        return this.f37261b.contains(aVar);
    }
}
