package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "RootTelemetryConfigurationCreator")
/* loaded from: classes4.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzai();
    @SafeParcelable.Field(getter = "getVersion", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20488a;
    @SafeParcelable.Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20489b;
    @SafeParcelable.Field(getter = "getMethodTimingTelemetryEnabled", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20490c;
    @SafeParcelable.Field(getter = "getBatchPeriodMillis", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f20491d;
    @SafeParcelable.Field(getter = "getMaxMethodInvocationsInBatch", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f20492e;

    @SafeParcelable.Constructor
    public RootTelemetryConfiguration(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) boolean z4, @SafeParcelable.Param(id = 4) int i5, @SafeParcelable.Param(id = 5) int i6) {
        this.f20488a = i4;
        this.f20489b = z3;
        this.f20490c = z4;
        this.f20491d = i5;
        this.f20492e = i6;
    }

    @KeepForSdk
    public int getBatchPeriodMillis() {
        return this.f20491d;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsInBatch() {
        return this.f20492e;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.f20489b;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.f20490c;
    }

    @KeepForSdk
    public int getVersion() {
        return this.f20488a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersion());
        SafeParcelWriter.writeBoolean(parcel, 2, getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel, 3, getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeInt(parcel, 4, getBatchPeriodMillis());
        SafeParcelWriter.writeInt(parcel, 5, getMaxMethodInvocationsInBatch());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
