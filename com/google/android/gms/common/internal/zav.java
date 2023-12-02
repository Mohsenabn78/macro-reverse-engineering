package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
/* loaded from: classes4.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20537a;
    @Nullable
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    final IBinder f20538b;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final ConnectionResult f20539c;
    @SafeParcelable.Field(getter = "getSaveDefaultAccount", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20540d;
    @SafeParcelable.Field(getter = "isFromCrossClientAuth", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20541e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zav(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) boolean z4) {
        this.f20537a = i4;
        this.f20538b = iBinder;
        this.f20539c = connectionResult;
        this.f20540d = z3;
        this.f20541e = z4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (!this.f20539c.equals(zavVar.f20539c) || !Objects.equal(zab(), zavVar.zab())) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20537a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f20538b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f20539c, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f20540d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f20541e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.f20539c;
    }

    @Nullable
    public final IAccountAccessor zab() {
        IBinder iBinder = this.f20538b;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.asInterface(iBinder);
    }

    public final boolean zac() {
        return this.f20540d;
    }

    public final boolean zad() {
        return this.f20541e;
    }
}
