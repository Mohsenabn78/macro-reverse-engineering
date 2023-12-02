package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzk extends zzn {
    private final /* synthetic */ zzj zzaf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzj zzjVar) {
        this.zzaf = zzjVar;
    }

    @Override // com.google.android.gms.internal.auth.zzn, com.google.android.gms.auth.account.zza
    public final void zzc(Account account) {
        Status status;
        zzj zzjVar = this.zzaf;
        if (account == null) {
            status = zzh.zzad;
        } else {
            status = Status.RESULT_SUCCESS;
        }
        zzjVar.setResult((zzj) new zzo(status, account));
    }
}
