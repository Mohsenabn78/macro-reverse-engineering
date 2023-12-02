package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfpo implements zzfpt {
    final /* synthetic */ zzfos zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfpo(zzfos zzfosVar) {
        this.zza = zzfosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpt
    public final /* synthetic */ Iterator zza(zzfpu zzfpuVar, CharSequence charSequence) {
        return new zzfpn(this, zzfpuVar, charSequence);
    }
}
