package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeef implements zzecc {
    private final Context zza;
    private final zzdni zzb;
    private final zzdeo zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzbzx zzf;
    private final zzbil zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzit)).booleanValue();
    private final zzebl zzi;

    public zzeef(Context context, zzbzx zzbzxVar, zzfai zzfaiVar, Executor executor, zzdeo zzdeoVar, zzdni zzdniVar, zzbil zzbilVar, zzebl zzeblVar) {
        this.zza = context;
        this.zzd = zzfaiVar;
        this.zzc = zzdeoVar;
        this.zze = executor;
        this.zzf = zzbzxVar;
        this.zzb = zzdniVar;
        this.zzg = zzbilVar;
        this.zzi = zzeblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final zzfwm zza(final zzezz zzezzVar, final zzezn zzeznVar) {
        final zzdnm zzdnmVar = new zzdnm();
        zzfwm zzm = zzfwc.zzm(zzfwc.zzh(null), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzeea
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzeef.this.zzc(zzeznVar, zzezzVar, zzdnmVar, obj);
            }
        }, this.zze);
        zzm.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeeb
            @Override // java.lang.Runnable
            public final void run() {
                zzdnm.this.zzb();
            }
        }, this.zze);
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final boolean zzb(zzezz zzezzVar, zzezn zzeznVar) {
        zzezs zzezsVar = zzeznVar.zzt;
        if (zzezsVar != null && zzezsVar.zza != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(final zzezn zzeznVar, zzezz zzezzVar, zzdnm zzdnmVar, Object obj) throws Exception {
        zzbil zzbilVar;
        final zzcez zza = this.zzb.zza(this.zzd.zze, zzeznVar, zzezzVar.zzb.zzb);
        zza.zzZ(zzeznVar.zzX);
        zzdnmVar.zza(this.zza, (View) zza);
        zzcaj zzcajVar = new zzcaj();
        final zzddo zze = this.zzc.zze(new zzcrs(zzezzVar, zzeznVar, null), new zzddr(new zzeee(this.zza, this.zzf, zzcajVar, zzeznVar, zza, this.zzd, this.zzh, this.zzg, this.zzi), zza));
        zzcajVar.zzd(zze);
        zze.zzc().zzm(new zzcwa() { // from class: com.google.android.gms.internal.ads.zzeec
            @Override // com.google.android.gms.internal.ads.zzcwa
            public final void zzl() {
                zzcez zzcezVar = zzcez.this;
                if (zzcezVar.zzN() != null) {
                    zzcezVar.zzN().zzq();
                }
            }
        }, zzcae.zzf);
        zzdnh zzk = zze.zzk();
        if (this.zzh) {
            zzbilVar = this.zzg;
        } else {
            zzbilVar = null;
        }
        zzk.zzi(zza, true, zzbilVar);
        zze.zzk();
        zzezs zzezsVar = zzeznVar.zzt;
        return zzfwc.zzl(zzdnh.zzj(zza, zzezsVar.zzb, zzezsVar.zza), new zzfov() { // from class: com.google.android.gms.internal.ads.zzeed
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj2) {
                zzcez zzcezVar = zza;
                zzezn zzeznVar2 = zzeznVar;
                zzddo zzddoVar = zze;
                if (zzeznVar2.zzN) {
                    zzcezVar.zzae();
                }
                zzcezVar.zzY();
                zzcezVar.onPause();
                return zzddoVar.zzg();
            }
        }, this.zze);
    }
}
