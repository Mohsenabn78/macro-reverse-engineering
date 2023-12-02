package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public abstract class AuthCredential extends AbstractSafeParcelable {
    @NonNull
    public abstract String getProvider();

    @NonNull
    public abstract String getSignInMethod();

    @NonNull
    public abstract AuthCredential zza();
}
