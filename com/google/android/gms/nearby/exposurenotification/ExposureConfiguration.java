package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ExposureConfigurationCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class ExposureConfiguration extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ExposureConfiguration> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getMinimumRiskScore", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22288a;
    @SafeParcelable.Field(getter = "getAttenuationScores", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int[] f22289b;
    @SafeParcelable.Field(getter = "getAttenuationWeight", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22290c;
    @SafeParcelable.Field(getter = "getDaysSinceLastExposureScores", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final int[] f22291d;
    @SafeParcelable.Field(getter = "getDaysSinceLastExposureWeight", id = 5)

    /* renamed from: e  reason: collision with root package name */
    final int f22292e;
    @SafeParcelable.Field(getter = "getDurationScores", id = 6)

    /* renamed from: f  reason: collision with root package name */
    final int[] f22293f;
    @SafeParcelable.Field(getter = "getDurationWeight", id = 7)

    /* renamed from: g  reason: collision with root package name */
    final int f22294g;
    @SafeParcelable.Field(getter = "getTransmissionRiskScores", id = 8)

    /* renamed from: h  reason: collision with root package name */
    final int[] f22295h;
    @SafeParcelable.Field(getter = "getTransmissionRiskWeight", id = 9)

    /* renamed from: i  reason: collision with root package name */
    final int f22296i;
    @SafeParcelable.Field(getter = "getDurationAtAttenuationThresholds", id = 10)

    /* renamed from: j  reason: collision with root package name */
    final int[] f22297j;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class ExposureConfigurationBuilder {

        /* renamed from: a  reason: collision with root package name */
        private int f22298a = 4;

        /* renamed from: b  reason: collision with root package name */
        private int[] f22299b = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: c  reason: collision with root package name */
        private int f22300c = 50;

        /* renamed from: d  reason: collision with root package name */
        private int[] f22301d = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: e  reason: collision with root package name */
        private int f22302e = 50;

        /* renamed from: f  reason: collision with root package name */
        private int[] f22303f = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: g  reason: collision with root package name */
        private int f22304g = 50;

        /* renamed from: h  reason: collision with root package name */
        private int[] f22305h = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: i  reason: collision with root package name */
        private int f22306i = 50;

        /* renamed from: j  reason: collision with root package name */
        private int[] f22307j = {50, 74};

        @NonNull
        public ExposureConfiguration build() {
            return new ExposureConfiguration(this.f22298a, this.f22299b, this.f22300c, this.f22301d, this.f22302e, this.f22303f, this.f22304g, this.f22305h, this.f22306i, this.f22307j);
        }

        @NonNull
        public ExposureConfigurationBuilder setAttenuationScores(@NonNull int... iArr) {
            boolean z3;
            boolean z4;
            int length = iArr.length;
            Object[] objArr = {Arrays.toString(iArr)};
            if (length == 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "attenuationScores (%s) must have exactly 8 elements", objArr);
            for (int i4 : iArr) {
                if (i4 >= 0 && i4 <= 8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "attenuationScore (%s) must be >= 0 and <= 8", Integer.valueOf(i4));
            }
            this.f22299b = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setAttenuationWeight(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 100) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "attenuationWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i4));
            this.f22300c = i4;
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setDaysSinceLastExposureScores(@NonNull int... iArr) {
            boolean z3;
            boolean z4;
            int length = iArr.length;
            Object[] objArr = {Arrays.toString(iArr)};
            if (length == 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "daysSinceLastExposureScores (%s) must have exactly 8 elements", objArr);
            for (int i4 : iArr) {
                if (i4 >= 0 && i4 <= 8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "daysSinceLastExposureScore (%s) must be >= 0 and <= 8", Integer.valueOf(i4));
            }
            this.f22301d = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setDaysSinceLastExposureWeight(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 100) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "daysSinceLastExposureWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i4));
            this.f22302e = i4;
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setDurationAtAttenuationThresholds(@NonNull int... iArr) {
            boolean z3;
            boolean z4;
            boolean z5;
            int length = iArr.length;
            Object[] objArr = {Arrays.toString(iArr)};
            if (length == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationAtAttenuationThresholds (%s) must have exactly 2 elements", objArr);
            for (int i4 : iArr) {
                if (i4 >= 0 && i4 <= 255) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Preconditions.checkArgument(z5, "durationAtAttenuationThreshold (%s) must be >= 0 and <= 255", Integer.valueOf(i4));
            }
            int i5 = iArr[0];
            if (i5 <= iArr[1]) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "durationAtAttenuationThresholds[0] (%s) must be <= than durationAtAttenuationThresholds[1] (%s)", Integer.valueOf(i5), Integer.valueOf(iArr[1]));
            this.f22307j = iArr;
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setDurationScores(@NonNull int... iArr) {
            boolean z3;
            boolean z4;
            int length = iArr.length;
            Object[] objArr = {Arrays.toString(iArr)};
            if (length == 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationScores (%s) must have exactly 8 elements", objArr);
            for (int i4 : iArr) {
                if (i4 >= 0 && i4 <= 8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "durationScore (%s) must be >= 0 and <= 8", Integer.valueOf(i4));
            }
            this.f22303f = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setDurationWeight(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 100) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i4));
            this.f22304g = i4;
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setMinimumRiskScore(int i4) {
            boolean z3;
            if (i4 > 0 && i4 <= 4096) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minimumRiskScore (%s) must be >= 1 and <= 4096", Integer.valueOf(i4));
            this.f22298a = i4;
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setTransmissionRiskScores(@NonNull int... iArr) {
            boolean z3;
            boolean z4;
            int length = iArr.length;
            Object[] objArr = {Arrays.toString(iArr)};
            if (length == 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "transmissionRiskScores (%s) must have exactly 8 elements", objArr);
            for (int i4 : iArr) {
                if (i4 >= 0 && i4 <= 8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "transmissionRiskScore (%s) must be >= 0 and <= 8", Integer.valueOf(i4));
            }
            this.f22305h = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        @NonNull
        public ExposureConfigurationBuilder setTransmissionRiskWeight(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 100) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "transmissionRiskWeight (%s) must be >= 0 and <= 100", Integer.valueOf(i4));
            this.f22306i = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ExposureConfiguration(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int[] iArr, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) int[] iArr2, @SafeParcelable.Param(id = 5) int i6, @SafeParcelable.Param(id = 6) int[] iArr3, @SafeParcelable.Param(id = 7) int i7, @SafeParcelable.Param(id = 8) int[] iArr4, @SafeParcelable.Param(id = 9) int i8, @SafeParcelable.Param(id = 10) int[] iArr5) {
        this.f22288a = i4;
        this.f22289b = iArr;
        this.f22290c = i5;
        this.f22291d = iArr2;
        this.f22292e = i6;
        this.f22293f = iArr3;
        this.f22294g = i7;
        this.f22295h = iArr4;
        this.f22296i = i8;
        this.f22297j = iArr5;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ExposureConfiguration) {
            ExposureConfiguration exposureConfiguration = (ExposureConfiguration) obj;
            if (Objects.equal(Integer.valueOf(this.f22288a), Integer.valueOf(exposureConfiguration.getMinimumRiskScore())) && Arrays.equals(this.f22289b, exposureConfiguration.getAttenuationScores()) && Objects.equal(Integer.valueOf(this.f22290c), Integer.valueOf(exposureConfiguration.getAttenuationWeight())) && Arrays.equals(this.f22291d, exposureConfiguration.getDaysSinceLastExposureScores()) && Objects.equal(Integer.valueOf(this.f22292e), Integer.valueOf(exposureConfiguration.getDaysSinceLastExposureWeight())) && Arrays.equals(this.f22293f, exposureConfiguration.getDurationScores()) && Objects.equal(Integer.valueOf(this.f22294g), Integer.valueOf(exposureConfiguration.getDurationWeight())) && Arrays.equals(this.f22295h, exposureConfiguration.getTransmissionRiskScores()) && Objects.equal(Integer.valueOf(this.f22296i), Integer.valueOf(exposureConfiguration.getTransmissionRiskWeight())) && Arrays.equals(this.f22297j, exposureConfiguration.getDurationAtAttenuationThresholds())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public int[] getAttenuationScores() {
        int[] iArr = this.f22289b;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getAttenuationWeight() {
        return this.f22290c;
    }

    @NonNull
    public int[] getDaysSinceLastExposureScores() {
        int[] iArr = this.f22291d;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDaysSinceLastExposureWeight() {
        return this.f22292e;
    }

    @NonNull
    public int[] getDurationAtAttenuationThresholds() {
        int[] iArr = this.f22297j;
        return Arrays.copyOf(iArr, iArr.length);
    }

    @NonNull
    public int[] getDurationScores() {
        int[] iArr = this.f22293f;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDurationWeight() {
        return this.f22294g;
    }

    public int getMinimumRiskScore() {
        return this.f22288a;
    }

    @NonNull
    public int[] getTransmissionRiskScores() {
        int[] iArr = this.f22295h;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getTransmissionRiskWeight() {
        return this.f22296i;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22288a), this.f22289b, Integer.valueOf(this.f22290c), this.f22291d, Integer.valueOf(this.f22292e), this.f22293f, Integer.valueOf(this.f22294g), this.f22295h, Integer.valueOf(this.f22296i), this.f22297j);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.f22288a), Arrays.toString(this.f22289b), Integer.valueOf(this.f22290c), Arrays.toString(this.f22291d), Integer.valueOf(this.f22292e), Arrays.toString(this.f22293f), Integer.valueOf(this.f22294g), Arrays.toString(this.f22295h), Integer.valueOf(this.f22296i), Arrays.toString(this.f22297j));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getMinimumRiskScore());
        SafeParcelWriter.writeIntArray(parcel, 2, getAttenuationScores(), false);
        SafeParcelWriter.writeInt(parcel, 3, getAttenuationWeight());
        SafeParcelWriter.writeIntArray(parcel, 4, getDaysSinceLastExposureScores(), false);
        SafeParcelWriter.writeInt(parcel, 5, getDaysSinceLastExposureWeight());
        SafeParcelWriter.writeIntArray(parcel, 6, getDurationScores(), false);
        SafeParcelWriter.writeInt(parcel, 7, getDurationWeight());
        SafeParcelWriter.writeIntArray(parcel, 8, getTransmissionRiskScores(), false);
        SafeParcelWriter.writeInt(parcel, 9, getTransmissionRiskWeight());
        SafeParcelWriter.writeIntArray(parcel, 10, getDurationAtAttenuationThresholds(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
