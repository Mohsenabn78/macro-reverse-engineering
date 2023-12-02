package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcpe extends zzcpb {
    private final Context zzc;
    private final View zzd;
    @Nullable
    private final zzcez zze;
    private final zzezo zzf;
    private final zzcrb zzg;
    private final zzdhl zzh;
    private final zzdcw zzi;
    private final zzgvy zzj;
    private final Executor zzk;
    private com.google.android.gms.ads.internal.client.zzq zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcpe(zzcrc zzcrcVar, Context context, zzezo zzezoVar, View view, @Nullable zzcez zzcezVar, zzcrb zzcrbVar, zzdhl zzdhlVar, zzdcw zzdcwVar, zzgvy zzgvyVar, Executor executor) {
        super(zzcrcVar);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcezVar;
        this.zzf = zzezoVar;
        this.zzg = zzcrbVar;
        this.zzh = zzdhlVar;
        this.zzi = zzdcwVar;
        this.zzj = zzgvyVar;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcpe zzcpeVar) {
        zzdhl zzdhlVar = zzcpeVar.zzh;
        if (zzdhlVar.zze() == null) {
            return;
        }
        try {
            zzdhlVar.zze().zze((com.google.android.gms.ads.internal.client.zzbu) zzcpeVar.zzj.zzb(), ObjectWrapper.wrap(zzcpeVar.zzc));
        } catch (RemoteException e4) {
            zzbzr.zzh("RemoteException when notifyAdLoad is called", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    public final int zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() && this.zzb.zzah) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzht)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    public final View zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfan unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    public final zzezo zze() {
        com.google.android.gms.ads.internal.client.zzq zzqVar = this.zzl;
        if (zzqVar != null) {
            return zzfam.zzb(zzqVar);
        }
        zzezn zzeznVar = this.zzb;
        if (zzeznVar.zzad) {
            for (String str : zzeznVar.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            return new zzezo(this.zzd.getWidth(), this.zzd.getHeight(), false);
        }
        return (zzezo) this.zzb.zzs.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    public final zzezo zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    public final void zzg() {
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcpb
    public final void zzh(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzq zzqVar) {
        zzcez zzcezVar;
        if (viewGroup != null && (zzcezVar = this.zze) != null) {
            zzcezVar.zzag(zzcgo.zzc(zzqVar));
            viewGroup.setMinimumHeight(zzqVar.zzc);
            viewGroup.setMinimumWidth(zzqVar.zzf);
            this.zzl = zzqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrd
    public final void zzj() {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpd
            @Override // java.lang.Runnable
            public final void run() {
                zzcpe.zzi(zzcpe.this);
            }
        });
        super.zzj();
    }
}
