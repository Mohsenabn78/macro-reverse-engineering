package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfau {
    @VisibleForTesting
    public zzfau() {
        try {
            zzfys.zza();
        } catch (GeneralSecurityException e4) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e4.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgob zzt = zzgoe.zzt();
        try {
            zzfxk.zzb(zzfyb.zzc(zzfxu.zza("AES128_GCM").zza()), zzfxj.zzb(zzt));
        } catch (IOException | GeneralSecurityException e4) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e4.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "CryptoUtils.generateKey");
        }
        String encodeToString = Base64.encodeToString(zzt.zzb().zzA(), 11);
        zzt.zzc();
        return encodeToString;
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdpv zzdpvVar) {
        zzfyb zzc = zzc(str);
        if (zzc == null) {
            return null;
        }
        try {
            byte[] zza = ((zzfxh) zzc.zze(zzgfc.zza(), zzfxh.class)).zza(bArr, bArr2);
            zzdpvVar.zza().put("ds", "1");
            return new String(zza, "UTF-8");
        } catch (UnsupportedEncodingException | GeneralSecurityException e4) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e4.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "CryptoUtils.decrypt");
            zzdpvVar.zza().put("dsf", e4.toString());
            return null;
        }
    }

    @Nullable
    private static final zzfyb zzc(String str) {
        try {
            return zzfxk.zza(zzfxi.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e4) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e4.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "CryptoUtils.getHandle");
            return null;
        }
    }
}
