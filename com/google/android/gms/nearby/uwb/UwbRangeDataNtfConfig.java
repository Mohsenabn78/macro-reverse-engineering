package com.google.android.gms.nearby.uwb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.nearby.zzsj;
import com.google.android.gms.internal.nearby.zzst;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class UwbRangeDataNtfConfig {
    public static final zzst zza = zzst.zzo(0, 1, 2, 3);
    @RangeDataNtfConfig

    /* renamed from: a  reason: collision with root package name */
    private final int f22549a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22550b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22551c;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f22552a = 1;

        /* renamed from: b  reason: collision with root package name */
        private int f22553b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f22554c = 20000;

        @NonNull
        public UwbRangeDataNtfConfig build() {
            return new UwbRangeDataNtfConfig(this.f22552a, this.f22553b, this.f22554c, null);
        }

        @NonNull
        public Builder setNtfProximityFar(int i4) {
            this.f22554c = i4;
            return this;
        }

        @NonNull
        public Builder setNtfProximityNear(int i4) {
            this.f22553b = i4;
            return this;
        }

        @NonNull
        public Builder setRangeDataConfigType(int i4) {
            this.f22552a = i4;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public @interface RangeDataNtfConfig {
        public static final int RANGE_DATA_NTF_DISABLE = 0;
        public static final int RANGE_DATA_NTF_ENABLE = 1;
        public static final int RANGE_DATA_NTF_ENABLE_PROXIMITY_EDGE_TRIG = 3;
        public static final int RANGE_DATA_NTF_ENABLE_PROXIMITY_LEVEL_TRIG = 2;
    }

    /* synthetic */ UwbRangeDataNtfConfig(int i4, int i5, int i6, zzf zzfVar) {
        boolean z3;
        zzsj.zze(zza.contains(Integer.valueOf(i4)), "Invalid/unsupported range data notification config");
        if (i5 <= i6) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzsj.zze(z3, "Proximity near cannot be greater than proximity far");
        this.f22549a = i4;
        this.f22550b = i5;
        this.f22551c = i6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbRangeDataNtfConfig)) {
            return false;
        }
        UwbRangeDataNtfConfig uwbRangeDataNtfConfig = (UwbRangeDataNtfConfig) obj;
        if (this.f22549a == uwbRangeDataNtfConfig.f22549a && this.f22550b == uwbRangeDataNtfConfig.f22550b && this.f22551c == uwbRangeDataNtfConfig.f22551c) {
            return true;
        }
        return false;
    }

    public int getNtfProximityFar() {
        return this.f22551c;
    }

    public int getNtfProximityNear() {
        return this.f22550b;
    }

    public int getRangeDataNtfConfigType() {
        return this.f22549a;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22549a), Integer.valueOf(this.f22550b), Integer.valueOf(this.f22551c));
    }

    @NonNull
    public final String toString() {
        int i4 = this.f22549a;
        int i5 = this.f22550b;
        int i6 = this.f22551c;
        return "UwbRangeDataNtfConfig{mRangeDataNtfConfigType=" + i4 + ", mNtfProximityNear=" + i5 + ", mNtfProximityFar=" + i6 + "}";
    }
}
