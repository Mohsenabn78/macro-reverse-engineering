package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsl  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzsl {
    private static final zzahg zza = new zzsk();

    public static /* synthetic */ String zza(int i4) {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        if (i4 != 6) {
                            return "UNRECOGNIZED";
                        }
                        return "DHKEM_P521_HKDF_SHA512";
                    }
                    return "DHKEM_P384_HKDF_SHA384";
                }
                return "DHKEM_P256_HKDF_SHA256";
            }
            return "DHKEM_X25519_HKDF_SHA256";
        }
        return "KEM_UNKNOWN";
    }
}
