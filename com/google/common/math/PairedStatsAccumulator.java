package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class PairedStatsAccumulator {

    /* renamed from: a  reason: collision with root package name */
    private final StatsAccumulator f28085a = new StatsAccumulator();

    /* renamed from: b  reason: collision with root package name */
    private final StatsAccumulator f28086b = new StatsAccumulator();

    /* renamed from: c  reason: collision with root package name */
    private double f28087c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    private static double a(double d4) {
        return Doubles.constrainToRange(d4, -1.0d, 1.0d);
    }

    private double b(double d4) {
        if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d4;
        }
        return Double.MIN_VALUE;
    }

    public void add(double d4, double d5) {
        this.f28085a.add(d4);
        if (Doubles.isFinite(d4) && Doubles.isFinite(d5)) {
            if (this.f28085a.count() > 1) {
                this.f28087c += (d4 - this.f28085a.mean()) * (d5 - this.f28086b.mean());
            }
        } else {
            this.f28087c = Double.NaN;
        }
        this.f28086b.add(d5);
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.f28085a.addAll(pairedStats.xStats());
        if (this.f28086b.count() == 0) {
            this.f28087c = pairedStats.c();
        } else {
            this.f28087c += pairedStats.c() + ((pairedStats.xStats().mean() - this.f28085a.mean()) * (pairedStats.yStats().mean() - this.f28086b.mean()) * pairedStats.count());
        }
        this.f28086b.addAll(pairedStats.yStats());
    }

    public long count() {
        return this.f28085a.count();
    }

    public final LinearTransformation leastSquaresFit() {
        boolean z3;
        boolean z4 = true;
        if (count() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (Double.isNaN(this.f28087c)) {
            return LinearTransformation.forNaN();
        }
        double c4 = this.f28085a.c();
        if (c4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (this.f28086b.c() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return LinearTransformation.mapping(this.f28085a.mean(), this.f28086b.mean()).withSlope(this.f28087c / c4);
            }
            return LinearTransformation.horizontal(this.f28086b.mean());
        }
        if (this.f28086b.c() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z4 = false;
        }
        Preconditions.checkState(z4);
        return LinearTransformation.vertical(this.f28085a.mean());
    }

    public final double pearsonsCorrelationCoefficient() {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (count() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (Double.isNaN(this.f28087c)) {
            return Double.NaN;
        }
        double c4 = this.f28085a.c();
        double c5 = this.f28086b.c();
        if (c4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4);
        if (c5 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return a(this.f28087c / Math.sqrt(b(c4 * c5)));
    }

    public double populationCovariance() {
        boolean z3;
        if (count() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.f28087c / count();
    }

    public final double sampleCovariance() {
        boolean z3;
        if (count() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.f28087c / (count() - 1);
    }

    public PairedStats snapshot() {
        return new PairedStats(this.f28085a.snapshot(), this.f28086b.snapshot(), this.f28087c);
    }

    public Stats xStats() {
        return this.f28085a.snapshot();
    }

    public Stats yStats() {
        return this.f28086b.snapshot();
    }
}
