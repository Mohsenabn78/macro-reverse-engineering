package com.google.firebase.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class GoogleAuthProvider {
    @NonNull
    public static final String GOOGLE_SIGN_IN_METHOD = "google.com";
    @NonNull
    public static final String PROVIDER_ID = "google.com";

    private GoogleAuthProvider() {
    }

    @NonNull
    public static AuthCredential getCredential(@Nullable String str, @Nullable String str2) {
        return new GoogleAuthCredential(str, str2);
    }
}
