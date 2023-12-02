package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "StrategyCreator")
/* loaded from: classes4.dex */
public class Strategy extends AbstractSafeParcelable {
    @NonNull
    @Deprecated
    public static final Strategy BLE_ONLY;
    @NonNull
    public static final Parcelable.Creator<Strategy> CREATOR = new zzf();
    @NonNull
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @NonNull
    @ShowFirstParty
    @Deprecated
    public static final Strategy zza;
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    final int f22395a;
    @SafeParcelable.Field(id = 1)
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    final int f22396b;
    @SafeParcelable.Field(id = 2)

    /* renamed from: c  reason: collision with root package name */
    final int f22397c;
    @SafeParcelable.Field(id = 3)

    /* renamed from: d  reason: collision with root package name */
    final int f22398d;
    @SafeParcelable.Field(id = 4)
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    final boolean f22399e;
    @SafeParcelable.Field(getter = "getDiscoveryMedium", id = 5)

    /* renamed from: f  reason: collision with root package name */
    final int f22400f;
    @SafeParcelable.Field(getter = "getDiscoveryMode", id = 6)

    /* renamed from: g  reason: collision with root package name */
    final int f22401g;
    @SafeParcelable.Field(getter = "getBackgroundScanMode", id = 7)

    /* renamed from: h  reason: collision with root package name */
    private final int f22402h;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f22403a = 3;

        /* renamed from: b  reason: collision with root package name */
        private int f22404b = 300;

        /* renamed from: c  reason: collision with root package name */
        private int f22405c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f22406d = -1;

        @NonNull
        public Strategy build() {
            if (this.f22406d == 2 && this.f22405c == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.f22404b, this.f22405c, false, this.f22406d, this.f22403a, 0);
        }

        @NonNull
        public Builder setDiscoveryMode(int i4) {
            this.f22403a = i4;
            return this;
        }

        @NonNull
        public Builder setDistanceType(int i4) {
            this.f22405c = i4;
            return this;
        }

        @NonNull
        public Builder setTtlSeconds(int i4) {
            boolean z3;
            if (i4 != Integer.MAX_VALUE && (i4 <= 0 || i4 > 86400)) {
                z3 = false;
            } else {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i4), Integer.valueOf((int) Strategy.TTL_SECONDS_MAX));
            this.f22404b = i4;
            return this;
        }

        @NonNull
        @ShowFirstParty
        public final Builder zza(int i4) {
            this.f22406d = 2;
            return this;
        }
    }

    static {
        Builder builder = new Builder();
        builder.zza(2);
        builder.setTtlSeconds(Integer.MAX_VALUE);
        Strategy build = builder.build();
        BLE_ONLY = build;
        zza = build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Strategy(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1000) int r2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) int r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) int r4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) int r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) boolean r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) int r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) int r8, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 7) int r9) {
        /*
            r1 = this;
            r1.<init>()
            r1.f22395a = r2
            r1.f22396b = r3
            r2 = 1
            r0 = 2
            if (r3 != 0) goto Le
        Lb:
            r1.f22401g = r8
            goto L19
        Le:
            if (r3 == r0) goto L17
            r8 = 3
            if (r3 == r8) goto L14
            goto Lb
        L14:
            r1.f22401g = r0
            goto L19
        L17:
            r1.f22401g = r2
        L19:
            r1.f22398d = r5
            r1.f22399e = r6
            if (r6 == 0) goto L27
            r1.f22400f = r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r1.f22397c = r2
            goto L38
        L27:
            r1.f22397c = r4
            r3 = -1
            if (r7 == r3) goto L36
            if (r7 == 0) goto L36
            if (r7 == r2) goto L36
            r2 = 6
            if (r7 == r2) goto L36
            r1.f22400f = r7
            goto L38
        L36:
            r1.f22400f = r3
        L38:
            r1.f22402h = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.Strategy.<init>(int, int, int, int, boolean, int, int, int):void");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        if (this.f22395a == strategy.f22395a && this.f22401g == strategy.f22401g && this.f22397c == strategy.f22397c && this.f22398d == strategy.f22398d && this.f22400f == strategy.f22400f && this.f22402h == strategy.f22402h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f22395a * 31) + this.f22401g) * 31) + this.f22397c) * 31) + this.f22398d) * 31) + this.f22400f) * 31) + this.f22402h;
    }

    @NonNull
    public String toString() {
        String str;
        String obj;
        String obj2;
        int i4 = this.f22397c;
        int i5 = this.f22398d;
        String str2 = "DEFAULT";
        if (i5 == 0) {
            str = "DEFAULT";
        } else if (i5 != 1) {
            str = "UNKNOWN:" + i5;
        } else {
            str = "EARSHOT";
        }
        int i6 = this.f22400f;
        if (i6 == -1) {
            obj = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i6 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i6 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                obj = "UNKNOWN:" + i6;
            } else {
                obj = arrayList.toString();
            }
        }
        int i7 = this.f22401g;
        if (i7 == 3) {
            obj2 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i7 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i7 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                obj2 = "UNKNOWN:" + i7;
            } else {
                obj2 = arrayList2.toString();
            }
        }
        int i8 = this.f22402h;
        if (i8 != 0) {
            if (i8 != 1) {
                str2 = "UNKNOWN: " + i8;
            } else {
                str2 = "ALWAYS_ON";
            }
        }
        return "Strategy{ttlSeconds=" + i4 + ", distanceType=" + str + ", discoveryMedium=" + obj + ", discoveryMode=" + obj2 + ", backgroundScanMode=" + str2 + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22396b);
        SafeParcelWriter.writeInt(parcel, 2, this.f22397c);
        SafeParcelWriter.writeInt(parcel, 3, this.f22398d);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22399e);
        SafeParcelWriter.writeInt(parcel, 5, this.f22400f);
        SafeParcelWriter.writeInt(parcel, 6, this.f22401g);
        SafeParcelWriter.writeInt(parcel, 7, this.f22402h);
        SafeParcelWriter.writeInt(parcel, 1000, this.f22395a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.f22402h;
    }
}
