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
import com.google.android.gms.internal.nearby.zzst;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ExposureWindowCreator")
/* loaded from: classes4.dex */
public final class ExposureWindow extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ExposureWindow> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getDateMillisSinceEpoch", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final long f22331a;
    @SafeParcelable.Field(getter = "getScanInstances", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final List f22332b;
    @ReportType
    @SafeParcelable.Field(getter = "getReportType", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22333c;
    @Infectiousness
    @SafeParcelable.Field(getter = "getInfectiousness", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final int f22334d;
    @CalibrationConfidence
    @SafeParcelable.Field(getter = "getCalibrationConfidence", id = 5)

    /* renamed from: e  reason: collision with root package name */
    final int f22335e;
    @Nullable
    @SafeParcelable.Field(getter = "getDeviceName", id = 6)

    /* renamed from: f  reason: collision with root package name */
    final String f22336f;
    @VariantOfConcern
    @SafeParcelable.Field(getter = "getVariantOfConcern", id = 7)

    /* renamed from: g  reason: collision with root package name */
    final int f22337g;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f22338a = 0;

        /* renamed from: b  reason: collision with root package name */
        private List f22339b = zzst.zzk();
        @ReportType

        /* renamed from: c  reason: collision with root package name */
        private int f22340c = 1;
        @Infectiousness

        /* renamed from: d  reason: collision with root package name */
        private int f22341d = 1;
        @CalibrationConfidence

        /* renamed from: e  reason: collision with root package name */
        private int f22342e = 0;
        @VariantOfConcern

        /* renamed from: f  reason: collision with root package name */
        private int f22343f = 0;

        @NonNull
        public ExposureWindow build() {
            return new ExposureWindow(this.f22338a, this.f22339b, this.f22340c, this.f22341d, this.f22342e, null, this.f22343f);
        }

        @NonNull
        public Builder setCalibrationConfidence(@CalibrationConfidence int i4) {
            zzh zzhVar;
            zzh zzhVar2 = zzh.LOWEST_CONFIDENCE;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            zzhVar = null;
                        } else {
                            zzhVar = zzh.HIGH_CONFIDENCE;
                        }
                    } else {
                        zzhVar = zzh.MEDIUM_CONFIDENCE;
                    }
                } else {
                    zzhVar = zzh.LOW_CONFIDENCE;
                }
            } else {
                zzhVar = zzh.LOWEST_CONFIDENCE;
            }
            Preconditions.checkNotNull(zzhVar, String.format(Locale.getDefault(), "calibrationConfidence (%d) is invalid", Integer.valueOf(i4)));
            this.f22342e = i4;
            return this;
        }

        @NonNull
        public Builder setDateMillisSinceEpoch(long j4) {
            this.f22338a = j4;
            return this;
        }

        @NonNull
        public Builder setInfectiousness(@Infectiousness int i4) {
            Preconditions.checkNotNull(zzj.zza(i4), String.format(Locale.getDefault(), "infectiousness (%d) is invalid", Integer.valueOf(i4)));
            this.f22341d = i4;
            return this;
        }

        @NonNull
        public Builder setReportType(@ReportType int i4) {
            boolean z3;
            if (i4 > 0 && i4 < 5) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "reportType (%d) is not allowed", Integer.valueOf(i4));
            this.f22340c = i4;
            return this;
        }

        @NonNull
        public Builder setScanInstances(@NonNull List<ScanInstance> list) {
            this.f22339b = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @NonNull
        public Builder setVariantOfConcern(@VariantOfConcern int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, String.format(Locale.getDefault(), "variantOfConcern (%d) is not allowed", Integer.valueOf(i4)));
            this.f22343f = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ExposureWindow(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) List list, @SafeParcelable.Param(id = 3) @ReportType int i4, @Infectiousness @SafeParcelable.Param(id = 4) int i5, @SafeParcelable.Param(id = 5) @CalibrationConfidence int i6, @Nullable @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) @VariantOfConcern int i7) {
        this.f22331a = j4;
        this.f22332b = zzst.zzj(list);
        this.f22333c = i4;
        this.f22334d = i5;
        this.f22335e = i6;
        this.f22336f = str;
        this.f22337g = i7;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ExposureWindow.class == obj.getClass()) {
            ExposureWindow exposureWindow = (ExposureWindow) obj;
            if (this.f22333c == exposureWindow.f22333c && this.f22331a == exposureWindow.f22331a && this.f22332b.equals(exposureWindow.f22332b) && this.f22334d == exposureWindow.f22334d && this.f22335e == exposureWindow.f22335e && Objects.equal(this.f22336f, exposureWindow.f22336f) && this.f22337g == exposureWindow.f22337g) {
                return true;
            }
        }
        return false;
    }

    @CalibrationConfidence
    public int getCalibrationConfidence() {
        return this.f22335e;
    }

    public long getDateMillisSinceEpoch() {
        return this.f22331a;
    }

    @Infectiousness
    public int getInfectiousness() {
        return this.f22334d;
    }

    @ReportType
    public int getReportType() {
        return this.f22333c;
    }

    @NonNull
    public List<ScanInstance> getScanInstances() {
        return this.f22332b;
    }

    @VariantOfConcern
    public int getVariantOfConcern() {
        return this.f22337g;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f22331a), this.f22332b, Integer.valueOf(this.f22333c), Integer.valueOf(this.f22334d), Integer.valueOf(this.f22335e), this.f22336f, Integer.valueOf(this.f22337g));
    }

    @NonNull
    public String toString() {
        long j4 = this.f22331a;
        int i4 = this.f22333c;
        String valueOf = String.valueOf(this.f22332b);
        int i5 = this.f22334d;
        int i6 = this.f22335e;
        String str = this.f22336f;
        return "ExposureWindow{dateMillisSinceEpoch=" + j4 + ", reportType=" + i4 + ", scanInstances=" + valueOf + ", infectiousness=" + i5 + ", calibrationConfidence=" + i6 + ", deviceName=" + str + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDateMillisSinceEpoch());
        SafeParcelWriter.writeTypedList(parcel, 2, getScanInstances(), false);
        SafeParcelWriter.writeInt(parcel, 3, getReportType());
        SafeParcelWriter.writeInt(parcel, 4, getInfectiousness());
        SafeParcelWriter.writeInt(parcel, 5, getCalibrationConfidence());
        SafeParcelWriter.writeString(parcel, 6, this.f22336f, false);
        SafeParcelWriter.writeInt(parcel, 7, getVariantOfConcern());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
