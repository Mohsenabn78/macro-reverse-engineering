package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.EmailAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwt  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwt {
    private final EmailAuthCredential zza;
    @Nullable
    private final String zzb;

    public zzwt(EmailAuthCredential emailAuthCredential, @Nullable String str) {
        this.zza = emailAuthCredential;
        this.zzb = str;
    }

    public final EmailAuthCredential zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
