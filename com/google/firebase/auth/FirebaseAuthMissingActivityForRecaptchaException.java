package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class FirebaseAuthMissingActivityForRecaptchaException extends FirebaseAuthException {
    public FirebaseAuthMissingActivityForRecaptchaException() {
        super("ERROR_MISSING_ACTIVITY", "App verification failed - a valid Activity is required to complete the Recaptcha flow");
    }
}
