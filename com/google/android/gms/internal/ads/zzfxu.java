package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxu {
    public static zzfxt zza(String str) throws GeneralSecurityException {
        zzfxt zzfxtVar = (zzfxt) zzfyp.zzd().get("AES128_GCM");
        if (zzfxtVar != null) {
            return zzfxtVar;
        }
        throw new GeneralSecurityException("cannot find key template: AES128_GCM");
    }
}
