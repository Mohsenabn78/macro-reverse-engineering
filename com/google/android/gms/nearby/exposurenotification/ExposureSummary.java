package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ExposureSummaryCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class ExposureSummary extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<ExposureSummary> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getDaysSinceLastExposure", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22321a;
    @SafeParcelable.Field(getter = "getMatchedKeyCount", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22322b;
    @SafeParcelable.Field(getter = "getMaximumRiskScore", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22323c;
    @SafeParcelable.Field(getter = "getAttenuationDurationsInMinutes", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final int[] f22324d;
    @SafeParcelable.Field(getter = "getSummationRiskScore", id = 5)

    /* renamed from: e  reason: collision with root package name */
    final int f22325e;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class ExposureSummaryBuilder {

        /* renamed from: a  reason: collision with root package name */
        private int f22326a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f22327b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f22328c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int[] f22329d = {0, 0, 0};

        /* renamed from: e  reason: collision with root package name */
        private int f22330e = 0;

        @NonNull
        public ExposureSummary build() {
            return new ExposureSummary(this.f22326a, this.f22327b, this.f22328c, this.f22329d, this.f22330e);
        }

        @NonNull
        public ExposureSummaryBuilder setAttenuationDurations(@NonNull int[] iArr) {
            boolean z3;
            boolean z4;
            if (iArr.length == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            for (int i4 : iArr) {
                if (i4 >= 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i4));
            }
            this.f22329d = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        @NonNull
        public ExposureSummaryBuilder setDaysSinceLastExposure(int i4) {
            boolean z3 = true;
            Object[] objArr = {Integer.valueOf(i4)};
            if (i4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "daysSinceLastExposure (%s) must be >= 0", objArr);
            this.f22326a = i4;
            return this;
        }

        @NonNull
        public ExposureSummaryBuilder setMatchedKeyCount(int i4) {
            boolean z3 = true;
            Object[] objArr = {Integer.valueOf(i4)};
            if (i4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "matchedKeyCount (%s) must be >= 0", objArr);
            this.f22327b = i4;
            return this;
        }

        @NonNull
        public ExposureSummaryBuilder setMaximumRiskScore(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 4096) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maximumRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i4));
            this.f22328c = i4;
            return this;
        }

        @NonNull
        public ExposureSummaryBuilder setSummationRiskScore(int i4) {
            boolean z3 = true;
            Object[] objArr = {Integer.valueOf(i4)};
            if (i4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "summationRiskScore (%s) must be >= 0", objArr);
            this.f22330e = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ExposureSummary(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int[] iArr, @SafeParcelable.Param(id = 5) int i7) {
        this.f22321a = i4;
        this.f22322b = i5;
        this.f22323c = i6;
        this.f22324d = iArr;
        this.f22325e = i7;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ExposureSummary) {
            ExposureSummary exposureSummary = (ExposureSummary) obj;
            if (Objects.equal(Integer.valueOf(this.f22321a), Integer.valueOf(exposureSummary.getDaysSinceLastExposure())) && Objects.equal(Integer.valueOf(this.f22322b), Integer.valueOf(exposureSummary.getMatchedKeyCount())) && Objects.equal(Integer.valueOf(this.f22323c), Integer.valueOf(exposureSummary.getMaximumRiskScore())) && Arrays.equals(this.f22324d, exposureSummary.getAttenuationDurationsInMinutes()) && Objects.equal(Integer.valueOf(this.f22325e), Integer.valueOf(exposureSummary.getSummationRiskScore()))) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.f22324d;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDaysSinceLastExposure() {
        return this.f22321a;
    }

    public int getMatchedKeyCount() {
        return this.f22322b;
    }

    public int getMaximumRiskScore() {
        return this.f22323c;
    }

    public int getSummationRiskScore() {
        return this.f22325e;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22321a), Integer.valueOf(this.f22322b), Integer.valueOf(this.f22323c), this.f22324d, Integer.valueOf(this.f22325e));
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "ExposureSummary<daysSinceLastExposure: %d, matchedKeyCount: %d, maximumRiskScore: %d, attenuationDurations: %s, summationRiskScore: %d>", Integer.valueOf(this.f22321a), Integer.valueOf(this.f22322b), Integer.valueOf(this.f22323c), Arrays.toString(this.f22324d), Integer.valueOf(this.f22325e));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getDaysSinceLastExposure());
        SafeParcelWriter.writeInt(parcel, 2, getMatchedKeyCount());
        SafeParcelWriter.writeInt(parcel, 3, getMaximumRiskScore());
        SafeParcelWriter.writeIntArray(parcel, 4, getAttenuationDurationsInMinutes(), false);
        SafeParcelWriter.writeInt(parcel, 5, getSummationRiskScore());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
