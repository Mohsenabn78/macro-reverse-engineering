package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzgf extends zzda<zzgf, zzge> implements zzef {
    private static final zzgf zzg;
    private int zzb;
    private String zze = "";
    private zzdg<zzgd> zzf = zzda.zzw();

    static {
        zzgf zzgfVar = new zzgf();
        zzg = zzgfVar;
        zzda.zzq(zzgf.class, zzgfVar);
    }

    private zzgf() {
    }

    public static zzge zza() {
        return zzg.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzgf zzgfVar, String str) {
        zzgfVar.zzb |= 1;
        zzgfVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzgf zzgfVar, zzgd zzgdVar) {
        zzgdVar.getClass();
        zzdg<zzgd> zzdgVar = zzgfVar.zzf;
        if (!zzdgVar.zza()) {
            zzgfVar.zzf = zzda.zzx(zzdgVar);
        }
        zzgfVar.zzf.add(zzgdVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.icing.zzda
    public final Object zzf(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            return null;
                        }
                        return zzg;
                    }
                    return new zzge(null);
                }
                return new zzgf();
            }
            return zzda.zzr(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zze", "zzf", zzgd.class});
        }
        return (byte) 1;
    }
}
