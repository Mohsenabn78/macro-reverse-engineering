package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgr {
    private final Context zza;
    private final Executor zzb;
    private final zzbzw zzc;
    private final zzfgb zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfgr(Context context, Executor executor, zzbzw zzbzwVar, zzfgb zzfgbVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzbzwVar;
        this.zzd = zzfgbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, zzffy zzffyVar) {
        zzffn zza = zzffm.zza(this.zza, 14);
        zza.zzh();
        zza.zzf(this.zzc.zza(str));
        if (zzffyVar == null) {
            this.zzd.zzb(zza.zzl());
            return;
        }
        zzffyVar.zza(zza);
        zzffyVar.zzg();
    }

    public final void zzc(final String str, @Nullable final zzffy zzffyVar) {
        if (zzfgb.zza() && ((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgq
                @Override // java.lang.Runnable
                public final void run() {
                    zzfgr.this.zzb(str, zzffyVar);
                }
            });
        } else {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgp
                @Override // java.lang.Runnable
                public final void run() {
                    zzfgr.this.zza(str);
                }
            });
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), null);
        }
    }
}
