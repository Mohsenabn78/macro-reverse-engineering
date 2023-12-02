package com.firebase.ui.auth.ui.phone;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.firebase.auth.PhoneAuthCredential;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class PhoneVerification {

    /* renamed from: a  reason: collision with root package name */
    private final String f18182a;

    /* renamed from: b  reason: collision with root package name */
    private final PhoneAuthCredential f18183b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18184c;

    public PhoneVerification(@NonNull String str, @NonNull PhoneAuthCredential phoneAuthCredential, boolean z3) {
        this.f18182a = str;
        this.f18183b = phoneAuthCredential;
        this.f18184c = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PhoneVerification.class != obj.getClass()) {
            return false;
        }
        PhoneVerification phoneVerification = (PhoneVerification) obj;
        if (this.f18184c == phoneVerification.f18184c && this.f18182a.equals(phoneVerification.f18182a) && this.f18183b.equals(phoneVerification.f18183b)) {
            return true;
        }
        return false;
    }

    @NonNull
    public PhoneAuthCredential getCredential() {
        return this.f18183b;
    }

    @NonNull
    public String getNumber() {
        return this.f18182a;
    }

    public int hashCode() {
        return (((this.f18182a.hashCode() * 31) + this.f18183b.hashCode()) * 31) + (this.f18184c ? 1 : 0);
    }

    public boolean isAutoVerified() {
        return this.f18184c;
    }

    public String toString() {
        return "PhoneVerification{mNumber='" + this.f18182a + "', mCredential=" + this.f18183b + ", mIsAutoVerified=" + this.f18184c + '}';
    }
}
