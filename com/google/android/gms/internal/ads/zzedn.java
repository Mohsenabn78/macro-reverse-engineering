package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzedn implements zzeci {
    private final Context zza;
    private final zzcpy zzb;
    private View zzc;
    private zzbof zzd;

    public zzedn(Context context, zzcpy zzcpyVar) {
        this.zza = context;
        this.zzb = zzcpyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, final zzezn zzeznVar, final zzecf zzecfVar) throws zzfan, zzefu {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && zzeznVar.zzah) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view != null) {
                    if (zzf) {
                        try {
                            view = (View) zzfwc.zzm(zzfwc.zzh(null), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzedj
                                @Override // com.google.android.gms.internal.ads.zzfvj
                                public final zzfwm zza(Object obj) {
                                    return zzedn.this.zzc(view, zzeznVar, obj);
                                }
                            }, zzcae.zze).get();
                        } catch (InterruptedException | ExecutionException e4) {
                            throw new zzfan(e4);
                        }
                    }
                } else {
                    throw new zzfan(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
            } catch (RemoteException e5) {
                throw new zzfan(e5);
            }
        } else {
            view = this.zzc;
        }
        zzcpc zza = this.zzb.zza(new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza), new zzcpi(view, null, new zzcrb() { // from class: com.google.android.gms.internal.ads.zzedk
            @Override // com.google.android.gms.internal.ads.zzcrb
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                try {
                    return ((zzbpt) zzecf.this.zzb).zze();
                } catch (RemoteException e6) {
                    throw new zzfan(e6);
                }
            }
        }, (zzezo) zzeznVar.zzv.get(0)));
        zza.zzg().zza(view);
        ((zzedy) zzecfVar.zzc).zzc(zza.zzi());
        return zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        try {
            ((zzbpt) zzecfVar.zzb).zzq(zzeznVar.zzaa);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && zzeznVar.zzah) {
                ((zzbpt) zzecfVar.zzb).zzk(zzeznVar.zzV, zzeznVar.zzw.toString(), zzezzVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzedm(this, zzecfVar, null), (zzboc) zzecfVar.zzc, zzezzVar.zza.zza.zze);
            } else {
                ((zzbpt) zzecfVar.zzb).zzj(zzeznVar.zzV, zzeznVar.zzw.toString(), zzezzVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzedm(this, zzecfVar, null), (zzboc) zzecfVar.zzc, zzezzVar.zza.zza.zze);
            }
        } catch (RemoteException e4) {
            throw new zzfan(e4);
        }
    }

    public final /* synthetic */ zzfwm zzc(View view, zzezn zzeznVar, Object obj) throws Exception {
        return zzfwc.zzh(zzcqp.zza(this.zza, view, zzeznVar));
    }
}
