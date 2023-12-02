package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzm extends zzn {
    private final /* synthetic */ zzl zzag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzl zzlVar) {
        this.zzag = zzlVar;
    }

    @Override // com.google.android.gms.internal.auth.zzn, com.google.android.gms.auth.account.zza
    public final void zza(boolean z3) {
        Status status;
        zzl zzlVar = this.zzag;
        if (!z3) {
            status = zzh.zzad;
        } else {
            status = Status.RESULT_SUCCESS;
        }
        zzlVar.setResult((zzl) new zzq(status));
    }
}
