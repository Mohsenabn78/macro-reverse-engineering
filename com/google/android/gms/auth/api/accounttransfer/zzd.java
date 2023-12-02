package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzaf;
import com.google.android.gms.internal.auth.zzz;

/* loaded from: classes4.dex */
final class zzd extends AccountTransferClient.zzc {

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ zzaf f19649f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzd(AccountTransferClient accountTransferClient, zzaf zzafVar) {
        super(null);
        this.f19649f = zzafVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb
    protected final void c(zzz zzzVar) throws RemoteException {
        zzzVar.zza(this.f19644e, this.f19649f);
    }
}
