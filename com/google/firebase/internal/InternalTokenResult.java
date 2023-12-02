package com.google.firebase.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.firebase:firebase-auth-interop@@20.0.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class InternalTokenResult {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f31603a;

    @KeepForSdk
    public InternalTokenResult(@Nullable String str) {
        this.f31603a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof InternalTokenResult)) {
            return false;
        }
        return Objects.equal(this.f31603a, ((InternalTokenResult) obj).f31603a);
    }

    @Nullable
    @KeepForSdk
    public String getToken() {
        return this.f31603a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f31603a);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("token", this.f31603a).toString();
    }
}
