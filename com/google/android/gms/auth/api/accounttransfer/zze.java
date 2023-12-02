package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zze extends AccountTransferClient.zzb<byte[]> {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ zzad f19650e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(AccountTransferClient accountTransferClient, zzad zzadVar) {
        super(null);
        this.f19650e = zzadVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb
    protected final void c(zzz zzzVar) throws RemoteException {
        zzzVar.zza(new zzf(this, this), this.f19650e);
    }
}
