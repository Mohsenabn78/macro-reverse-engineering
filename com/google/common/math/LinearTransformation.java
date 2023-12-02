package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class LinearTransformation {

    /* loaded from: classes5.dex */
    public static final class LinearTransformationBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final double f28066a;

        /* renamed from: b  reason: collision with root package name */
        private final double f28067b;

        public LinearTransformation and(double d4, double d5) {
            boolean z3;
            boolean z4 = true;
            if (DoubleUtils.d(d4) && DoubleUtils.d(d5)) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            double d6 = this.f28066a;
            if (d4 == d6) {
                if (d5 == this.f28067b) {
                    z4 = false;
                }
                Preconditions.checkArgument(z4);
                return new VerticalLinearTransformation(this.f28066a);
            }
            return withSlope((d5 - this.f28067b) / (d4 - d6));
        }

        public LinearTransformation withSlope(double d4) {
            Preconditions.checkArgument(!Double.isNaN(d4));
            if (DoubleUtils.d(d4)) {
                return new RegularLinearTransformation(d4, this.f28067b - (this.f28066a * d4));
            }
            return new VerticalLinearTransformation(this.f28066a);
        }

        private LinearTransformationBuilder(double d4, double d5) {
            this.f28066a = d4;
            this.f28067b = d5;
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.f28068a;
    }

    public static LinearTransformation horizontal(double d4) {
        Preconditions.checkArgument(DoubleUtils.d(d4));
        return new RegularLinearTransformation(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, d4);
    }

    public static LinearTransformationBuilder mapping(double d4, double d5) {
        boolean z3;
        if (DoubleUtils.d(d4) && DoubleUtils.d(d5)) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        return new LinearTransformationBuilder(d4, d5);
    }

    public static LinearTransformation vertical(double d4) {
        Preconditions.checkArgument(DoubleUtils.d(d4));
        return new VerticalLinearTransformation(d4);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d4);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class VerticalLinearTransformation extends LinearTransformation {

        /* renamed from: a  reason: collision with root package name */
        final double f28072a;
        @CheckForNull
        @LazyInit

        /* renamed from: b  reason: collision with root package name */
        LinearTransformation f28073b;

        VerticalLinearTransformation(double d4) {
            this.f28072a = d4;
            this.f28073b = null;
        }

        private LinearTransformation a() {
            return new RegularLinearTransformation(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.f28072a, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.f28073b;
            if (linearTransformation == null) {
                LinearTransformation a4 = a();
                this.f28073b = a4;
                return a4;
            }
            return linearTransformation;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f28072a));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d4) {
            throw new IllegalStateException();
        }

        VerticalLinearTransformation(double d4, LinearTransformation linearTransformation) {
            this.f28072a = d4;
            this.f28073b = linearTransformation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class RegularLinearTransformation extends LinearTransformation {

        /* renamed from: a  reason: collision with root package name */
        final double f28069a;

        /* renamed from: b  reason: collision with root package name */
        final double f28070b;
        @CheckForNull
        @LazyInit

        /* renamed from: c  reason: collision with root package name */
        LinearTransformation f28071c;

        RegularLinearTransformation(double d4, double d5) {
            this.f28069a = d4;
            this.f28070b = d5;
            this.f28071c = null;
        }

        private LinearTransformation a() {
            double d4 = this.f28069a;
            if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return new RegularLinearTransformation(1.0d / d4, (this.f28070b * (-1.0d)) / d4, this);
            }
            return new VerticalLinearTransformation(this.f28070b, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.f28071c;
            if (linearTransformation == null) {
                LinearTransformation a4 = a();
                this.f28071c = a4;
                return a4;
            }
            return linearTransformation;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            if (this.f28069a == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.f28069a;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f28069a), Double.valueOf(this.f28070b));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d4) {
            return (d4 * this.f28069a) + this.f28070b;
        }

        RegularLinearTransformation(double d4, double d5, LinearTransformation linearTransformation) {
            this.f28069a = d4;
            this.f28070b = d5;
            this.f28071c = linearTransformation;
        }
    }

    /* loaded from: classes5.dex */
    private static final class NaNLinearTransformation extends LinearTransformation {

        /* renamed from: a  reason: collision with root package name */
        static final NaNLinearTransformation f28068a = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d4) {
            return Double.NaN;
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }
    }
}
