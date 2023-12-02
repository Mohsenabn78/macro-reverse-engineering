package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfcq {
    private final zzfbu zza;
    private final zzfco zzb;
    private final zzfbq zzc;
    private zzfcw zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfcq(zzfbu zzfbuVar, zzfbq zzfbqVar, zzfco zzfcoVar) {
        this.zza = zzfbuVar;
        this.zzc = zzfbqVar;
        this.zzb = zzfcoVar;
        zzfbqVar.zzb(new zzfcl(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgc)).booleanValue() && !com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzh()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (!this.zzd.isEmpty()) {
                zzfcp zzfcpVar = (zzfcp) this.zzd.pollFirst();
                if (zzfcpVar == null || (zzfcpVar.zza() != null && this.zza.zze(zzfcpVar.zza()))) {
                    zzfcw zzfcwVar = new zzfcw(this.zza, this.zzb, zzfcpVar);
                    this.zze = zzfcwVar;
                    zzfcwVar.zzd(new zzfcm(this, zzfcpVar));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        if (this.zze == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final synchronized zzfwm zza(zzfcp zzfcpVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzfcpVar);
    }

    public final synchronized void zze(zzfcp zzfcpVar) {
        this.zzd.add(zzfcpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
