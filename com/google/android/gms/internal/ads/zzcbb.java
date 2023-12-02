package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcbb implements Runnable {
    final /* synthetic */ zzcbe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbb(zzcbe zzcbeVar) {
        this.zza = zzcbeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar;
        zzcbf zzcbfVar2;
        zzcbf zzcbfVar3;
        zzcbe zzcbeVar = this.zza;
        zzcbfVar = zzcbeVar.zzq;
        if (zzcbfVar != null) {
            zzcbfVar2 = zzcbeVar.zzq;
            zzcbfVar2.zzd();
            zzcbfVar3 = this.zza.zzq;
            zzcbfVar3.zzi();
        }
    }
}
