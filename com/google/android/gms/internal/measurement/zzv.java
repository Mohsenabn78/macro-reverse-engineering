package com.google.android.gms.internal.measurement;

import java.util.List;
import org.apache.commons.logging.LogFactory;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzv extends zzai {
    private final zzz zza;

    public zzv(zzz zzzVar) {
        super("internal.registerCallback");
        this.zza = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i4;
        zzh.zzh(this.zzd, 3, list);
        String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
        zzap zzb = zzgVar.zzb((zzap) list.get(1));
        if (zzb instanceof zzao) {
            zzap zzb2 = zzgVar.zzb((zzap) list.get(2));
            if (zzb2 instanceof zzam) {
                zzam zzamVar = (zzam) zzb2;
                if (zzamVar.zzt("type")) {
                    String zzi2 = zzamVar.zzf("type").zzi();
                    if (zzamVar.zzt(LogFactory.PRIORITY_KEY)) {
                        i4 = zzh.zzb(zzamVar.zzf(LogFactory.PRIORITY_KEY).zzh().doubleValue());
                    } else {
                        i4 = 1000;
                    }
                    this.zza.zza(zzi, i4, (zzao) zzb, zzi2);
                    return zzap.zzf;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
