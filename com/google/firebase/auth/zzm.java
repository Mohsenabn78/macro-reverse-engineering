package com.google.firebase.auth;

import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzm extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhoneAuthOptions f29145a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks f29146b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29147c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.f29147c = firebaseAuth;
        this.f29145a = phoneAuthOptions;
        this.f29146b = onVerificationStateChangedCallbacks;
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String str) {
        this.f29146b.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.f29146b.onCodeSent(str, forceResendingToken);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.f29146b.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        int i4 = zzaas.zzb;
        if ((firebaseException instanceof FirebaseAuthException) && ((FirebaseAuthException) firebaseException).getErrorCode().endsWith("ALTERNATE_CLIENT_IDENTIFIER_REQUIRED")) {
            this.f29145a.zzj(true);
            "Re-triggering phone verification with Recaptcha flow forced for phone number ".concat(String.valueOf(this.f29145a.zzh()));
            this.f29147c.zzU(this.f29145a);
            return;
        }
        String zzh = this.f29145a.zzh();
        String message = firebaseException.getMessage();
        StringBuilder sb = new StringBuilder();
        sb.append("Invoking original failure callbacks after phone verification failure for ");
        sb.append(zzh);
        sb.append(", error - ");
        sb.append(message);
        this.f29146b.onVerificationFailed(firebaseException);
    }
}
