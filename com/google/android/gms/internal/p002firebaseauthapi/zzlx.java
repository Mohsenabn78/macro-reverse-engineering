package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzlx {
    private static final ThreadLocal zza = new zzlw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SecureRandom zza() {
        SecureRandom zzc = zzc();
        zzc.nextLong();
        return zzc;
    }

    public static byte[] zzb(int i4) {
        byte[] bArr = new byte[i4];
        ((SecureRandom) zza.get()).nextBytes(bArr);
        return bArr;
    }

    private static SecureRandom zzc() {
        try {
            try {
                try {
                    return SecureRandom.getInstance("SHA1PRNG", ProviderInstaller.PROVIDER_NAME);
                } catch (GeneralSecurityException unused) {
                    return new SecureRandom();
                }
            } catch (GeneralSecurityException unused2) {
                return SecureRandom.getInstance("SHA1PRNG", "AndroidOpenSSL");
            }
        } catch (GeneralSecurityException unused3) {
            return SecureRandom.getInstance("SHA1PRNG", "Conscrypt");
        }
    }
}
