package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class PhoneMultiFactorAssertion extends MultiFactorAssertion {

    /* renamed from: a  reason: collision with root package name */
    private final PhoneAuthCredential f28935a;

    public PhoneMultiFactorAssertion(@NonNull PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(phoneAuthCredential);
        this.f28935a = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.MultiFactorAssertion
    @NonNull
    public String getFactorId() {
        return "phone";
    }

    @NonNull
    public final PhoneAuthCredential zza() {
        return this.f28935a;
    }
}
