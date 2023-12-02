package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv  reason: invalid package */
/* loaded from: classes4.dex */
final class zzuv extends ThreadLocal {
    protected static final Cipher zza() {
        try {
            return (Cipher) zzvp.zza.zza("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
