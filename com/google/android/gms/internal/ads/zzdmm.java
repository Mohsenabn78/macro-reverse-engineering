package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdmm extends zzcrd {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdew zze;
    private final zzdcc zzf;
    private final zzcvt zzg;
    private final zzcxa zzh;
    private final zzcrx zzi;
    private final zzbvk zzj;
    private final zzfjm zzk;
    private final zzfab zzl;
    private boolean zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmm(zzcrc zzcrcVar, Context context, @Nullable zzcez zzcezVar, zzdew zzdewVar, zzdcc zzdccVar, zzcvt zzcvtVar, zzcxa zzcxaVar, zzcrx zzcrxVar, zzezn zzeznVar, zzfjm zzfjmVar, zzfab zzfabVar) {
        super(zzcrcVar);
        String str;
        int i4;
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdewVar;
        this.zzd = new WeakReference(zzcezVar);
        this.zzf = zzdccVar;
        this.zzg = zzcvtVar;
        this.zzh = zzcxaVar;
        this.zzi = zzcrxVar;
        this.zzk = zzfjmVar;
        zzbvg zzbvgVar = zzeznVar.zzm;
        if (zzbvgVar != null) {
            str = zzbvgVar.zza;
        } else {
            str = "";
        }
        if (zzbvgVar != null) {
            i4 = zzbvgVar.zzb;
        } else {
            i4 = 1;
        }
        this.zzj = new zzbwe(str, i4);
        this.zzl = zzfabVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcez zzcezVar = (zzcez) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgy)).booleanValue()) {
                if (!this.zzm && zzcezVar != null) {
                    zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdml
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcez.this.destroy();
                        }
                    });
                }
            } else if (zzcezVar != null) {
                zzcezVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbvk zzc() {
        return this.zzj;
    }

    public final zzfab zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcez zzcezVar = (zzcez) this.zzd.get();
        if (zzcezVar != null && !zzcezVar.zzaB()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    public final boolean zzh(boolean z3, @Nullable Activity activity) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaB)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzs.zzC(this.zzc)) {
                zzbzr.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaC)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzbzr.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfbi.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.zzc;
        }
        try {
            this.zze.zza(z3, activity2, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdev e4) {
            this.zzg.zzc(e4);
            return false;
        }
    }
}
