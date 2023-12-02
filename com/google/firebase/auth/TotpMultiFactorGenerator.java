package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class TotpMultiFactorGenerator {
    @NonNull
    public static final String FACTOR_ID = "totp";

    private TotpMultiFactorGenerator() {
    }

    @NonNull
    public static Task<TotpSecret> generateSecret(@NonNull MultiFactorSession multiFactorSession) {
        Preconditions.checkNotNull(multiFactorSession);
        com.google.firebase.auth.internal.zzag zzagVar = (com.google.firebase.auth.internal.zzag) multiFactorSession;
        return FirebaseAuth.getInstance(zzagVar.zza().zza()).zzn(zzagVar);
    }

    @NonNull
    public static TotpMultiFactorAssertion getAssertionForEnrollment(@NonNull TotpSecret totpSecret, @NonNull String str) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str), (TotpSecret) Preconditions.checkNotNull(totpSecret), null);
    }

    @NonNull
    public static TotpMultiFactorAssertion getAssertionForSignIn(@NonNull String str, @NonNull String str2) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str2), null, (String) Preconditions.checkNotNull(str));
    }
}
