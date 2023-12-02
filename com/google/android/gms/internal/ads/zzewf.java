package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzewf implements zzexe {
    private zzcun zza;
    private final Executor zzb = zzfwt.zzb();

    public final zzcun zza() {
        return this.zza;
    }

    public final zzfwm zzb(zzexf zzexfVar, zzexd zzexdVar, @Nullable zzcun zzcunVar) {
        zzcum zza = zzexdVar.zza(zzexfVar.zzb);
        zza.zzb(new zzexi(true));
        zzcun zzcunVar2 = (zzcun) zza.zzh();
        this.zza = zzcunVar2;
        final zzcsk zzb = zzcunVar2.zzb();
        final zzfcd zzfcdVar = new zzfcd();
        return zzfwc.zzl(zzfwc.zzm(zzfvt.zzv(zzb.zzj()), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzewd
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                zzfcd zzfcdVar2 = zzfcdVar;
                zzcsk zzcskVar = zzb;
                zzezz zzezzVar = (zzezz) obj;
                zzfcdVar2.zzb = zzezzVar;
                Iterator it = zzezzVar.zzb.zza.iterator();
                boolean z3 = false;
                loop0: while (true) {
                    if (it.hasNext()) {
                        for (String str : ((zzezn) it.next()).zza) {
                            if (!str.contains("FirstPartyRenderer")) {
                                break loop0;
                            }
                            z3 = true;
                        }
                    } else if (z3) {
                        return zzcskVar.zzi(zzfwc.zzh(zzezzVar));
                    }
                }
                return zzfwc.zzh(null);
            }
        }, this.zzb), new zzfov() { // from class: com.google.android.gms.internal.ads.zzewe
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                zzfcd zzfcdVar2 = zzfcd.this;
                zzfcdVar2.zzc = (zzcrd) obj;
                return zzfcdVar2;
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexfVar, zzexd zzexdVar, @Nullable Object obj) {
        return zzb(zzexfVar, zzexdVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
