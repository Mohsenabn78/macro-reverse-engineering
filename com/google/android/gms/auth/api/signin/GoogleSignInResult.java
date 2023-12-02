package com.google.android.gms.auth.api.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public class GoogleSignInResult implements Result {

    /* renamed from: a  reason: collision with root package name */
    private Status f19840a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f19841b;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.f19841b = googleSignInAccount;
        this.f19840a = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.f19841b;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f19840a;
    }

    public boolean isSuccess() {
        return this.f19840a.isSuccess();
    }
}
