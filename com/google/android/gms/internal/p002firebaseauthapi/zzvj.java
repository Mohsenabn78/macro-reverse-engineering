package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvj  reason: invalid package */
/* loaded from: classes4.dex */
final class zzvj implements zzvo {
    private final zzvx zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzvo
    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider provider : zzvp.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, provider);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, null);
    }
}
