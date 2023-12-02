package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzl  reason: invalid package */
/* loaded from: classes4.dex */
final class zzl extends zzh {
    private final /* synthetic */ zzi zzap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(zzi zziVar) {
        this.zzap = zziVar;
    }

    @Override // com.google.android.gms.internal.p001authapi.zzh, com.google.android.gms.internal.p001authapi.zzv
    public final void zzc(Status status, Credential credential) {
        this.zzap.setResult((zzi) new zzg(status, credential));
    }

    @Override // com.google.android.gms.internal.p001authapi.zzh, com.google.android.gms.internal.p001authapi.zzv
    public final void zzd(Status status) {
        this.zzap.setResult((zzi) zzg.zzc(status));
    }
}
