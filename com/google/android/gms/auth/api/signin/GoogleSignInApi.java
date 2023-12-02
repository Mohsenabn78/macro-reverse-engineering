package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public interface GoogleSignInApi {
    public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";

    Intent getSignInIntent(GoogleApiClient googleApiClient);

    @Nullable
    GoogleSignInResult getSignInResultFromIntent(Intent intent);

    PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient);

    PendingResult<Status> signOut(GoogleApiClient googleApiClient);

    OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient);
}
