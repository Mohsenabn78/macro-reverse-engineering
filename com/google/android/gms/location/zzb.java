package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@ShowFirstParty
@SafeParcelable.Class(creator = "ActivityRecognitionRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getIntervalMillis", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final long f21188a;
    @SafeParcelable.Field(getter = "getTriggerUpdate", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21189b;
    @Nullable
    @SafeParcelable.Field(getter = "getWorkSource", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final WorkSource f21190c;
    @Nullable
    @SafeParcelable.Field(getter = "getTag", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f21191d;
    @Nullable
    @SafeParcelable.Field(getter = "getNondefaultActivities", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int[] f21192e;
    @SafeParcelable.Field(getter = "getRequestSensorData", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21193f;
    @Nullable
    @SafeParcelable.Field(getter = "getAccountName", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final String f21194g;
    @SafeParcelable.Field(defaultValueUnchecked = "ActivityRecognitionRequest.DEFAULT_MAX_REPORT_LATENCY_MILLIS", getter = "getMaxReportLatencyMillis", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final long f21195h;
    @Nullable
    @SafeParcelable.Field(getter = "getContextAttributionTag", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private String f21196i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) boolean z3, @Nullable @SafeParcelable.Param(id = 3) WorkSource workSource, @Nullable @SafeParcelable.Param(id = 4) String str, @Nullable @SafeParcelable.Param(id = 5) int[] iArr, @SafeParcelable.Param(id = 6) boolean z4, @Nullable @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) long j5, @Nullable @SafeParcelable.Param(id = 9) String str3) {
        this.f21188a = j4;
        this.f21189b = z3;
        this.f21190c = workSource;
        this.f21191d = str;
        this.f21192e = iArr;
        this.f21193f = z4;
        this.f21194g = str2;
        this.f21195h = j5;
        this.f21196i = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f21188a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f21189b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f21190c, i4, false);
        SafeParcelWriter.writeString(parcel, 4, this.f21191d, false);
        SafeParcelWriter.writeIntArray(parcel, 5, this.f21192e, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f21193f);
        SafeParcelWriter.writeString(parcel, 7, this.f21194g, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f21195h);
        SafeParcelWriter.writeString(parcel, 9, this.f21196i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzb zza(@Nullable String str) {
        this.f21196i = str;
        return this;
    }
}
