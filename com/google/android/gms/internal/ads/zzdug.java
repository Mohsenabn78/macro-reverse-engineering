package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdug implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzdug(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzaqs zzaqsVar = (zzaqs) this.zza.zzb();
        final Context zza = ((zzcha) this.zzb).zza();
        zzfwn zzfwnVar = zzcae.zza;
        zzgwm.zzb(zzfwnVar);
        zzfwm zzb = zzfwnVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdud
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzaqs zzaqsVar2 = zzaqs.this;
                return zzaqsVar2.zzc().zzg(zza);
            }
        });
        zzgwm.zzb(zzb);
        return zzb;
    }
}
