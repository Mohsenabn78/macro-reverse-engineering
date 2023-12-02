package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzglc extends zzgpm implements zzgqx {
    private static final zzglc zzb;
    private int zzd;
    private zzgpv zze = zzgpm.zzaN();

    static {
        zzglc zzglcVar = new zzglc();
        zzb = zzglcVar;
        zzgpm.zzaU(zzglc.class, zzglcVar);
    }

    private zzglc() {
    }

    public static zzgkz zza() {
        return (zzgkz) zzb.zzaA();
    }

    public static /* synthetic */ void zze(zzglc zzglcVar, zzglb zzglbVar) {
        zzglbVar.getClass();
        zzgpv zzgpvVar = zzglcVar.zze;
        if (!zzgpvVar.zzc()) {
            zzglcVar.zze = zzgpm.zzaO(zzgpvVar);
        }
        zzglcVar.zze.add(zzglbVar);
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
                    return new zzgkz(null);
                }
                return new zzglc();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzglb.class});
        }
        return (byte) 1;
    }
}
