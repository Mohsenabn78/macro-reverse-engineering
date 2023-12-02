package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: classes4.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    Bundle f20564a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    Feature[] f20565b;
    @SafeParcelable.Field(defaultValue = "0", id = 3)

    /* renamed from: c  reason: collision with root package name */
    int f20566c;
    @Nullable
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    ConnectionTelemetryConfiguration f20567d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) Feature[] featureArr, @SafeParcelable.Param(id = 3) int i4, @Nullable @SafeParcelable.Param(id = 4) ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f20564a = bundle;
        this.f20565b = featureArr;
        this.f20566c = i4;
        this.f20567d = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f20564a, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f20565b, i4, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f20566c);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f20567d, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzj() {
    }
}
