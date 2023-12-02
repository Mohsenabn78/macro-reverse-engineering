package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxe {
    final /* synthetic */ zzaxf zza;
    private final byte[] zzb;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaxe(zzaxf zzaxfVar, byte[] bArr, zzaxd zzaxdVar) {
        this.zza = zzaxfVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzaxf zzaxfVar = this.zza;
            if (zzaxfVar.zzb) {
                zzaxfVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e4) {
            zzbzr.zzf("Clearcut log failed", e4);
        }
    }

    public final zzaxe zza(int i4) {
        this.zzc = i4;
        return this;
    }

    public final synchronized void zzc() {
        ExecutorService executorService;
        executorService = this.zza.zzc;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxc
            @Override // java.lang.Runnable
            public final void run() {
                zzaxe.this.zzd();
            }
        });
    }
}
