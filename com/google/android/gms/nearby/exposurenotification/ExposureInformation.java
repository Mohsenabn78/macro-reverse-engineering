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
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ExposureInformationCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class ExposureInformation extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ExposureInformation> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getDateMillisSinceEpoch", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final long f22308a;
    @SafeParcelable.Field(getter = "getDurationMinutes", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22309b;
    @SafeParcelable.Field(getter = "getAttenuationValue", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22310c;
    @RiskLevel
    @SafeParcelable.Field(getter = "getTransmissionRiskLevel", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final int f22311d;
    @SafeParcelable.Field(getter = "getTotalRiskScore", id = 5)

    /* renamed from: e  reason: collision with root package name */
    final int f22312e;
    @SafeParcelable.Field(getter = "getAttenuationDurationsInMinutes", id = 6)

    /* renamed from: f  reason: collision with root package name */
    final int[] f22313f;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class ExposureInformationBuilder {

        /* renamed from: a  reason: collision with root package name */
        private long f22314a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f22315b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f22316c = 0;
        @RiskLevel

        /* renamed from: d  reason: collision with root package name */
        private int f22317d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f22318e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int[] f22319f = {0, 0};

        @NonNull
        public ExposureInformation build() {
            return new ExposureInformation(this.f22314a, this.f22315b, this.f22316c, this.f22317d, this.f22318e, this.f22319f);
        }

        @NonNull
        public ExposureInformationBuilder setAttenuationDurations(@NonNull int[] iArr) {
            boolean z3;
            for (int i4 : iArr) {
                if (i4 >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i4));
            }
            this.f22319f = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        @NonNull
        public ExposureInformationBuilder setAttenuationValue(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 255) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "attenuationValue (%s) must be >= 0 and <= 255", Integer.valueOf(i4));
            this.f22316c = i4;
            return this;
        }

        @NonNull
        public ExposureInformationBuilder setDateMillisSinceEpoch(long j4) {
            boolean z3 = true;
            Object[] objArr = {Long.valueOf(j4)};
            if (j4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "dateMillisSinceEpoch (%s) must be >= 0", objArr);
            this.f22314a = j4;
            return this;
        }

        @NonNull
        public ExposureInformationBuilder setDurationMinutes(int i4) {
            boolean z3;
            boolean z4 = true;
            Integer valueOf = Integer.valueOf(i4);
            Object[] objArr = {valueOf};
            if (i4 % 5 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationMinutes (%s) must be an increment of 5", objArr);
            Object[] objArr2 = {valueOf};
            if (i4 > 30) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "durationMinutes (%s) must be <= 30", objArr2);
            this.f22315b = i4;
            return this;
        }

        @NonNull
        public ExposureInformationBuilder setTotalRiskScore(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 4096) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "totalRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i4));
            this.f22318e = i4;
            return this;
        }

        @NonNull
        public ExposureInformationBuilder setTransmissionRiskLevel(@RiskLevel int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i4));
            this.f22317d = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ExposureInformation(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) int i6, @SafeParcelable.Param(id = 5) int i7, @SafeParcelable.Param(id = 6) int[] iArr) {
        this.f22308a = j4;
        this.f22309b = i4;
        this.f22310c = i5;
        this.f22311d = i6;
        this.f22312e = i7;
        this.f22313f = iArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ExposureInformation) {
            ExposureInformation exposureInformation = (ExposureInformation) obj;
            if (Objects.equal(Long.valueOf(this.f22308a), Long.valueOf(exposureInformation.getDateMillisSinceEpoch())) && Objects.equal(Integer.valueOf(this.f22309b), Integer.valueOf(exposureInformation.getDurationMinutes())) && Objects.equal(Integer.valueOf(this.f22310c), Integer.valueOf(exposureInformation.getAttenuationValue())) && Objects.equal(Integer.valueOf(this.f22311d), Integer.valueOf(exposureInformation.getTransmissionRiskLevel())) && Objects.equal(Integer.valueOf(this.f22312e), Integer.valueOf(exposureInformation.getTotalRiskScore())) && Arrays.equals(this.f22313f, exposureInformation.getAttenuationDurationsInMinutes())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.f22313f;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getAttenuationValue() {
        return this.f22310c;
    }

    public long getDateMillisSinceEpoch() {
        return this.f22308a;
    }

    public int getDurationMinutes() {
        return this.f22309b;
    }

    public int getTotalRiskScore() {
        return this.f22312e;
    }

    @RiskLevel
    public int getTransmissionRiskLevel() {
        return this.f22311d;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f22308a), Integer.valueOf(this.f22309b), Integer.valueOf(this.f22310c), Integer.valueOf(this.f22311d), Integer.valueOf(this.f22312e), this.f22313f);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "ExposureInformation<date: %s, dateMillisSinceEpoch: %d, durationMinutes: %d, attenuationValue: %d, transmissionRiskLevel: %d, totalRiskScore: %d, attenuationDurations: %s>", new Date(this.f22308a), Long.valueOf(this.f22308a), Integer.valueOf(this.f22309b), Integer.valueOf(this.f22310c), Integer.valueOf(this.f22311d), Integer.valueOf(this.f22312e), Arrays.toString(this.f22313f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDateMillisSinceEpoch());
        SafeParcelWriter.writeInt(parcel, 2, getDurationMinutes());
        SafeParcelWriter.writeInt(parcel, 3, getAttenuationValue());
        SafeParcelWriter.writeInt(parcel, 4, getTransmissionRiskLevel());
        SafeParcelWriter.writeInt(parcel, 5, getTotalRiskScore());
        SafeParcelWriter.writeIntArray(parcel, 6, getAttenuationDurationsInMinutes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
