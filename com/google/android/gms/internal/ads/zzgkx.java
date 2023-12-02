package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgkx extends zzgpm implements zzgqx {
    private static final zzgkx zzb;
    private int zzd;
    private zzgpv zze = zzgpm.zzaN();

    static {
        zzgkx zzgkxVar = new zzgkx();
        zzb = zzgkxVar;
        zzgpm.zzaU(zzgkx.class, zzgkxVar);
    }

    private zzgkx() {
    }

    public static zzgku zzd() {
        return (zzgku) zzb.zzaA();
    }

    public static zzgkx zzg(InputStream inputStream, zzgoy zzgoyVar) throws IOException {
        return (zzgkx) zzgpm.zzaH(zzb, inputStream, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzgkx zzgkxVar, zzgkw zzgkwVar) {
        zzgkwVar.getClass();
        zzgpv zzgpvVar = zzgkxVar.zze;
        if (!zzgpvVar.zzc()) {
            zzgkxVar.zze = zzgpm.zzaO(zzgpvVar);
        }
        zzgkxVar.zze.add(zzgkwVar);
    }

    public final int zza() {
        return this.zze.size();
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
                    return new zzgku(null);
                }
                return new zzgkx();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgkw.class});
        }
        return (byte) 1;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzgkw zze(int i4) {
        return (zzgkw) this.zze.get(i4);
    }

    public final List zzh() {
        return this.zze;
    }
}
