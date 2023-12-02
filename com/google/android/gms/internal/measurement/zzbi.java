package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzbi extends zzaw {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbi() {
        this.zza.add(zzbl.ADD);
        this.zza.add(zzbl.DIVIDE);
        this.zza.add(zzbl.MODULUS);
        this.zza.add(zzbl.MULTIPLY);
        this.zza.add(zzbl.NEGATE);
        this.zza.add(zzbl.POST_DECREMENT);
        this.zza.add(zzbl.POST_INCREMENT);
        this.zza.add(zzbl.PRE_DECREMENT);
        this.zza.add(zzbl.PRE_INCREMENT);
        this.zza.add(zzbl.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 0) {
            if (ordinal != 21) {
                if (ordinal != 59) {
                    if (ordinal != 52 && ordinal != 53) {
                        if (ordinal != 55 && ordinal != 56) {
                            switch (ordinal) {
                                case 44:
                                    zzh.zzh(zzbl.MODULUS.name(), 2, list);
                                    return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() % zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                                case 45:
                                    zzh.zzh(zzbl.MULTIPLY.name(), 2, list);
                                    return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() * zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                                case 46:
                                    zzh.zzh(zzbl.NEGATE.name(), 1, list);
                                    return new zzah(Double.valueOf(-zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()));
                                default:
                                    return super.zzb(str);
                            }
                        }
                        zzh.zzh(str, 1, list);
                        return zzgVar.zzb((zzap) list.get(0));
                    }
                    zzh.zzh(str, 2, list);
                    zzap zzb = zzgVar.zzb((zzap) list.get(0));
                    zzgVar.zzb((zzap) list.get(1));
                    return zzb;
                }
                zzh.zzh(zzbl.SUBTRACT.name(), 2, list);
                return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() + new zzah(Double.valueOf(-zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue())).zzh().doubleValue()));
            }
            zzh.zzh(zzbl.DIVIDE.name(), 2, list);
            return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() / zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
        }
        zzh.zzh(zzbl.ADD.name(), 2, list);
        zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
        zzap zzb3 = zzgVar.zzb((zzap) list.get(1));
        if (!(zzb2 instanceof zzal) && !(zzb2 instanceof zzat) && !(zzb3 instanceof zzal) && !(zzb3 instanceof zzat)) {
            return new zzah(Double.valueOf(zzb2.zzh().doubleValue() + zzb3.zzh().doubleValue()));
        }
        return new zzat(String.valueOf(zzb2.zzi()).concat(String.valueOf(zzb3.zzi())));
    }
}
