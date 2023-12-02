package com.firebase.ui.auth.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.IdpResponse;

/* loaded from: classes3.dex */
public class FirebaseAuthUIAuthenticationResult {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final IdpResponse f17971a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Integer f17972b;

    public FirebaseAuthUIAuthenticationResult(@NonNull Integer num, @Nullable IdpResponse idpResponse) {
        this.f17971a = idpResponse;
        this.f17972b = num;
    }

    @Nullable
    public IdpResponse getIdpResponse() {
        return this.f17971a;
    }

    @NonNull
    public Integer getResultCode() {
        return this.f17972b;
    }

    public int hashCode() {
        int hashCode;
        IdpResponse idpResponse = this.f17971a;
        if (idpResponse == null) {
            hashCode = 0;
        } else {
            hashCode = idpResponse.hashCode();
        }
        return (hashCode * 31) + this.f17972b.hashCode();
    }

    public String toString() {
        return "FirebaseAuthUIAuthenticationResult{idpResponse=" + this.f17971a + ", resultCode='" + this.f17972b + '}';
    }
}
