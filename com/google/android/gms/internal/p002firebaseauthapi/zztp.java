package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zztp extends zzahd implements zzaij {
    private static final zztp zzb;
    private int zzd;
    private zzahi zze = zzahd.zzA();

    static {
        zztp zztpVar = new zztp();
        zzb = zztpVar;
        zzahd.zzH(zztp.class, zztpVar);
    }

    private zztp() {
    }

    public static zztm zzc() {
        return (zztm) zzb.zzt();
    }

    public static zztp zzf(InputStream inputStream, zzagq zzagqVar) throws IOException {
        return (zztp) zzahd.zzy(zzb, inputStream, zzagqVar);
    }

    public static zztp zzg(byte[] bArr, zzagq zzagqVar) throws zzahl {
        return (zztp) zzahd.zzz(zzb, bArr, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zztp zztpVar, zzto zztoVar) {
        zztoVar.getClass();
        zzahi zzahiVar = zztpVar.zze;
        if (!zzahiVar.zzc()) {
            zztpVar.zze = zzahd.zzB(zzahiVar);
        }
        zztpVar.zze.add(zztoVar);
    }

    public final int zza() {
        return this.zze.size();
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zzto zzd(int i4) {
        return (zzto) this.zze.get(i4);
    }

    public final List zzh() {
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
                    return new zztm(null);
                }
                return new zztp();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzto.class});
        }
        return (byte) 1;
    }
}
