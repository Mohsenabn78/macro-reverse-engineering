package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcbc implements Runnable {
    final /* synthetic */ zzcbe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbc(zzcbe zzcbeVar) {
        this.zza = zzcbeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar;
        boolean z3;
        zzcbf zzcbfVar2;
        zzcbf zzcbfVar3;
        zzcbe zzcbeVar = this.zza;
        zzcbfVar = zzcbeVar.zzq;
        if (zzcbfVar != null) {
            z3 = zzcbeVar.zzr;
            if (!z3) {
                zzcbfVar3 = zzcbeVar.zzq;
                zzcbfVar3.zzg();
                this.zza.zzr = true;
            }
            zzcbfVar2 = this.zza.zzq;
            zzcbfVar2.zze();
        }
    }
}
