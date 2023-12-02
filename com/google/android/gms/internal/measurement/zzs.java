package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z3, boolean z4) {
        super("log");
        this.zzc = zztVar;
        this.zza = z3;
        this.zzb = z4;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i4;
        zzr zzrVar;
        zzr zzrVar2;
        zzr zzrVar3;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            zzrVar3 = this.zzc.zza;
            zzrVar3.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        int zzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        if (zzb != 2) {
            if (zzb != 3) {
                if (zzb != 5) {
                    if (zzb != 6) {
                        i4 = 3;
                    } else {
                        i4 = 2;
                    }
                } else {
                    i4 = 5;
                }
            } else {
                i4 = 1;
            }
        } else {
            i4 = 4;
        }
        String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            zzrVar2 = this.zzc.zza;
            zzrVar2.zza(i4, zzi, Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 2; i5 < Math.min(list.size(), 5); i5++) {
            arrayList.add(zzgVar.zzb((zzap) list.get(i5)).zzi());
        }
        zzrVar = this.zzc.zza;
        zzrVar.zza(i4, zzi, arrayList, this.zza, this.zzb);
        return zzap.zzf;
    }
}
