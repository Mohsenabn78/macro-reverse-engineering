package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzry  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzry extends zzahd implements zzaij {
    private static final zzry zzb;
    private int zzd;
    private zzafy zze = zzafy.zzb;
    private zztu zzf;

    static {
        zzry zzryVar = new zzry();
        zzb = zzryVar;
        zzahd.zzH(zzry.class, zzryVar);
    }

    private zzry() {
    }

    public static zzrx zza() {
        return (zzrx) zzb.zzt();
    }

    public static zzry zzc(InputStream inputStream, zzagq zzagqVar) throws IOException {
        return (zzry) zzahd.zzy(zzb, inputStream, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzry zzryVar, zztu zztuVar) {
        zztuVar.getClass();
        zzryVar.zzf = zztuVar;
        zzryVar.zzd |= 1;
    }

    public final zzafy zzd() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahd
    public final Object zzj(int i4, Object obj, Object obj2) {
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
                    return new zzrx(null);
                }
                return new zzry();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
