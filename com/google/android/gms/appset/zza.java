package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
@SafeParcelable.Class(creator = "AppSetIdRequestParamsCreator")
/* loaded from: classes4.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @Nullable
    @SafeParcelable.Field(getter = "getVersion", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f19596a;
    @Nullable
    @SafeParcelable.Field(getter = "getClientAppPackageName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19597b;

    @SafeParcelable.Constructor
    public zza(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2) {
        this.f19596a = str;
        this.f19597b = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f19596a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f19597b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
