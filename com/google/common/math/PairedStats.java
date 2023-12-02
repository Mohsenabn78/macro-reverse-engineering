package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class PairedStats implements Serializable {
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PairedStats(Stats stats, Stats stats2, double d4) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d4;
    }

    private static double a(double d4) {
        if (d4 >= 1.0d) {
            return 1.0d;
        }
        if (d4 <= -1.0d) {
            return -1.0d;
        }
        return d4;
    }

    private static double b(double d4) {
        if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d4;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        boolean z3;
        Preconditions.checkNotNull(bArr);
        if (bArr.length == 88) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.a(order), Stats.a(order), order.getDouble());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.sumOfProductsOfDeltas;
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        if (!this.xStats.equals(pairedStats.xStats) || !this.yStats.equals(pairedStats.yStats) || Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public LinearTransformation leastSquaresFit() {
        boolean z3;
        boolean z4 = true;
        if (count() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double b4 = this.xStats.b();
        if (b4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (this.yStats.b() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / b4);
            }
            return LinearTransformation.horizontal(this.yStats.mean());
        }
        if (this.yStats.b() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z4 = false;
        }
        Preconditions.checkState(z4);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (count() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double b4 = xStats().b();
        double b5 = yStats().b();
        if (b4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4);
        if (b5 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return a(this.sumOfProductsOfDeltas / Math.sqrt(b(b4 * b5)));
    }

    public double populationCovariance() {
        boolean z3;
        if (count() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        boolean z3;
        if (count() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.c(order);
        this.yStats.c(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", populationCovariance()).toString();
        }
        return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
