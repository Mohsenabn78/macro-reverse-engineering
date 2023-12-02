package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzecn implements zzecc {
    private final zzcop zza;
    private final Context zzb;
    private final zzdni zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzbzx zzf;
    private final zzbil zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzit)).booleanValue();
    private final zzebl zzi;

    public zzecn(zzcop zzcopVar, Context context, Executor executor, zzdni zzdniVar, zzfai zzfaiVar, zzbzx zzbzxVar, zzbil zzbilVar, zzebl zzeblVar) {
        this.zzb = context;
        this.zza = zzcopVar;
        this.zze = executor;
        this.zzc = zzdniVar;
        this.zzd = zzfaiVar;
        this.zzf = zzbzxVar;
        this.zzg = zzbilVar;
        this.zzi = zzeblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final zzfwm zza(final zzezz zzezzVar, final zzezn zzeznVar) {
        final zzdnm zzdnmVar = new zzdnm();
        zzfwm zzm = zzfwc.zzm(zzfwc.zzh(null), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzecl
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzecn.this.zzc(zzeznVar, zzezzVar, zzdnmVar, obj);
            }
        }, this.zze);
        zzm.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzecm
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
        final zzcez zza = this.zzc.zza(this.zzd.zze, zzeznVar, zzezzVar.zzb.zzb);
        zza.zzZ(zzeznVar.zzX);
        zzdnmVar.zza(this.zzb, (View) zza);
        zzcaj zzcajVar = new zzcaj();
        final zzcom zza2 = this.zza.zza(new zzcrs(zzezzVar, zzeznVar, null), new zzddr(new zzecp(this.zzf, zzcajVar, zzeznVar, zza, this.zzd, this.zzh, this.zzg, this.zzi), zza), new zzcon(zzeznVar.zzab));
        zzdnh zzh = zza2.zzh();
        if (this.zzh) {
            zzbilVar = this.zzg;
        } else {
            zzbilVar = null;
        }
        zzh.zzi(zza, false, zzbilVar);
        zzcajVar.zzd(zza2);
        zza2.zzc().zzm(new zzcwa() { // from class: com.google.android.gms.internal.ads.zzecj
            @Override // com.google.android.gms.internal.ads.zzcwa
            public final void zzl() {
                zzcez zzcezVar = zzcez.this;
                if (zzcezVar.zzN() != null) {
                    zzcezVar.zzN().zzq();
                }
            }
        }, zzcae.zzf);
        zza2.zzh();
        zzezs zzezsVar = zzeznVar.zzt;
        return zzfwc.zzl(zzdnh.zzj(zza, zzezsVar.zzb, zzezsVar.zza), new zzfov() { // from class: com.google.android.gms.internal.ads.zzeck
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj2) {
                zzcez zzcezVar = zza;
                zzezn zzeznVar2 = zzeznVar;
                zzcom zzcomVar = zza2;
                if (zzeznVar2.zzN) {
                    zzcezVar.zzae();
                }
                zzcezVar.zzY();
                zzcezVar.onPause();
                return zzcomVar.zza();
            }
        }, this.zze);
    }
}
