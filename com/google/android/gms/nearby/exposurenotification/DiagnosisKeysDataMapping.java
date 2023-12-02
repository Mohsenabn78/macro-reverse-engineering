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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "DiagnosisKeysDataMappingCreator")
/* loaded from: classes4.dex */
public class DiagnosisKeysDataMapping extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<DiagnosisKeysDataMapping> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "internalGetDaysSinceOnsetToInfectiousness", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final List f22282a;
    @ReportType
    @SafeParcelable.Field(getter = "getReportTypeWhenMissing", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22283b;
    @Infectiousness
    @SafeParcelable.Field(getter = "getInfectiousnessWhenDaysSinceOnsetMissing", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22284c;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class DiagnosisKeysDataMappingBuilder {

        /* renamed from: a  reason: collision with root package name */
        private List f22285a;
        @ReportType

        /* renamed from: b  reason: collision with root package name */
        private int f22286b = 0;
        @Infectiousness

        /* renamed from: c  reason: collision with root package name */
        private Integer f22287c;

        @NonNull
        public DiagnosisKeysDataMapping build() {
            boolean z3;
            boolean z4;
            boolean z5 = true;
            if (this.f22285a != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Must set daysSinceOnsetToInfectiousness");
            if (this.f22286b != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Must set reportTypeWhenMissing");
            if (this.f22287c == null) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "Must set infectiousnessWhenDaysSinceOnsetMissing");
            return new DiagnosisKeysDataMapping(this.f22285a, this.f22286b, this.f22287c.intValue());
        }

        @NonNull
        public DiagnosisKeysDataMappingBuilder setDaysSinceOnsetToInfectiousness(@NonNull Map<Integer, Integer> map) {
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            if (map != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "daysSinceOnsetToInfectiousness must not be null.");
            Object[] objArr = {29};
            if (map.size() <= 29) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", objArr);
            Integer[] numArr = new Integer[29];
            Arrays.fill((Object[]) numArr, (Object) 0);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int intValue = entry.getKey().intValue();
                int intValue2 = entry.getValue().intValue();
                if (Math.abs(intValue) <= 14) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Preconditions.checkArgument(z5, "Invalid day since onset %d", Integer.valueOf(intValue));
                if (zzj.zza(intValue2) != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Integer valueOf = Integer.valueOf(intValue2);
                Preconditions.checkArgument(z6, "Invalid value of Infectiousness %d", valueOf);
                numArr[intValue + 14] = valueOf;
            }
            this.f22285a = Arrays.asList(numArr);
            return this;
        }

        @NonNull
        public DiagnosisKeysDataMappingBuilder setInfectiousnessWhenDaysSinceOnsetMissing(@Infectiousness int i4) {
            zzj zza = zzj.zza(i4);
            boolean z3 = true;
            Integer valueOf = Integer.valueOf(i4);
            Object[] objArr = {valueOf};
            if (zza == null) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Invalid value of Infectiousness %d", objArr);
            this.f22287c = valueOf;
            return this;
        }

        @NonNull
        public DiagnosisKeysDataMappingBuilder setReportTypeWhenMissing(@ReportType int i4) {
            boolean z3;
            boolean z4;
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Invalid reportTypeWhenMissing value");
            if (i4 >= 0 && i4 <= 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Invalid value of ReportType %d", Integer.valueOf(i4));
            this.f22286b = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DiagnosisKeysDataMapping(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) @ReportType int i4, @Infectiousness @SafeParcelable.Param(id = 3) int i5) {
        this.f22282a = list;
        this.f22283b = i4;
        this.f22284c = i5;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DiagnosisKeysDataMapping) {
            DiagnosisKeysDataMapping diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) obj;
            if (this.f22282a.equals(diagnosisKeysDataMapping.f22282a) && this.f22283b == diagnosisKeysDataMapping.f22283b && this.f22284c == diagnosisKeysDataMapping.f22284c) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public Map<Integer, Integer> getDaysSinceOnsetToInfectiousness() {
        HashMap hashMap = new HashMap((int) Math.ceil(38.666666666666664d));
        for (int i4 = 0; i4 < this.f22282a.size(); i4++) {
            hashMap.put(Integer.valueOf(i4 - 14), (Integer) this.f22282a.get(i4));
        }
        return hashMap;
    }

    @Infectiousness
    public int getInfectiousnessWhenDaysSinceOnsetMissing() {
        return this.f22284c;
    }

    @ReportType
    public int getReportTypeWhenMissing() {
        return this.f22283b;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22282a, Integer.valueOf(this.f22283b), Integer.valueOf(this.f22284c));
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "DiagnosisKeysDataMapping<daysSinceOnsetToInfectiousness: %s, reportTypeWhenMissing: %d, infectiousnessWhenDaysSinceOnsetMissing: %d>", getDaysSinceOnsetToInfectiousness(), Integer.valueOf(this.f22283b), Integer.valueOf(this.f22284c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, new ArrayList(this.f22282a), false);
        SafeParcelWriter.writeInt(parcel, 2, getReportTypeWhenMissing());
        SafeParcelWriter.writeInt(parcel, 3, getInfectiousnessWhenDaysSinceOnsetMissing());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
