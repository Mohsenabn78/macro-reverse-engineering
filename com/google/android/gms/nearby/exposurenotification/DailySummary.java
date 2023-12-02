package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "DailySummaryCreator")
/* loaded from: classes4.dex */
public class DailySummary extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<DailySummary> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getDaysSinceEpoch", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22273a;
    @SafeParcelable.Field(getter = "getReportSummaries", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final List f22274b;
    @SafeParcelable.Field(getter = "getSummaryData", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final ExposureSummaryData f22275c;
    @Nullable
    @SafeParcelable.Field(getter = "getDeviceName", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final String f22276d;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Class(creator = "ExposureSummaryDataCreator")
    /* loaded from: classes4.dex */
    public static class ExposureSummaryData extends AbstractSafeParcelable implements ReflectedParcelable {
        @NonNull
        public static final Parcelable.Creator<ExposureSummaryData> CREATOR = new zzl();
        @SafeParcelable.Field(getter = "getMaximumScore", id = 1)

        /* renamed from: a  reason: collision with root package name */
        final double f22277a;
        @SafeParcelable.Field(getter = "getScoreSum", id = 2)

        /* renamed from: b  reason: collision with root package name */
        final double f22278b;
        @SafeParcelable.Field(getter = "getWeightedDurationSum", id = 3)

        /* renamed from: c  reason: collision with root package name */
        final double f22279c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public ExposureSummaryData(@SafeParcelable.Param(id = 1) double d4, @SafeParcelable.Param(id = 2) double d5, @SafeParcelable.Param(id = 3) double d6) {
            this.f22277a = d4;
            this.f22278b = d5;
            this.f22279c = d6;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof ExposureSummaryData) {
                ExposureSummaryData exposureSummaryData = (ExposureSummaryData) obj;
                if (this.f22277a == exposureSummaryData.f22277a && this.f22278b == exposureSummaryData.f22278b && this.f22279c == exposureSummaryData.f22279c) {
                    return true;
                }
            }
            return false;
        }

        public double getMaximumScore() {
            return this.f22277a;
        }

        public double getScoreSum() {
            return this.f22278b;
        }

        public double getWeightedDurationSum() {
            return this.f22279c;
        }

        public int hashCode() {
            return Objects.hashCode(Double.valueOf(this.f22277a), Double.valueOf(this.f22278b), Double.valueOf(this.f22279c));
        }

        @NonNull
        public String toString() {
            return String.format(Locale.US, "ExposureSummaryData<maximumScore: %.3f, scoreSum: %.3f, weightedDurationSum: %.3f>", Double.valueOf(this.f22277a), Double.valueOf(this.f22278b), Double.valueOf(this.f22279c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeDouble(parcel, 1, getMaximumScore());
            SafeParcelWriter.writeDouble(parcel, 2, getScoreSum());
            SafeParcelWriter.writeDouble(parcel, 3, getWeightedDurationSum());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DailySummary(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) List list, @SafeParcelable.Param(id = 3) ExposureSummaryData exposureSummaryData, @Nullable @SafeParcelable.Param(id = 4) String str) {
        this.f22273a = i4;
        this.f22274b = list;
        this.f22275c = exposureSummaryData;
        this.f22276d = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DailySummary) {
            DailySummary dailySummary = (DailySummary) obj;
            if (this.f22273a == dailySummary.f22273a && this.f22274b.equals(dailySummary.f22274b) && Objects.equal(this.f22275c, dailySummary.f22275c) && Objects.equal(this.f22276d, dailySummary.f22276d)) {
                return true;
            }
        }
        return false;
    }

    public int getDaysSinceEpoch() {
        return this.f22273a;
    }

    @NonNull
    public ExposureSummaryData getSummaryData() {
        return this.f22275c;
    }

    @NonNull
    public ExposureSummaryData getSummaryDataForReportType(@ReportType int i4) {
        return (ExposureSummaryData) this.f22274b.get(i4);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22273a), this.f22274b, this.f22275c, this.f22276d);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "DailySummary<daysSinceEpoch: %d, reportSummaries: %s, daySummary: %s, deviceName: %s>", Integer.valueOf(this.f22273a), this.f22274b, this.f22275c, this.f22276d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getDaysSinceEpoch());
        SafeParcelWriter.writeTypedList(parcel, 2, this.f22274b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSummaryData(), i4, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22276d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
