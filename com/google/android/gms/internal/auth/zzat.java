package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* loaded from: classes4.dex */
final class zzat extends zzaj {
    private final /* synthetic */ zzas zzcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zzas zzasVar) {
        this.zzcf = zzasVar;
    }

    @Override // com.google.android.gms.internal.auth.zzaj, com.google.android.gms.internal.auth.zzal
    public final void zza(ProxyResponse proxyResponse) {
        this.zzcf.setResult((zzas) new zzaw(proxyResponse));
    }
}
