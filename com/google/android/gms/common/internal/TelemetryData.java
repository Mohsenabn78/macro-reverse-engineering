package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "TelemetryDataCreator")
/* loaded from: classes4.dex */
public class TelemetryData extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();
    @SafeParcelable.Field(getter = "getTelemetryConfigVersion", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20495a;
    @Nullable
    @SafeParcelable.Field(getter = "getMethodInvocations", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private List f20496b;

    @SafeParcelable.Constructor
    public TelemetryData(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) @Nullable List list) {
        this.f20495a = i4;
        this.f20496b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20495a);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f20496b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zaa() {
        return this.f20495a;
    }

    @androidx.annotation.Nullable
    public final List zab() {
        return this.f20496b;
    }

    public final void zac(@NonNull MethodInvocation methodInvocation) {
        if (this.f20496b == null) {
            this.f20496b = new ArrayList();
        }
        this.f20496b.add(methodInvocation);
    }
}
