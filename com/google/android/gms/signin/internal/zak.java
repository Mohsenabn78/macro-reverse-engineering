package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "SignInResponseCreator")
/* loaded from: classes4.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22590a;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f22591b;
    @Nullable
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final zav f22592c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @Nullable @SafeParcelable.Param(id = 3) zav zavVar) {
        this.f22590a = i4;
        this.f22591b = connectionResult;
        this.f22592c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22590a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22591b, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f22592c, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.f22591b;
    }

    @Nullable
    public final zav zab() {
        return this.f22592c;
    }
}
