package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzddn extends zzcrd {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdcc zze;
    private final zzdew zzf;
    private final zzcrx zzg;
    private final zzfjm zzh;
    private final zzcvt zzi;
    private boolean zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzddn(zzcrc zzcrcVar, Context context, @Nullable zzcez zzcezVar, zzdcc zzdccVar, zzdew zzdewVar, zzcrx zzcrxVar, zzfjm zzfjmVar, zzcvt zzcvtVar) {
        super(zzcrcVar);
        this.zzj = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcezVar);
        this.zze = zzdccVar;
        this.zzf = zzdewVar;
        this.zzg = zzcrxVar;
        this.zzh = zzfjmVar;
        this.zzi = zzcvtVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcez zzcezVar = (zzcez) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgy)).booleanValue()) {
                if (!this.zzj && zzcezVar != null) {
                    zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzddm
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

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    public final boolean zzc(boolean z3, @Nullable Activity activity) {
        this.zze.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaB)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzs.zzC(this.zzc)) {
                zzbzr.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaC)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzj) {
            zzbzr.zzj("The interstitial ad has been showed.");
            this.zzi.zza(zzfbi.zzd(10, null, null));
        }
        Activity activity2 = activity;
        if (!this.zzj) {
            if (activity == null) {
                activity2 = this.zzc;
            }
            try {
                this.zzf.zza(z3, activity2, this.zzi);
                this.zze.zza();
                this.zzj = true;
                return true;
            } catch (zzdev e4) {
                this.zzi.zzc(e4);
            }
        }
        return false;
    }
}
