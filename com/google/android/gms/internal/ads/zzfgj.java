package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgj extends zzgpm implements zzgqx {
    private static final zzfgj zzb;
    private zzgpv zzd = zzgpm.zzaN();

    static {
        zzfgj zzfgjVar = new zzfgj();
        zzb = zzfgjVar;
        zzgpm.zzaU(zzfgj.class, zzfgjVar);
    }

    private zzfgj() {
    }

    public static zzfgg zzc() {
        return (zzfgg) zzb.zzaA();
    }

    public static /* synthetic */ zzfgj zzd() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzfgj zzfgjVar) {
        zzfgjVar.zzd = zzgpm.zzaN();
    }

    public static /* synthetic */ void zzf(zzfgj zzfgjVar, zzfgi zzfgiVar) {
        zzfgiVar.getClass();
        zzgpv zzgpvVar = zzfgjVar.zzd;
        if (!zzgpvVar.zzc()) {
            zzfgjVar.zzd = zzgpm.zzaO(zzgpvVar);
        }
        zzfgjVar.zzd.add(zzfgiVar);
    }

    public final int zza() {
        return this.zzd.size();
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
                    return new zzfgg(null);
                }
                return new zzfgj();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfgi.class});
        }
        return (byte) 1;
    }
}
