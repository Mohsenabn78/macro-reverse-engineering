package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdzf implements zzdbz {
    private final String zzc;
    private final zzfev zzd;
    @GuardedBy("this")
    private boolean zza = false;
    @GuardedBy("this")
    private boolean zzb = false;
    private final com.google.android.gms.ads.internal.util.zzg zze = com.google.android.gms.ads.internal.zzt.zzo().zzh();

    public zzdzf(String str, zzfev zzfevVar) {
        this.zzc = str;
        this.zzd = zzfevVar;
    }

    private final zzfeu zzg(String str) {
        String str2;
        if (this.zze.zzP()) {
            str2 = "";
        } else {
            str2 = this.zzc;
        }
        zzfeu zzb = zzfeu.zzb(str);
        zzb.zza("tms", Long.toString(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), 10));
        zzb.zza("tid", str2);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdbz
    public final void zza(String str) {
        zzfev zzfevVar = this.zzd;
        zzfeu zzg = zzg("aaia");
        zzg.zza("aair", "MalformedJson");
        zzfevVar.zzb(zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdbz
    public final void zzb(String str, String str2) {
        zzfev zzfevVar = this.zzd;
        zzfeu zzg = zzg("adapter_init_finished");
        zzg.zza("ancn", str);
        zzg.zza("rqe", str2);
        zzfevVar.zzb(zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdbz
    public final void zzc(String str) {
        zzfev zzfevVar = this.zzd;
        zzfeu zzg = zzg("adapter_init_started");
        zzg.zza("ancn", str);
        zzfevVar.zzb(zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdbz
    public final void zzd(String str) {
        zzfev zzfevVar = this.zzd;
        zzfeu zzg = zzg("adapter_init_finished");
        zzg.zza("ancn", str);
        zzfevVar.zzb(zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzdbz
    public final synchronized void zze() {
        if (!this.zzb) {
            this.zzd.zzb(zzg("init_finished"));
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbz
    public final synchronized void zzf() {
        if (!this.zza) {
            this.zzd.zzb(zzg("init_started"));
            this.zza = true;
        }
    }
}
