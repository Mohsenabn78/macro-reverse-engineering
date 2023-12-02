package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzeee implements zzdew {
    private final Context zza;
    private final zzbzx zzb;
    private final zzfwm zzc;
    private final zzezn zzd;
    private final zzcez zze;
    private final zzfai zzf;
    private final zzbil zzg;
    private final boolean zzh;
    private final zzebl zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeee(Context context, zzbzx zzbzxVar, zzfwm zzfwmVar, zzezn zzeznVar, zzcez zzcezVar, zzfai zzfaiVar, boolean z3, zzbil zzbilVar, zzebl zzeblVar) {
        this.zza = context;
        this.zzb = zzbzxVar;
        this.zzc = zzfwmVar;
        this.zzd = zzeznVar;
        this.zze = zzcezVar;
        this.zzf = zzfaiVar;
        this.zzg = zzbilVar;
        this.zzh = z3;
        this.zzi = zzeblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdew
    public final void zza(boolean z3, Context context, zzcvt zzcvtVar) {
        boolean z4;
        boolean z5;
        float f4;
        zzebl zzeblVar;
        zzddo zzddoVar = (zzddo) zzfwc.zzp(this.zzc);
        this.zze.zzan(true);
        if (this.zzh) {
            z4 = this.zzg.zze(false);
        } else {
            z4 = false;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        boolean zzE = com.google.android.gms.ads.internal.util.zzs.zzE(this.zza);
        boolean z6 = this.zzh;
        if (z6) {
            z5 = this.zzg.zzd();
        } else {
            z5 = false;
        }
        if (z6) {
            f4 = this.zzg.zza();
        } else {
            f4 = 0.0f;
        }
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(z4, zzE, z5, f4, -1, z3, this.zzd.zzP, false);
        if (zzcvtVar != null) {
            zzcvtVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdel zzh = zzddoVar.zzh();
        zzcez zzcezVar = this.zze;
        zzezn zzeznVar = this.zzd;
        int i4 = zzeznVar.zzR;
        zzbzx zzbzxVar = this.zzb;
        String str = zzeznVar.zzC;
        zzezs zzezsVar = zzeznVar.zzt;
        String str2 = zzezsVar.zzb;
        String str3 = zzezsVar.zza;
        String str4 = this.zzf.zzf;
        if (zzeznVar.zzaj) {
            zzeblVar = this.zzi;
        } else {
            zzeblVar = null;
        }
        com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzh, (com.google.android.gms.ads.internal.overlay.zzz) null, zzcezVar, i4, zzbzxVar, str, zzjVar, str2, str3, str4, zzcvtVar, zzeblVar), true);
    }
}
