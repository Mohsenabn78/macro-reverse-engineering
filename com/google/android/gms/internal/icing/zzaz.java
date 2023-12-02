package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzaz extends zzaw {
    final /* synthetic */ zzba zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaz(zzba zzbaVar) {
        this.zza = zzbaVar;
    }

    @Override // com.google.android.gms.internal.icing.zzaw, com.google.android.gms.internal.icing.zzat
    public final void zzb(Status status, GoogleNowAuthState googleNowAuthState) {
        boolean unused;
        unused = this.zza.zzc;
        this.zza.setResult((zzba) new zzbb(status, googleNowAuthState));
    }
}
