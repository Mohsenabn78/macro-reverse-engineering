package com.google.firebase.auth;

import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public abstract class FirebaseAuthSettings {
    public abstract void forceRecaptchaFlowForTesting(boolean z3);

    public abstract void setAppVerificationDisabledForTesting(boolean z3);

    public abstract void setAutoRetrievedSmsCodeForPhoneNumber(@Nullable String str, @Nullable String str2);
}
