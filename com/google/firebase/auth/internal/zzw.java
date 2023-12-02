package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.firebase.auth.FirebaseAuthSettings;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzw extends FirebaseAuthSettings {

    /* renamed from: a  reason: collision with root package name */
    private String f29096a;

    /* renamed from: b  reason: collision with root package name */
    private String f29097b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f29098c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29099d = false;

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void forceRecaptchaFlowForTesting(boolean z3) {
        this.f29099d = z3;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAppVerificationDisabledForTesting(boolean z3) {
        this.f29098c = z3;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAutoRetrievedSmsCodeForPhoneNumber(@Nullable String str, @Nullable String str2) {
        this.f29096a = str;
        this.f29097b = str2;
    }

    @Nullable
    public final String zza() {
        return this.f29096a;
    }

    @Nullable
    public final String zzb() {
        return this.f29097b;
    }

    public final boolean zzc() {
        return this.f29099d;
    }

    public final boolean zzd() {
        if (this.f29096a != null && this.f29097b != null) {
            return true;
        }
        return false;
    }

    public final boolean zze() {
        return this.f29098c;
    }
}
