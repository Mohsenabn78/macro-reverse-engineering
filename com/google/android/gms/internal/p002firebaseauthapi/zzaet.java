package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "TotpInfoCreator")
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaet  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaet extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaet> CREATOR = new zzaeu();

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
    }
}
