package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class WakeLockEvent extends StatsEvent {
    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20698a;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final long f20699b;
    @SafeParcelable.Field(getter = "getEventType", id = 11)

    /* renamed from: c  reason: collision with root package name */
    private int f20700c;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f20701d;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)

    /* renamed from: e  reason: collision with root package name */
    private final String f20702e;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)

    /* renamed from: f  reason: collision with root package name */
    private final String f20703f;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)

    /* renamed from: g  reason: collision with root package name */
    private final int f20704g;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)

    /* renamed from: h  reason: collision with root package name */
    private final List f20705h;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)

    /* renamed from: i  reason: collision with root package name */
    private final String f20706i;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)

    /* renamed from: j  reason: collision with root package name */
    private final long f20707j;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)

    /* renamed from: k  reason: collision with root package name */
    private int f20708k;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)

    /* renamed from: l  reason: collision with root package name */
    private final String f20709l;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)

    /* renamed from: m  reason: collision with root package name */
    private final float f20710m;
    @SafeParcelable.Field(getter = "getTimeout", id = 16)

    /* renamed from: n  reason: collision with root package name */
    private final long f20711n;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)

    /* renamed from: o  reason: collision with root package name */
    private final boolean f20712o;

    /* renamed from: p  reason: collision with root package name */
    private long f20713p = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) long j4, @SafeParcelable.Param(id = 11) int i5, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i6, @SafeParcelable.Param(id = 6) @Nullable List list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j5, @SafeParcelable.Param(id = 14) int i7, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f4, @SafeParcelable.Param(id = 16) long j6, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z3) {
        this.f20698a = i4;
        this.f20699b = j4;
        this.f20700c = i5;
        this.f20701d = str;
        this.f20702e = str3;
        this.f20703f = str5;
        this.f20704g = i6;
        this.f20705h = list;
        this.f20706i = str2;
        this.f20707j = j5;
        this.f20708k = i7;
        this.f20709l = str4;
        this.f20710m = f4;
        this.f20711n = j6;
        this.f20712o = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20698a);
        SafeParcelWriter.writeLong(parcel, 2, this.f20699b);
        SafeParcelWriter.writeString(parcel, 4, this.f20701d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f20704g);
        SafeParcelWriter.writeStringList(parcel, 6, this.f20705h, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f20707j);
        SafeParcelWriter.writeString(parcel, 10, this.f20702e, false);
        SafeParcelWriter.writeInt(parcel, 11, this.f20700c);
        SafeParcelWriter.writeString(parcel, 12, this.f20706i, false);
        SafeParcelWriter.writeString(parcel, 13, this.f20709l, false);
        SafeParcelWriter.writeInt(parcel, 14, this.f20708k);
        SafeParcelWriter.writeFloat(parcel, 15, this.f20710m);
        SafeParcelWriter.writeLong(parcel, 16, this.f20711n);
        SafeParcelWriter.writeString(parcel, 17, this.f20703f, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.f20712o);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.f20700c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.f20713p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzc() {
        return this.f20699b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String zzd() {
        String join;
        List list = this.f20705h;
        String str = this.f20701d;
        int i4 = this.f20704g;
        String str2 = "";
        if (list == null) {
            join = "";
        } else {
            join = TextUtils.join(",", list);
        }
        int i5 = this.f20708k;
        String str3 = this.f20702e;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.f20709l;
        if (str4 == null) {
            str4 = "";
        }
        float f4 = this.f20710m;
        String str5 = this.f20703f;
        if (str5 != null) {
            str2 = str5;
        }
        boolean z3 = this.f20712o;
        return "\t" + str + "\t" + i4 + "\t" + join + "\t" + i5 + "\t" + str3 + "\t" + str4 + "\t" + f4 + "\t" + str2 + "\t" + z3;
    }
}
