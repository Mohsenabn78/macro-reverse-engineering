package com.google.firebase.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class TotpMultiFactorAssertion extends MultiFactorAssertion {

    /* renamed from: a  reason: collision with root package name */
    private final String f28941a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final TotpSecret f28942b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f28943c;

    public TotpMultiFactorAssertion(@NonNull String str, @Nullable TotpSecret totpSecret, @Nullable String str2) {
        this.f28941a = Preconditions.checkNotEmpty(str);
        this.f28942b = totpSecret;
        this.f28943c = str2;
    }

    @Override // com.google.firebase.auth.MultiFactorAssertion
    @NonNull
    public String getFactorId() {
        return TotpMultiFactorGenerator.FACTOR_ID;
    }

    @Nullable
    public final TotpSecret zza() {
        return this.f28942b;
    }

    @Nullable
    public final String zzb() {
        return this.f28943c;
    }

    @NonNull
    public final String zzc() {
        return this.f28941a;
    }
}
