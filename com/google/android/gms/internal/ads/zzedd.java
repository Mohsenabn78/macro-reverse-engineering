package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzedd implements zzecc {
    private final zzcpy zza;
    private final Context zzb;
    private final zzdni zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzfov zzf;

    public zzedd(zzcpy zzcpyVar, Context context, Executor executor, zzdni zzdniVar, zzfai zzfaiVar, zzfov zzfovVar) {
        this.zzb = context;
        this.zza = zzcpyVar;
        this.zze = executor;
        this.zzc = zzdniVar;
        this.zzd = zzfaiVar;
        this.zzf = zzfovVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecc
    public final zzfwm zza(final zzezz zzezzVar, final zzezn zzeznVar) {
        return zzfwc.zzm(zzfwc.zzh(null), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzecx
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzedd.this.zzc(zzezzVar, zzeznVar, obj);
            }
        }, this.zze);
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
    public final /* synthetic */ zzfwm zzc(zzezz zzezzVar, zzezn zzeznVar, Object obj) throws Exception {
        View zzdnlVar;
        com.google.android.gms.ads.internal.client.zzq zza = zzfam.zza(this.zzb, zzeznVar.zzv);
        final zzcez zza2 = this.zzc.zza(zza, zzeznVar, zzezzVar.zzb.zzb);
        zza2.zzZ(zzeznVar.zzX);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && zzeznVar.zzah) {
            zzdnlVar = zzcqp.zza(this.zzb, (View) zza2, zzeznVar);
        } else {
            zzdnlVar = new zzdnl(this.zzb, (View) zza2, (com.google.android.gms.ads.internal.util.zzas) this.zzf.apply(zzeznVar));
        }
        final zzcpc zza3 = this.zza.zza(new zzcrs(zzezzVar, zzeznVar, null), new zzcpi(zzdnlVar, zza2, new zzcrb() { // from class: com.google.android.gms.internal.ads.zzecy
            @Override // com.google.android.gms.internal.ads.zzcrb
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzcez.this.zzq();
            }
        }, zzfam.zzb(zza)));
        zza3.zzh().zzi(zza2, false, null);
        zzcvy zzc = zza3.zzc();
        zzcwa zzcwaVar = new zzcwa() { // from class: com.google.android.gms.internal.ads.zzecz
            @Override // com.google.android.gms.internal.ads.zzcwa
            public final void zzl() {
                zzcez zzcezVar = zzcez.this;
                if (zzcezVar.zzN() != null) {
                    zzcezVar.zzN().zzq();
                }
            }
        };
        zzfwn zzfwnVar = zzcae.zzf;
        zzc.zzm(zzcwaVar, zzfwnVar);
        zza3.zzh();
        zzezs zzezsVar = zzeznVar.zzt;
        zzfwm zzj = zzdnh.zzj(zza2, zzezsVar.zzb, zzezsVar.zza);
        if (zzeznVar.zzN) {
            zzj.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeda
                @Override // java.lang.Runnable
                public final void run() {
                    zzcez.this.zzae();
                }
            }, this.zze);
        }
        zzj.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedb
            @Override // java.lang.Runnable
            public final void run() {
                zzedd.this.zzd(zza2);
            }
        }, this.zze);
        return zzfwc.zzl(zzj, new zzfov() { // from class: com.google.android.gms.internal.ads.zzedc
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj2) {
                return zzcpc.this.zza();
            }
        }, zzfwnVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcez zzcezVar) {
        zzcezVar.zzY();
        zzcfv zzq = zzcezVar.zzq();
        com.google.android.gms.ads.internal.client.zzfl zzflVar = this.zzd.zza;
        if (zzflVar != null && zzq != null) {
            zzq.zzs(zzflVar);
        }
    }
}
