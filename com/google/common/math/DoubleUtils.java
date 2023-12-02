package com.google.common.math;

import com.google.android.gms.location.places.Place;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigInteger;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
final class DoubleUtils {
    private DoubleUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        boolean z3 = true;
        int bitLength = abs.bitLength() - 1;
        if (bitLength < 63) {
            return bigInteger.longValue();
        }
        if (bitLength > 1023) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int i4 = (bitLength - 52) - 1;
        long longValue = abs.shiftRight(i4).longValue();
        long j4 = (longValue >> 1) & 4503599627370495L;
        if ((longValue & 1) == 0 || ((j4 & 1) == 0 && abs.getLowestSetBit() >= i4)) {
            z3 = false;
        }
        if (z3) {
            j4++;
        }
        return Double.longBitsToDouble((((bitLength + Place.TYPE_SUBLOCALITY_LEVEL_1) << 52) + j4) | (bigInteger.signum() & Long.MIN_VALUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double b(double d4) {
        Preconditions.checkArgument(!Double.isNaN(d4));
        return Math.max(d4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(double d4) {
        Preconditions.checkArgument(d(d4), "not a normal value");
        int exponent = Math.getExponent(d4);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d4) & 4503599627370495L;
        if (exponent == -1023) {
            return doubleToRawLongBits << 1;
        }
        return doubleToRawLongBits | 4503599627370496L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(double d4) {
        if (Math.getExponent(d4) <= 1023) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(double d4) {
        if (Math.getExponent(d4) >= -1022) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double f(double d4) {
        return -Math.nextUp(-d4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double g(double d4) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d4) & 4503599627370495L) | 4607182418800017408L);
    }
}
