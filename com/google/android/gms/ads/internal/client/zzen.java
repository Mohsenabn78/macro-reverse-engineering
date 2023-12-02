package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@SafeParcelable.Class(creator = "LiteSdkVersionsParcelCreator")
/* loaded from: classes4.dex */
public final class zzen extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzen> CREATOR = new zzeo();
    @SafeParcelable.Field(getter = "getAdsDynamiteVersion", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f19183a;
    @SafeParcelable.Field(getter = "getSdkVersionLite", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f19184b;
    @SafeParcelable.Field(getter = "getGranularVersion", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f19185c;

    public zzen() {
        this(ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION, "22.3.0");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19183a);
        SafeParcelWriter.writeInt(parcel, 2, this.f19184b);
        SafeParcelWriter.writeString(parcel, 3, this.f19185c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.f19184b;
    }

    public final String zzb() {
        return this.f19185c;
    }

    @SafeParcelable.Constructor
    public zzen(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) String str) {
        this.f19183a = i4;
        this.f19184b = i5;
        this.f19185c = str;
    }
}
