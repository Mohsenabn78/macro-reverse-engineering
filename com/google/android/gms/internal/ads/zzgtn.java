package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgtn extends zzgpm implements zzgqx {
    private static final zzgtn zzb;
    private int zzd;
    private String zze = "";

    static {
        zzgtn zzgtnVar = new zzgtn();
        zzb = zzgtnVar;
        zzgpm.zzaU(zzgtn.class, zzgtnVar);
    }

    private zzgtn() {
    }

    public static zzgtm zza() {
        return (zzgtm) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzgtn zzgtnVar, String str) {
        zzgtnVar.zzd |= 1;
        zzgtnVar.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgpm
    public final Object zzb(int i4, Object obj, Object obj2) {
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
                    return new zzgtm(null);
                }
                return new zzgtn();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
