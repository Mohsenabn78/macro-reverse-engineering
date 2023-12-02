package com.google.firebase.auth;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class FirebaseAuthMultiFactorException extends FirebaseAuthException {
    private final MultiFactorResolver zza;

    public FirebaseAuthMultiFactorException(@NonNull String str, @NonNull String str2, @NonNull MultiFactorResolver multiFactorResolver) {
        super(str, str2);
        this.zza = multiFactorResolver;
    }

    @NonNull
    public MultiFactorResolver getResolver() {
        return this.zza;
    }
}
