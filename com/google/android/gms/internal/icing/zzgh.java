package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzgh extends zzda<zzgh, zzgg> implements zzef {
    private static final zzgh zzj;
    private int zzb;
    private boolean zze;
    private String zzf = "";
    private long zzg;
    private double zzh;
    private zzgf zzi;

    static {
        zzgh zzghVar = new zzgh();
        zzj = zzghVar;
        zzda.zzq(zzgh.class, zzghVar);
    }

    private zzgh() {
    }

    public static zzgg zza() {
        return zzj.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzgh zzghVar, boolean z3) {
        zzghVar.zzb |= 1;
        zzghVar.zze = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzgh zzghVar, String str) {
        str.getClass();
        zzghVar.zzb |= 2;
        zzghVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzgh zzghVar, zzgf zzgfVar) {
        zzgfVar.getClass();
        zzghVar.zzi = zzgfVar;
        zzghVar.zzb |= 16;
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
                        return zzj;
                    }
                    return new zzgg(null);
                }
                return new zzgh();
            }
            return zzda.zzr(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004က\u0003\u0005ဉ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
