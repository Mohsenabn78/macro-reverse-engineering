package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzax extends zzaw {
    final /* synthetic */ zzay zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzay zzayVar) {
        this.zza = zzayVar;
    }

    @Override // com.google.android.gms.internal.icing.zzaw, com.google.android.gms.internal.icing.zzat
    public final void zzc(Status status) {
        boolean unused;
        unused = this.zza.zzc;
        this.zza.setResult((zzay) status);
    }
}
