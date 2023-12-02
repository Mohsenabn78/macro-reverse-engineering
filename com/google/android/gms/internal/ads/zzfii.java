package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfii implements Runnable {
    final /* synthetic */ zzfin zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfii(zzfin zzfinVar) {
        this.zza = zzfinVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfih zzfihVar;
        zzfihVar = this.zza.zzl;
        zzfihVar.zzb();
    }
}
