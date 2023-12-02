package com.google.firebase.auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public interface AuthResult extends SafeParcelable {
    @Nullable
    AdditionalUserInfo getAdditionalUserInfo();

    @Nullable
    AuthCredential getCredential();

    @Nullable
    FirebaseUser getUser();
}
