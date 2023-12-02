package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzah;
import com.google.android.gms.internal.auth.zzz;

/* loaded from: classes4.dex */
final class zzi extends AccountTransferClient.zzc {

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ zzah f19654f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(AccountTransferClient accountTransferClient, zzah zzahVar) {
        super(null);
        this.f19654f = zzahVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb
    protected final void c(zzz zzzVar) throws RemoteException {
        zzzVar.zza(this.f19644e, this.f19654f);
    }
}
