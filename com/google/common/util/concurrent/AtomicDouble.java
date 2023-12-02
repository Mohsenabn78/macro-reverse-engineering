package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    private transient AtomicLong f28387a;

    public AtomicDouble(double d4) {
        this.f28387a = new AtomicLong(Double.doubleToRawLongBits(d4));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f28387a = new AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    @CanIgnoreReturnValue
    public final double addAndGet(double d4) {
        long j4;
        double longBitsToDouble;
        do {
            j4 = this.f28387a.get();
            longBitsToDouble = Double.longBitsToDouble(j4) + d4;
        } while (!this.f28387a.compareAndSet(j4, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d4, double d5) {
        return this.f28387a.compareAndSet(Double.doubleToRawLongBits(d4), Double.doubleToRawLongBits(d5));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.f28387a.get());
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(double d4) {
        long j4;
        double longBitsToDouble;
        do {
            j4 = this.f28387a.get();
            longBitsToDouble = Double.longBitsToDouble(j4);
        } while (!this.f28387a.compareAndSet(j4, Double.doubleToRawLongBits(longBitsToDouble + d4)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d4) {
        return Double.longBitsToDouble(this.f28387a.getAndSet(Double.doubleToRawLongBits(d4)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d4) {
        this.f28387a.lazySet(Double.doubleToRawLongBits(d4));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d4) {
        this.f28387a.set(Double.doubleToRawLongBits(d4));
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d4, double d5) {
        return this.f28387a.weakCompareAndSet(Double.doubleToRawLongBits(d4), Double.doubleToRawLongBits(d5));
    }

    public AtomicDouble() {
        this(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }
}
