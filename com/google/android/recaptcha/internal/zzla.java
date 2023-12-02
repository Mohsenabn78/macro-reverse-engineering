package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzla extends zzgo implements zzhz {
    private static final zzla zzb;
    private zzgv zzd = zzgo.zzw();

    static {
        zzla zzlaVar = new zzla();
        zzb = zzlaVar;
        zzgo.zzC(zzla.class, zzlaVar);
    }

    private zzla() {
    }

    public static zzkz zzf() {
        return (zzkz) zzb.zzp();
    }

    public static zzla zzi(byte[] bArr) throws zzgy {
        return (zzla) zzgo.zzu(zzb, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzla zzlaVar, zzkx zzkxVar) {
        zzkxVar.getClass();
        zzgv zzgvVar = zzlaVar.zzd;
        if (!zzgvVar.zzc()) {
            zzlaVar.zzd = zzgo.zzx(zzgvVar);
        }
        zzlaVar.zzd.add(zzkxVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.recaptcha.internal.zzgo
    public final Object zzh(int i4, Object obj, Object obj2) {
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
                    return new zzkz(null);
                }
                return new zzla();
            }
            return zzgo.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzkx.class});
        }
        return (byte) 1;
    }

    public final List zzj() {
        return this.zzd;
    }
}
