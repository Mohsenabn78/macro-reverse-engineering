package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzedz extends zzbve implements zzcwq {
    private zzbvf zza;
    private zzcwp zzb;
    private zzddf zzc;

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final synchronized void zza(zzcwp zzcwpVar) {
        this.zzb = zzcwpVar;
    }

    public final synchronized void zzc(zzbvf zzbvfVar) {
        this.zza = zzbvfVar;
    }

    public final synchronized void zzd(zzddf zzddfVar) {
        this.zzc = zzddfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            ((zzegx) zzbvfVar).zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            zzbvfVar.zzf(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i4) throws RemoteException {
        zzcwp zzcwpVar = this.zzb;
        if (zzcwpVar != null) {
            zzcwpVar.zza(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            ((zzegx) zzbvfVar).zzc.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcwp zzcwpVar = this.zzb;
        if (zzcwpVar != null) {
            zzcwpVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            ((zzegx) zzbvfVar).zza.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i4) throws RemoteException {
        zzddf zzddfVar = this.zzc;
        if (zzddfVar != null) {
            zzbzr.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzegw) zzddfVar).zzc.zza)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzddf zzddfVar = this.zzc;
        if (zzddfVar != null) {
            Executor zzc = zzegy.zzc(((zzegw) zzddfVar).zzd);
            final zzezz zzezzVar = ((zzegw) zzddfVar).zza;
            final zzezn zzeznVar = ((zzegw) zzddfVar).zzb;
            final zzecf zzecfVar = ((zzegw) zzddfVar).zzc;
            final zzegw zzegwVar = (zzegw) zzddfVar;
            zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegv
                @Override // java.lang.Runnable
                public final void run() {
                    zzegw zzegwVar2 = zzegw.this;
                    zzezz zzezzVar2 = zzezzVar;
                    zzezn zzeznVar2 = zzeznVar;
                    zzecf zzecfVar2 = zzecfVar;
                    zzegy zzegyVar = zzegwVar2.zzd;
                    zzegy.zze(zzezzVar2, zzeznVar2, zzecfVar2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbvg zzbvgVar) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            ((zzegx) zzbvfVar).zzd.zza(zzbvgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            ((zzegx) zzbvfVar).zzc.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvfVar = this.zza;
        if (zzbvfVar != null) {
            ((zzegx) zzbvfVar).zzd.zzc();
        }
    }
}
