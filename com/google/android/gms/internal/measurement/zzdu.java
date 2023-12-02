package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzdu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzef zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzef zzefVar, boolean z3) {
        this.zzk = zzefVar;
        this.zzh = zzefVar.zza.currentTimeMillis();
        this.zzi = zzefVar.zza.elapsedRealtime();
        this.zzj = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        z3 = this.zzk.zzh;
        if (z3) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e4) {
            this.zzk.zzT(e4, false, this.zzj);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
