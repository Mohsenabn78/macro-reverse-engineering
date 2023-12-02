package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdco extends zzdaq implements zzaua {
    private final Map zzb;
    private final Context zzc;
    private final zzezn zzd;

    public zzdco(Context context, Set set, zzezn zzeznVar) {
        super(set);
        this.zzb = new WeakHashMap(1);
        this.zzc = context;
        this.zzd = zzeznVar;
    }

    public final synchronized void zza(View view) {
        zzaub zzaubVar = (zzaub) this.zzb.get(view);
        if (zzaubVar == null) {
            zzaubVar = new zzaub(this.zzc, view);
            zzaubVar.zzc(this);
            this.zzb.put(view, zzaubVar);
        }
        if (this.zzd.zzY) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbk)).booleanValue()) {
                zzaubVar.zzg(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbj)).longValue());
                return;
            }
        }
        zzaubVar.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzaub) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzc(final zzatz zzatzVar) {
        zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzdcn
            @Override // com.google.android.gms.internal.ads.zzdap
            public final void zza(Object obj) {
                ((zzaua) obj).zzc(zzatz.this);
            }
        });
    }
}
