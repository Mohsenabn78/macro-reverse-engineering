package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "DailySummariesConfigCreator")
/* loaded from: classes4.dex */
public class DailySummariesConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "internalGetReportTypeWeights", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final List f22261a;
    @SafeParcelable.Field(getter = "internalGetInfectiousnessWeights", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final List f22262b;
    @SafeParcelable.Field(getter = "getAttenuationBucketThresholdDb", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final List f22263c;
    @SafeParcelable.Field(getter = "getAttenuationBucketWeights", id = 4)

    /* renamed from: d  reason: collision with root package name */
    final List f22264d;
    @SafeParcelable.Field(getter = "getDaysSinceExposureThreshold", id = 5)

    /* renamed from: e  reason: collision with root package name */
    final int f22265e;
    @SafeParcelable.Field(getter = "getMinimumWindowScore", id = 6)

    /* renamed from: f  reason: collision with root package name */
    final double f22266f;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class DailySummariesConfigBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final Double[] f22267a;

        /* renamed from: b  reason: collision with root package name */
        private final Double[] f22268b;

        /* renamed from: c  reason: collision with root package name */
        private List f22269c;

        /* renamed from: d  reason: collision with root package name */
        private List f22270d;

        /* renamed from: e  reason: collision with root package name */
        int f22271e;

        /* renamed from: f  reason: collision with root package name */
        double f22272f;

        public DailySummariesConfigBuilder() {
            Double[] dArr = new Double[6];
            this.f22267a = dArr;
            Double[] dArr2 = new Double[zzj.values().length];
            this.f22268b = dArr2;
            this.f22271e = 0;
            this.f22272f = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            Double valueOf = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            Arrays.fill(dArr, valueOf);
            Arrays.fill(dArr2, valueOf);
        }

        private static void a(List list, int i4, String str) {
            boolean z3;
            Locale locale = Locale.ENGLISH;
            boolean z4 = true;
            String format = String.format(locale, "%s must not be null", str);
            if (list != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, format);
            int size = list.size();
            String format2 = String.format(locale, "%s must must contains %d elements", str, Integer.valueOf(i4));
            if (size != i4) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, format2);
        }

        private static void b(double d4, String str) {
            boolean z3;
            if (d4 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d4 <= 2.5d) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }

        @NonNull
        public DailySummariesConfig build() {
            boolean z3;
            boolean z4 = true;
            if (this.f22269c != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Must set attenuationBucketThresholdDb");
            if (this.f22270d == null) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Must set attenuationBucketWeights");
            return new DailySummariesConfig(Arrays.asList(this.f22267a), Arrays.asList(this.f22268b), this.f22269c, this.f22270d, this.f22271e, this.f22272f);
        }

        @NonNull
        public DailySummariesConfigBuilder setAttenuationBuckets(@NonNull List<Integer> list, @NonNull List<Double> list2) {
            boolean z3;
            boolean z4;
            zza.zza();
            a(list, 3, "attenuationBucketThresholdDb");
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).intValue() >= 0 && list.get(i4).intValue() <= 255) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Element of attenuationBucketThreshold must between 0 ~ 255");
                if (i4 != 0) {
                    int i5 = i4 - 1;
                    if (list.get(i5).intValue() < list.get(i4).intValue()) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Preconditions.checkArgument(z4, String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i4), Integer.valueOf(i5)));
                }
            }
            this.f22269c = new ArrayList(list);
            zza.zza();
            a(list2, 4, "attenuationBucketWeights");
            for (Double d4 : list2) {
                b(d4.doubleValue(), "attenuationBucketWeights");
            }
            this.f22270d = new ArrayList(list2);
            return this;
        }

        @NonNull
        public DailySummariesConfigBuilder setDaysSinceExposureThreshold(int i4) {
            boolean z3;
            if (i4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "daysSinceExposureThreshold must not be negative");
            this.f22271e = i4;
            return this;
        }

        @NonNull
        public DailySummariesConfigBuilder setInfectiousnessWeight(@Infectiousness int i4, @FloatRange(from = 0.0d, to = 2.5d) double d4) {
            zzj zza = zzj.zza(i4);
            boolean z3 = false;
            if (zza != null && zza != zzj.INFECTIOUSNESS_NONE) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "Incorrect value of infectiousness");
            b(d4, "infectiousnessWeights");
            this.f22268b[i4] = Double.valueOf(d4);
            return this;
        }

        @NonNull
        public DailySummariesConfigBuilder setMinimumWindowScore(double d4) {
            boolean z3;
            if (d4 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minimumWindowScore must not be negative");
            this.f22272f = d4;
            return this;
        }

        @NonNull
        public DailySummariesConfigBuilder setReportTypeWeight(@ReportType int i4, @FloatRange(from = 0.0d, to = 2.5d) double d4) {
            boolean z3 = false;
            if (i4 > 0 && i4 < 5) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "Incorrect value of reportType");
            b(d4, "reportTypeWeights");
            this.f22267a[i4] = Double.valueOf(d4);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DailySummariesConfig(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) List list2, @SafeParcelable.Param(id = 3) List list3, @SafeParcelable.Param(id = 4) List list4, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) double d4) {
        this.f22261a = list;
        this.f22262b = list2;
        this.f22263c = list3;
        this.f22264d = list4;
        this.f22265e = i4;
        this.f22266f = d4;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            if (this.f22261a.equals(dailySummariesConfig.f22261a) && this.f22262b.equals(dailySummariesConfig.f22262b) && this.f22263c.equals(dailySummariesConfig.f22263c) && this.f22264d.equals(dailySummariesConfig.f22264d) && this.f22265e == dailySummariesConfig.f22265e && this.f22266f == dailySummariesConfig.f22266f) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public List<Integer> getAttenuationBucketThresholdDb() {
        return new ArrayList(this.f22263c);
    }

    @NonNull
    public List<Double> getAttenuationBucketWeights() {
        return new ArrayList(this.f22264d);
    }

    public int getDaysSinceExposureThreshold() {
        return this.f22265e;
    }

    @NonNull
    public Map<Integer, Double> getInfectiousnessWeights() {
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < this.f22262b.size(); i4++) {
            if (i4 != 0) {
                hashMap.put(Integer.valueOf(i4), (Double) this.f22262b.get(i4));
            }
        }
        return hashMap;
    }

    public double getMinimumWindowScore() {
        return this.f22266f;
    }

    @NonNull
    public Map<Integer, Double> getReportTypeWeights() {
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < this.f22261a.size(); i4++) {
            if (i4 != 0 && i4 != 5) {
                hashMap.put(Integer.valueOf(i4), (Double) this.f22261a.get(i4));
            }
        }
        return hashMap;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22261a, this.f22262b, this.f22263c, this.f22264d, Integer.valueOf(this.f22265e), Double.valueOf(this.f22266f));
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.f22261a, this.f22262b, this.f22263c, this.f22264d, Integer.valueOf(this.f22265e), Double.valueOf(this.f22266f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDoubleList(parcel, 1, new ArrayList(this.f22261a), false);
        SafeParcelWriter.writeDoubleList(parcel, 2, new ArrayList(this.f22262b), false);
        SafeParcelWriter.writeIntegerList(parcel, 3, getAttenuationBucketThresholdDb(), false);
        SafeParcelWriter.writeDoubleList(parcel, 4, getAttenuationBucketWeights(), false);
        SafeParcelWriter.writeInt(parcel, 5, getDaysSinceExposureThreshold());
        SafeParcelWriter.writeDouble(parcel, 6, getMinimumWindowScore());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
