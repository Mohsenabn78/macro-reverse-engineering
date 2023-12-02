package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class StatsAccumulator {

    /* renamed from: a  reason: collision with root package name */
    private long f28093a = 0;

    /* renamed from: b  reason: collision with root package name */
    private double f28094b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* renamed from: c  reason: collision with root package name */
    private double f28095c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* renamed from: d  reason: collision with root package name */
    private double f28096d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    private double f28097e = Double.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(double d4, double d5) {
        if (Doubles.isFinite(d4)) {
            return d5;
        }
        if (!Doubles.isFinite(d5) && d4 != d5) {
            return Double.NaN;
        }
        return d4;
    }

    private void b(long j4, double d4, double d5, double d6, double d7) {
        long j5 = this.f28093a;
        if (j5 == 0) {
            this.f28093a = j4;
            this.f28094b = d4;
            this.f28095c = d5;
            this.f28096d = d6;
            this.f28097e = d7;
            return;
        }
        this.f28093a = j5 + j4;
        if (Doubles.isFinite(this.f28094b) && Doubles.isFinite(d4)) {
            double d8 = this.f28094b;
            double d9 = d4 - d8;
            double d10 = j4;
            double d11 = d8 + ((d9 * d10) / this.f28093a);
            this.f28094b = d11;
            this.f28095c += d5 + (d9 * (d4 - d11) * d10);
        } else {
            this.f28094b = a(this.f28094b, d4);
            this.f28095c = Double.NaN;
        }
        this.f28096d = Math.min(this.f28096d, d6);
        this.f28097e = Math.max(this.f28097e, d7);
    }

    public void add(double d4) {
        long j4 = this.f28093a;
        if (j4 == 0) {
            this.f28093a = 1L;
            this.f28094b = d4;
            this.f28096d = d4;
            this.f28097e = d4;
            if (!Doubles.isFinite(d4)) {
                this.f28095c = Double.NaN;
                return;
            }
            return;
        }
        this.f28093a = j4 + 1;
        if (Doubles.isFinite(d4) && Doubles.isFinite(this.f28094b)) {
            double d5 = this.f28094b;
            double d6 = d4 - d5;
            double d7 = d5 + (d6 / this.f28093a);
            this.f28094b = d7;
            this.f28095c += d6 * (d4 - d7);
        } else {
            this.f28094b = a(this.f28094b, d4);
            this.f28095c = Double.NaN;
        }
        this.f28096d = Math.min(this.f28096d, d4);
        this.f28097e = Math.max(this.f28097e, d4);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            add(number.doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.f28095c;
    }

    public long count() {
        return this.f28093a;
    }

    public double max() {
        boolean z3;
        if (this.f28093a != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.f28097e;
    }

    public double mean() {
        boolean z3;
        if (this.f28093a != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.f28094b;
    }

    public double min() {
        boolean z3;
        if (this.f28093a != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.f28096d;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        boolean z3;
        if (this.f28093a != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (Double.isNaN(this.f28095c)) {
            return Double.NaN;
        }
        if (this.f28093a == 1) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return DoubleUtils.b(this.f28095c) / this.f28093a;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        boolean z3;
        if (this.f28093a > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (Double.isNaN(this.f28095c)) {
            return Double.NaN;
        }
        return DoubleUtils.b(this.f28095c) / (this.f28093a - 1);
    }

    public Stats snapshot() {
        return new Stats(this.f28093a, this.f28094b, this.f28095c, this.f28096d, this.f28097e);
    }

    public final double sum() {
        return this.f28094b * this.f28093a;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d4 : dArr) {
            add(d4);
        }
    }

    public void addAll(int... iArr) {
        for (int i4 : iArr) {
            add(i4);
        }
    }

    public void addAll(long... jArr) {
        for (long j4 : jArr) {
            add(j4);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        b(stats.count(), stats.mean(), stats.b(), stats.min(), stats.max());
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() == 0) {
            return;
        }
        b(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.c(), statsAccumulator.min(), statsAccumulator.max());
    }
}
