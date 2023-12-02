package com.google.android.gms.internal.p001authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzaj  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzaj extends zzc implements zzag {
    public zzaj() {
        super("com.google.android.gms.auth.api.identity.internal.ISavePasswordCallback");
    }

    @Override // com.google.android.gms.internal.p001authapi.zzc
    protected final boolean zzc(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            zzc((Status) zzf.zzc(parcel, Status.CREATOR), (SavePasswordResult) zzf.zzc(parcel, SavePasswordResult.CREATOR));
            return true;
        }
        return false;
    }
}
