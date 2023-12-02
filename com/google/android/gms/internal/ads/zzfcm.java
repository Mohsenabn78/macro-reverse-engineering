package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfcm implements zzfvy {
    final /* synthetic */ zzfcp zza;
    final /* synthetic */ zzfcq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfcm(zzfcq zzfcqVar, zzfcp zzfcpVar) {
        this.zzb = zzfcqVar;
        this.zza = zzfcpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayDeque arrayDeque;
        int i4;
        Void r4 = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            arrayDeque = this.zzb.zzd;
            arrayDeque.addFirst(this.zza);
            zzfcq zzfcqVar = this.zzb;
            i4 = zzfcqVar.zzf;
            if (i4 == 1) {
                zzfcqVar.zzh();
            }
        }
    }
}
