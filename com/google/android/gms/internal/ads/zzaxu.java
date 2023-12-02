package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxu extends zzgpm implements zzgqx {
    private static final zzaxu zzb;
    private zzgpv zzd = zzgpm.zzaN();

    static {
        zzaxu zzaxuVar = new zzaxu();
        zzb = zzaxuVar;
        zzgpm.zzaU(zzaxu.class, zzaxuVar);
    }

    private zzaxu() {
    }

    public static zzaxo zza() {
        return (zzaxo) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzaxu zzaxuVar, zzaxn zzaxnVar) {
        zzaxnVar.getClass();
        zzgpv zzgpvVar = zzaxuVar.zzd;
        if (!zzgpvVar.zzc()) {
            zzaxuVar.zzd = zzgpm.zzaO(zzgpvVar);
        }
        zzaxuVar.zzd.add(zzaxnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzaxo(null);
                }
                return new zzaxu();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzaxn.class});
        }
        return (byte) 1;
    }
}
