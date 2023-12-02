package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
/* loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getResult", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final boolean f20789a;
    @Nullable
    @SafeParcelable.Field(getter = "getErrorMessage", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f20790b;
    @SafeParcelable.Field(getter = "getStatusValue", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20791c;
    @SafeParcelable.Field(getter = "getFirstPartyStatusValue", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f20792d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) int i5) {
        this.f20789a = z3;
        this.f20790b = str;
        this.f20791c = zzy.a(i4) - 1;
        this.f20792d = zzd.a(i5) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f20789a);
        SafeParcelWriter.writeString(parcel, 2, this.f20790b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f20791c);
        SafeParcelWriter.writeInt(parcel, 4, this.f20792d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.f20790b;
    }

    public final boolean zzb() {
        return this.f20789a;
    }

    public final int zzc() {
        return zzd.a(this.f20792d);
    }

    public final int zzd() {
        return zzy.a(this.f20791c);
    }
}
