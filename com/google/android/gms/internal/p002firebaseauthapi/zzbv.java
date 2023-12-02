package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbv {
    @Nullable
    private final zzth zza;

    private zzbv(zzth zzthVar) {
        this.zza = zzthVar;
    }

    public static zzbv zzd(String str, byte[] bArr, int i4) {
        zzui zzuiVar;
        zztg zza = zzth.zza();
        zza.zzb(str);
        zzafy zzafyVar = zzafy.zzb;
        zza.zzc(zzafy.zzn(bArr, 0, bArr.length));
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    zzuiVar = zzui.CRUNCHY;
                } else {
                    zzuiVar = zzui.RAW;
                }
            } else {
                zzuiVar = zzui.LEGACY;
            }
        } else {
            zzuiVar = zzui.TINK;
        }
        zza.zza(zzuiVar);
        return new zzbv((zzth) zza.zzi());
    }

    public final zzcf zza() throws GeneralSecurityException {
        try {
            zzth zzd = zzth.zzd(zzb().zzq(), zzagq.zza());
            zzkz zzc = zzkz.zzc();
            zzlv zza = zzlv.zza(zzd);
            if (!zzc.zzi(zza)) {
                return new zzkp(zza);
            }
            return zzc.zzb(zza);
        } catch (IOException e4) {
            throw new GeneralSecurityException("Failed to parse proto", e4);
        }
    }

    final zzth zzb() {
        try {
            return zzc();
        } catch (GeneralSecurityException e4) {
            throw new zzmi("Parsing parameters failed in getProto(). You probably want to call some Tink register function for null", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzth zzc() throws GeneralSecurityException {
        zzth zzthVar = this.zza;
        if (zzthVar != null) {
            return zzthVar;
        }
        return ((zzlv) zzkz.zzc().zzd(null, zzlv.class)).zzc();
    }
}
