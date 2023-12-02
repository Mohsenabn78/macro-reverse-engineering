package com.google.firebase.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth-interop@@20.0.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public interface InternalTokenProvider {
    @NonNull
    @KeepForSdk
    Task<GetTokenResult> getAccessToken(boolean z3);

    @Nullable
    @KeepForSdk
    String getUid();
}
