package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzz;

/* loaded from: classes4.dex */
final class zzj extends AccountTransferClient.zzc {

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ zzab f19655f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzj(AccountTransferClient accountTransferClient, zzab zzabVar) {
        super(null);
        this.f19655f = zzabVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb
    protected final void c(zzz zzzVar) throws RemoteException {
        zzzVar.zza(this.f19644e, this.f19655f);
    }
}
