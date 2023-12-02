package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzg extends AccountTransferClient.zzb<DeviceMetaData> {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.auth.zzv f19652e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(AccountTransferClient accountTransferClient, com.google.android.gms.internal.auth.zzv zzvVar) {
        super(null);
        this.f19652e = zzvVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb
    protected final void c(zzz zzzVar) throws RemoteException {
        zzzVar.zza(new zzh(this, this), this.f19652e);
    }
}
