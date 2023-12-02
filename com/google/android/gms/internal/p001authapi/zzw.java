package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzw extends zzd implements zzx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzvVar, CredentialRequest credentialRequest) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzvVar);
        zzf.zzc(zzc, credentialRequest);
        zzc(1, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzvVar, zzz zzzVar) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzvVar);
        zzf.zzc(zzc, zzzVar);
        zzc(2, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzvVar, zzt zztVar) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzvVar);
        zzf.zzc(zzc, zztVar);
        zzc(3, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzvVar) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzvVar);
        zzc(4, zzc);
    }
}
