package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzadw {
    public static long zza(String str) {
        Preconditions.checkNotEmpty(str);
        List zzd = zzab.zzb(zzj.zzb('.')).zzd(str);
        if (zzd.size() >= 2) {
            try {
                zzadx zza = zzadx.zza(new String(Base64Utils.decodeUrlSafeNoPadding((String) zzd.get(1)), "UTF-8"));
                return zza.zzb().longValue() - zza.zzc().longValue();
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException("Unable to decode token", e4);
            }
        }
        throw new RuntimeException("Invalid idToken ".concat(String.valueOf(str)));
    }
}
