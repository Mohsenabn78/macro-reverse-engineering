package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcba implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcbe zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcba(zzcbe zzcbeVar, int i4, int i5) {
        this.zzc = zzcbeVar;
        this.zza = i4;
        this.zzb = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar;
        zzcbf zzcbfVar2;
        zzcbe zzcbeVar = this.zzc;
        zzcbfVar = zzcbeVar.zzq;
        if (zzcbfVar != null) {
            zzcbfVar2 = zzcbeVar.zzq;
            zzcbfVar2.zzj(this.zza, this.zzb);
        }
    }
}
