package com.google.android.gms.internal.ads;

import com.google.firebase.messaging.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdsb extends zzbki {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzffn zzd;
    final /* synthetic */ zzcaj zze;
    final /* synthetic */ zzdsc zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdsb(zzdsc zzdscVar, Object obj, String str, long j4, zzffn zzffnVar, zzcaj zzcajVar) {
        this.zzf = zzdscVar;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j4;
        this.zzd = zzffnVar;
        this.zze = zzcajVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkj
    public final void zze(String str) {
        zzdqj zzdqjVar;
        zzdbx zzdbxVar;
        zzfgb zzfgbVar;
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            zzdqjVar = this.zzf.zzl;
            zzdqjVar.zzb(this.zzb, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            zzdbxVar = this.zzf.zzo;
            zzdbxVar.zzb(this.zzb, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            zzfgbVar = this.zzf.zzp;
            zzffn zzffnVar = this.zzd;
            zzffnVar.zzc(str);
            zzffnVar.zzf(false);
            zzfgbVar.zzb(zzffnVar.zzl());
            this.zze.zzd(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkj
    public final void zzf() {
        zzdqj zzdqjVar;
        zzdbx zzdbxVar;
        zzfgb zzfgbVar;
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            zzdqjVar = this.zzf.zzl;
            zzdqjVar.zzd(this.zzb);
            zzdbxVar = this.zzf.zzo;
            zzdbxVar.zzd(this.zzb);
            zzfgbVar = this.zzf.zzp;
            zzffn zzffnVar = this.zzd;
            zzffnVar.zzf(true);
            zzfgbVar.zzb(zzffnVar.zzl());
            this.zze.zzd(Boolean.TRUE);
        }
    }
}
