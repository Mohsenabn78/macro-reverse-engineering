package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaqk implements Runnable {
    final /* synthetic */ zzaql zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqk(zzaql zzaqlVar) {
        this.zza = zzaqlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z3;
        zzfjb zzfjbVar;
        Object obj2;
        obj = this.zza.zzo;
        synchronized (obj) {
            z3 = this.zza.zzp;
            if (!z3) {
                this.zza.zzp = true;
                try {
                    zzaql.zzj(this.zza);
                } catch (Exception e4) {
                    zzfjbVar = this.zza.zzh;
                    zzfjbVar.zzc(2023, -1L, e4);
                }
                obj2 = this.zza.zzo;
                synchronized (obj2) {
                    this.zza.zzp = false;
                }
            }
        }
    }
}
