package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbw {
    public static zzbv zza(String str) throws GeneralSecurityException {
        zzbv zzbvVar = (zzbv) zzcr.zze().get(str);
        if (zzbvVar != null) {
            return zzbvVar;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
