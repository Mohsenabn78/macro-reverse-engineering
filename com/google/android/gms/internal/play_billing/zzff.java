package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzff extends zzcb implements zzdg {
    private static final zzff zzb;
    private int zzd;
    private int zze;

    static {
        zzff zzffVar = new zzff();
        zzb = zzffVar;
        zzcb.zzo(zzff.class, zzffVar);
    }

    private zzff() {
    }

    public static zzfe zzu() {
        return (zzfe) zzb.zze();
    }

    public static /* synthetic */ void zzw(zzff zzffVar, int i4) {
        zzffVar.zze = i4 - 1;
        zzffVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcb
    public final Object zzt(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zzfe(null);
                }
                return new zzff();
            }
            return zzcb.zzl(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", zzfc.zza});
        }
        return (byte) 1;
    }
}
