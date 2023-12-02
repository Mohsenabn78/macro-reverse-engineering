package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzaf  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaf extends zzd implements zzac {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    @Override // com.google.android.gms.internal.p001authapi.zzac
    public final void zzc(zzag zzagVar, SavePasswordRequest savePasswordRequest) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzagVar);
        zzf.zzc(zzc, savePasswordRequest);
        zzc(2, zzc);
    }
}
