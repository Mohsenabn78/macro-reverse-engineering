package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzk extends com.google.android.gms.internal.auth.zzs {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AccountTransferClient.zzc f19656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(AccountTransferClient.zzc zzcVar) {
        this.f19656a = zzcVar;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void onFailure(Status status) {
        this.f19656a.b(status);
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zzd() {
        this.f19656a.setResult(null);
    }
}
