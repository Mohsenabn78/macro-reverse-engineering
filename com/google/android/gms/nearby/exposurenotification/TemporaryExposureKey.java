package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Hex;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "TemporaryExposureKeyCreator")
/* loaded from: classes4.dex */
public final class TemporaryExposureKey extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new zzp();
    public static final int DAYS_SINCE_ONSET_OF_SYMPTOMS_UNKNOWN = Integer.MAX_VALUE;
    @SafeParcelable.Field(getter = "getKeyData", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final byte[] f22352a;
    @SafeParcelable.Field(getter = "getRollingStartIntervalNumber", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22353b;
    @RiskLevel
    @SafeParcelable.Field(getter = "getTransmissionRiskLevel", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22354c;
    @SafeParcelable.Field(getter = "getRollingPeriod", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final int f22355d;
    @ReportType
    @SafeParcelable.Field(getter = "getReportType", id = 5)

    /* renamed from: e  reason: collision with root package name */
    final int f22356e;
    @SafeParcelable.Field(getter = "getDaysSinceOnsetOfSymptoms", id = 6)

    /* renamed from: f  reason: collision with root package name */
    final int f22357f;
    @SafeParcelable.Field(getter = "getVariantOfConcern", id = 7)

    /* renamed from: g  reason: collision with root package name */
    final int f22358g;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class TemporaryExposureKeyBuilder {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f22359a = new byte[0];

        /* renamed from: b  reason: collision with root package name */
        private int f22360b = 0;
        @RiskLevel

        /* renamed from: c  reason: collision with root package name */
        private int f22361c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f22362d = 1;
        @ReportType

        /* renamed from: e  reason: collision with root package name */
        private int f22363e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f22364f = Integer.MAX_VALUE;

        /* renamed from: g  reason: collision with root package name */
        private int f22365g = 0;

        @NonNull
        public TemporaryExposureKey build() {
            return new TemporaryExposureKey(this.f22359a, this.f22360b, this.f22361c, this.f22362d, this.f22363e, this.f22364f, this.f22365g);
        }

        @NonNull
        public TemporaryExposureKeyBuilder setDaysSinceOnsetOfSymptoms(int i4) {
            boolean z3;
            if (i4 >= -14 && i4 <= 14) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "daysSinceOnsetOfSymptoms (%d) must be >= -14 and <= 14", Integer.valueOf(i4));
            this.f22364f = i4;
            return this;
        }

        @NonNull
        public TemporaryExposureKeyBuilder setKeyData(@NonNull byte[] bArr) {
            this.f22359a = Arrays.copyOf(bArr, bArr.length);
            return this;
        }

        @NonNull
        public TemporaryExposureKeyBuilder setReportType(@ReportType int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 5) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, String.format(Locale.getDefault(), "reportType (%d) is invalid", Integer.valueOf(i4)));
            this.f22363e = i4;
            return this;
        }

        @NonNull
        public TemporaryExposureKeyBuilder setRollingPeriod(int i4) {
            boolean z3 = true;
            Object[] objArr = {Integer.valueOf(i4)};
            if (i4 <= 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "rollingPeriod (%s) must be > 0", objArr);
            this.f22362d = i4;
            return this;
        }

        @NonNull
        public TemporaryExposureKeyBuilder setRollingStartIntervalNumber(int i4) {
            boolean z3 = true;
            Object[] objArr = {Integer.valueOf(i4)};
            if (i4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "rollingStartIntervalNumber (%s) must be >= 0", objArr);
            this.f22360b = i4;
            return this;
        }

        @NonNull
        public TemporaryExposureKeyBuilder setTransmissionRiskLevel(@RiskLevel int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i4));
            this.f22361c = i4;
            return this;
        }

        @NonNull
        public TemporaryExposureKeyBuilder setVariantOfConcern(@VariantOfConcern int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, String.format(Locale.getDefault(), "variantOfConcern (%d) is not allowed", Integer.valueOf(i4)));
            this.f22365g = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public TemporaryExposureKey(@SafeParcelable.Param(id = 1) byte[] bArr, @SafeParcelable.Param(id = 2) int i4, @RiskLevel @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) int i6, @SafeParcelable.Param(id = 5) @ReportType int i7, @SafeParcelable.Param(id = 6) int i8, @SafeParcelable.Param(id = 7) int i9) {
        this.f22352a = bArr;
        this.f22353b = i4;
        this.f22354c = i5;
        this.f22355d = i6;
        this.f22356e = i7;
        this.f22357f = i8;
        this.f22358g = i9;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TemporaryExposureKey) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
            if (Arrays.equals(this.f22352a, temporaryExposureKey.getKeyData()) && Objects.equal(Integer.valueOf(this.f22353b), Integer.valueOf(temporaryExposureKey.getRollingStartIntervalNumber())) && Objects.equal(Integer.valueOf(this.f22354c), Integer.valueOf(temporaryExposureKey.getTransmissionRiskLevel())) && Objects.equal(Integer.valueOf(this.f22355d), Integer.valueOf(temporaryExposureKey.getRollingPeriod())) && Objects.equal(Integer.valueOf(this.f22356e), Integer.valueOf(temporaryExposureKey.getReportType())) && this.f22357f == temporaryExposureKey.f22357f && this.f22358g == temporaryExposureKey.f22358g) {
                return true;
            }
        }
        return false;
    }

    public int getDaysSinceOnsetOfSymptoms() {
        return this.f22357f;
    }

    @NonNull
    public byte[] getKeyData() {
        byte[] bArr = this.f22352a;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @ReportType
    public int getReportType() {
        return this.f22356e;
    }

    public int getRollingPeriod() {
        return this.f22355d;
    }

    public int getRollingStartIntervalNumber() {
        return this.f22353b;
    }

    @RiskLevel
    public int getTransmissionRiskLevel() {
        return this.f22354c;
    }

    public int getVariantOfConcern() {
        return this.f22358g;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22352a)), Integer.valueOf(this.f22353b), Integer.valueOf(this.f22354c), Integer.valueOf(this.f22355d), Integer.valueOf(this.f22356e), Integer.valueOf(this.f22357f), Integer.valueOf(this.f22358g));
    }

    @NonNull
    public String toString() {
        Object valueOf;
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        objArr[0] = Hex.bytesToStringLowercase(this.f22352a);
        objArr[1] = new Date(TimeUnit.MINUTES.toMillis(this.f22353b * 10));
        objArr[2] = Integer.valueOf(this.f22354c);
        objArr[3] = Integer.valueOf(this.f22355d);
        objArr[4] = Integer.valueOf(this.f22356e);
        int i4 = this.f22357f;
        if (i4 == Integer.MAX_VALUE) {
            valueOf = EnvironmentCompat.MEDIA_UNKNOWN;
        } else {
            valueOf = Integer.valueOf(i4);
        }
        objArr[5] = valueOf;
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getKeyData(), false);
        SafeParcelWriter.writeInt(parcel, 2, getRollingStartIntervalNumber());
        SafeParcelWriter.writeInt(parcel, 3, getTransmissionRiskLevel());
        SafeParcelWriter.writeInt(parcel, 4, getRollingPeriod());
        SafeParcelWriter.writeInt(parcel, 5, getReportType());
        SafeParcelWriter.writeInt(parcel, 6, getDaysSinceOnsetOfSymptoms());
        SafeParcelWriter.writeInt(parcel, 7, getVariantOfConcern());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
